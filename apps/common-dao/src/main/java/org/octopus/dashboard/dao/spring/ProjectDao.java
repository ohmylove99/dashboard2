package org.octopus.dashboard.dao.spring;

import java.util.List;

import org.octopus.dashboard.model.TProject;

public interface ProjectDao {

	public TProject get(long id);

	public List<TProject> gets();

	public boolean save(TProject t);

	public boolean delete(long id);
}
