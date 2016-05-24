package org.octopus.dashboard.dao.spring.impl;

import java.util.List;

import org.octopus.dashboard.dao.spring.TaskDao;
import org.octopus.dashboard.dao.spring.mapper.TaskMapper;
import org.octopus.dashboard.model.TTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class TaskDaoImpl extends BaseSpringDao implements TaskDao {

	private static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

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
			if (t.getId() > 0)
				update = getJdbcTemplate().update(getStatement("update.task"), new Object[] { t.getName() });
			else
				update = getJdbcTemplate().update(getStatement("insert.task"), new Object[] { t.getName() });
			logger.info("save Task( " + t.toString() + "), updated[" + update + "]");
			return true;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

}
