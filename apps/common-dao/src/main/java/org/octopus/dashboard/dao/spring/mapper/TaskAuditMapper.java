package org.octopus.dashboard.dao.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.octopus.dashboard.model.TTaskAudit;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class TaskAuditMapper implements RowMapper {

	@Override
	public TTaskAudit mapRow(ResultSet rs, int rowNum) throws SQLException {

		TTaskAudit t = new TTaskAudit();

		t.setId(rs.getLong("ID"));

		t.setPid(rs.getLong("PID"));

		t.setVersion(rs.getLong("VERSION"));
		t.setName(rs.getString("TASK"));
		t.setUpdatedBy(rs.getString("UPDATED_BY"));
		t.setUpdatedTime(rs.getTimestamp("UPDATED_TIME"));

		return t;
	}

}
