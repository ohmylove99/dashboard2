package org.octopus.dashboard.dao.spring;

import java.util.List;

import org.octopus.dashboard.model.TTaskAudit;

public interface TaskAuditDao {

	public TTaskAudit get(long id);

	public List<TTaskAudit> gets();

	// Audit only insert
	public boolean add(TTaskAudit t);
}
