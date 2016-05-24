package org.octopus.dashboard.service.spring.impl;

import org.octopus.dashboard.dao.spring.TaskAuditDao;
import org.octopus.dashboard.dao.spring.TaskDao;
import org.octopus.dashboard.model.TTask;
import org.octopus.dashboard.service.spring.TaskService;

public class TaskServiceImpl implements TaskService {
	private TaskDao taskDao;
	private TaskAuditDao taskAuditDao;

	@Override
	public boolean save(TTask task) {
		taskDao.save(task);
		taskAuditDao.add(task.createAudit());
		return false;
	}

}
