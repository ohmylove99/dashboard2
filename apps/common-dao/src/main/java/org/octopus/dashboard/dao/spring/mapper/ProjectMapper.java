package org.octopus.dashboard.dao.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.octopus.dashboard.model.TProject;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ProjectMapper implements RowMapper {

	@Override
	public TProject mapRow(ResultSet rs, int rowNum) throws SQLException {

		TProject t = new TProject();

		t.setId(rs.getLong("ID"));
		t.setName(rs.getString("TITLE"));

		return t;
	}

}
