package org.octopus.dashboard.model.recruit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ss_jobhis")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "JobHistory.findAll", query = "SELECT j FROM JobHistory j")
public class JobHistory extends IdAuditEntity {

	protected String name;
	protected String description;
	protected String grade;
	protected Date openTime;
	protected Date closedTime;
	protected String openBy;
	protected String closedBy;
	protected String openByBiz;
	protected String interviewer;
	protected String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpenByBiz() {
		return openByBiz;
	}

	public void setOpenByBiz(String openByBiz) {
		this.openByBiz = openByBiz;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	//
	protected String pid;
	protected Long version;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getClosedTime() {
		return closedTime;
	}

	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}

	public String getOpenBy() {
		return openBy;
	}

	public void setOpenBy(String openBy) {
		this.openBy = openBy;
	}

	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
