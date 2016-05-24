package org.octopus.dashboard.dao.spring.impl;

import java.util.List;

import org.octopus.dashboard.dao.spring.ProjectDao;
import org.octopus.dashboard.dao.spring.mapper.ProjectMapper;
import org.octopus.dashboard.model.TProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ProjectDaoImpl extends BaseSpringDao implements ProjectDao {

	private static Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

	@Override
	public void initDao() {
		if (logger.isDebugEnabled())
			logger.debug("init() - Start");

		initStatements("org/octopus/dashboard/dao/spring/impl/ProjectDaoImpl");

		if (logger.isDebugEnabled())
			logger.debug("init() - End");
	}

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

	public boolean save(TProject t) {

		if (logger.isDebugEnabled()) {
			logger.debug("saveProject( " + t.toString() + ")");
		}
		int update;
		try {
			if (t.getId() > 0)
				update = getJdbcTemplate().update(getStatement("update.project"), new Object[] { t.getName() });
			else
				update = getJdbcTemplate().update(getStatement("insert.project"), new Object[] { t.getName() });
			return update > 0;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long id) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteProject( " + id + ")");
		}
		int update;
		try {
			update = getJdbcTemplate().update(getStatement("delete.project"), new Object[] { id });
			return true;
		} catch (DataAccessException ex) {
			logger.error("Error executing query: " + ex.getClass() + ":" + ex.getMessage());
			return false;
		}
	}

}
