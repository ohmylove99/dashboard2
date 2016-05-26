package org.octopus.dashboard.dao.spring;

import java.util.List;

import org.octopus.dashboard.model.TTask;

public interface TaskDao {

	public TTask get(long id);

	public List<TTask> gets();

	public boolean save(TTask t);
	
	public boolean delete(long id);
}
