package org.octopus.dashboard.model.recruit;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ss_job")
@NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
public class Job extends IdAuditEntity {

	protected String name;
	protected String description;
	protected String grade;
	protected String referenceid;

	protected String emptype;
	protected Date openTime;
	protected Date closedTime;
	protected String openBy;
	protected String openByBiz;
	protected String interviewer;
	protected String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	@Column(name = "closed_by")
	protected String closedBy;

	protected Long version;

	// bi-directional many-to-many association to Resume
	@ManyToMany
	@JoinTable(name = "ss_job2resume", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
			@JoinColumn(name = "resume_id") })
	private List<Resume> resumes;

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

	public String getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
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

	public String getOpenByBiz() {
		return openByBiz;
	}

	public void setOpenByBiz(String openByBiz) {
		this.openByBiz = openByBiz;
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

	public JobHistory createAudit() {
		JobHistory t = new JobHistory();

		t.setVersion(this.getVersion());
		t.setName(this.getName());
		t.setUpdatedBy(this.getUpdatedBy());
		t.setUpdatedTime(this.getUpdatedTime());

		t.setName(this.getName());
		t.setDescription(this.getDescription());
		t.setGrade(this.getGrade());

		t.setOpenBy(this.getOpenBy());
		t.setOpenByBiz(this.getOpenByBiz());

		t.setStatus(this.getStatus());

		t.setPid(this.getId().toString());

		return t;
	}
}
