package org.octopus.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class TTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6547092022795244411L;

	private long id;
	private long version;

	private String name;

	private String updatedBy;
	private Date updatedTime;

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TTaskAudit createAudit() {
		TTaskAudit t = new TTaskAudit();

		t.setVersion(this.getVersion());
		t.setName(this.getName());
		t.setUpdatedBy(this.getUpdatedBy());
		t.setUpdatedTime(this.getUpdatedTime());

		t.setPid(this.getId());

		return t;
	}
}
