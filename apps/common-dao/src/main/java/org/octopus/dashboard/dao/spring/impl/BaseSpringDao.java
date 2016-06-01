package org.octopus.dashboard.dao.spring.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.InvariantReloadingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseSpringDao implements InitializingBean {

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static Logger logger = LoggerFactory.getLogger(BaseSpringDao.class);

	protected PropertiesConfiguration statements;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void initDao() {
		if (logger.isDebugEnabled())
			logger.debug("init() - Start");

		initStatements("dao");

		if (logger.isDebugEnabled())
			logger.debug("init() - End");
	}

	/**
	 * Sets up our tables
	 */
	protected void initTables() {
		try {
			jdbcTemplate.execute(getStatement("create.table"));
		} catch (DataAccessException ex) {
			logger.info("Error creating tables: " + ex.getClass() + ":" + ex.getMessage());
		}
	}

	/**
	 * Loads our SQL statements from the appropriate properties file
	 * 
	 * @param vendor
	 *            DB vendor string. Must be one of mysql, oracle, hsqldb
	 */
	protected void initStatements(String classPath) {

		URL url = getClass().getClassLoader().getResource(classPath + ".properties");
		InputStream is = null;
		try {
			statements = new PropertiesConfiguration();
			// not watch reload
			statements.setReloadingStrategy(new InvariantReloadingStrategy());
			statements.setThrowExceptionOnMissing(true);
			statements.setDelimiterParsingDisabled(true);

			if (url == null || url.getFile().indexOf("!") > 0) {
				is = getClass().getClassLoader().getResourceAsStream("/" + classPath + ".properties");
				statements.load(is);
			} else {
				statements.load(url);
			}

		} catch (ConfigurationException e) {
			logger.error(e.getClass() + ": " + e.getMessage());
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e.getClass() + ": " + e.getMessage());
				}
		}
	}

	/**
	 * Get an SQL statement for the appropriate vendor from the bundle
	 * 
	 * @param key
	 * @return statement or null if none found.
	 */
	protected String getStatement(String key) {
		try {
			return statements.getString(key);
		} catch (NoSuchElementException e) {
			logger.error("Statement: '" + key + "' could not be found in: " + statements.getFileName());
			return StringUtils.EMPTY;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initDao();
	}
}
