package org.octopus.dashboard.dao.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.octopus.dashboard.model.TTask;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class TaskMapper implements RowMapper {

	@Override
	public TTask mapRow(ResultSet rs, int rowNum) throws SQLException {

		TTask t = new TTask();

		t.setId(rs.getLong("ID"));
		t.setVersion(rs.getLong("VERSION"));
		t.setName(rs.getString("NAME"));
		t.setUpdatedBy(rs.getString("UPDATED_BY"));
		t.setUpdatedTime(rs.getTimestamp("UPDATED_TIME"));

		return t;
	}

}
