package org.octopus.dashboard.dao.spring.impl;

import java.util.List;

import org.octopus.dashboard.dao.spring.TaskAuditDao;
import org.octopus.dashboard.dao.spring.mapper.TaskAuditMapper;
import org.octopus.dashboard.model.TTaskAudit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class TaskAuditDaoImpl extends BaseSpringDao implements TaskAuditDao {

	private static Logger logger = LoggerFactory.getLogger(TaskAuditDaoImpl.class);

	@Override
	public void initDao() {
		if (logger.isDebugEnabled())
			logger.debug("init() - Start");

		initStatements("org/octopus/dashboard/dao/spring/impl/TaskAuditDaoImpl");

		if (logger.isDebugEnabled())
			logger.debug("init() - End");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public TTaskAudit get(long id) {

		if (logger.isDebugEnabled()) {
			logger.debug("gettaskAudit(" + id + ")");
		}

		try {
			return (TTaskAudit) getJdbcTemplate().queryForObject(getStatement("select.taskAudit"),
					new Object[] { Long.valueOf(id) }, new TaskAuditMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<TTaskAudit> gets() {
		if (logger.isDebugEnabled()) {
			logger.debug("get TaskAudits()");
		}

		try {
			return getJdbcTemplate().query(getStatement("select.taskAudits"), new TaskAuditMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	public boolean add(TTaskAudit t) {

		if (logger.isDebugEnabled()) {
			logger.debug("add taskAudit( " + t.toString() + ")");
		}

		try {
			getJdbcTemplate().update(getStatement("insert.taskAudit"), new Object[] { t.getName(),  t.getPid() , t.getVersion()});
			return true;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}
}
