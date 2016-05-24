package org.octopus.dashboard.dao.spring;

import java.util.List;

import org.octopus.dashboard.model.TProject;

public interface ProjectDao {

	public TProject getProject(long id);

	public List<TProject> getProjects();

	public boolean addProject(TProject t);
}
