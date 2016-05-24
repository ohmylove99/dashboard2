package org.octopus.dashboard.dao.spring.impl;

import java.util.List;

import org.octopus.dashboard.dao.spring.ProjectDao;
import org.octopus.dashboard.dao.spring.mapper.ProjectMapper;
import org.octopus.dashboard.model.TProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

public class ProjectDaoImpl extends BaseSpringDao implements ProjectDao {

	private static Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public TProject getProject(long id) {

		if (logger.isDebugEnabled()) {
			logger.debug("getproject(" + id + ")");
		}

		try {
			return (TProject) getJdbcTemplate().queryForObject(getStatement("select.project"),
					new Object[] { Long.valueOf(id) }, new ProjectMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<TProject> getProjects() {
		if (logger.isDebugEnabled()) {
			logger.debug("getprojects()");
		}

		try {
			return getJdbcTemplate().query(getStatement("select.projects"), new ProjectMapper());
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return null;
		}
	}

	public boolean addProject(TProject t) {

		if (logger.isDebugEnabled()) {
			logger.debug("addProject( " + t.toString() + ")");
		}

		try {
			getJdbcTemplate().update(getStatement("insert.project"), new Object[] { t.getName() });
			return true;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

}
