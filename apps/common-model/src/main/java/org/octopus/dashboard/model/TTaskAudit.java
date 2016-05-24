package org.octopus.dashboard.model;

public class TTaskAudit extends TTask {

	private static final long serialVersionUID = -4559570988048958522L;
	/*
	 * This is related to parent task id
	 */
	private long pid;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}
}
