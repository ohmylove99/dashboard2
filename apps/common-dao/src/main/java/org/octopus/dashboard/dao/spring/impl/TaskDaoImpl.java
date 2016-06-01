package org.octopus.dashboard.dao.spring.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.octopus.dashboard.dao.spring.TaskDao;
import org.octopus.dashboard.dao.spring.mapper.TaskMapper;
import org.octopus.dashboard.model.TTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class TaskDaoImpl extends BaseSpringDao implements TaskDao {

	private static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);
	private SimpleJdbcInsert insertActor;

	@Override
	public void initDao() {
		if (logger.isDebugEnabled())
			logger.debug("init() - Start");

		initStatements("org/octopus/dashboard/dao/spring/impl/TaskDaoImpl");

		this.insertActor = new SimpleJdbcInsert(this.getJdbcTemplate().getDataSource()).withTableName("tt_task")
				.usingGeneratedKeyColumns("id");

		if (logger.isDebugEnabled())
			logger.debug("init() - End");
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public TTask get(long id) {

		if (logger.isDebugEnabled()) {
			logger.debug("get task(" + id + ")");
		}

		try {
			return (TTask) getJdbcTemplate().queryForObject(getStatement("select.task"),
					new Object[] { Long.valueOf(id) }, new TaskMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<TTask> gets() {
		if (logger.isDebugEnabled()) {
			logger.debug("get tasks()");
		}

		try {
			return getJdbcTemplate().query(getStatement("select.tasks"), new TaskMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	public boolean save(TTask t) {

		if (logger.isDebugEnabled()) {
			logger.debug("save Task( " + t.toString() + ")");
		}
		int update;
		try {
			if (t.getId() > 0) {
				update = getJdbcTemplate().update(getStatement("update.task"), new Object[] { t.getName() });
				logger.info("save Task( " + t.toString() + "), updated[" + update + "]");
			} else {
				add(t);
				logger.info("save Task( " + t.toString() + "), insert[" + t.getId() + "]");
			}
			return true;
		} catch (

		DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

	public void add(TTask t) {
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("NAME", t.getName());
		parameters.put("VERSION", 1);
		Number newId = insertActor.executeAndReturnKey(parameters);
		t.setId(newId.longValue());
		t.setVersion(1);
	}

	@Override
	public boolean delete(long id) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteTask( " + id + ")");
		}
		int update;
		try {
			update = getJdbcTemplate().update(getStatement("delete.task"), new Object[] { id });
			return update > 0;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

}
