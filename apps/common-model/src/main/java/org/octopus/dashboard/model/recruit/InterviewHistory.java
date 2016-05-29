package org.octopus.dashboard.model.recruit;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ss_interviewhis")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "InterviewHistory.findAll", query = "SELECT j FROM InterviewHistory j")
public class InterviewHistory extends IdAuditEntity {

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInterviewBy() {
		return interviewBy;
	}

	public void setInterviewBy(String interviewBy) {
		this.interviewBy = interviewBy;
	}

	protected String round;
	protected String comments;
	protected String interviewBy;
	protected String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
