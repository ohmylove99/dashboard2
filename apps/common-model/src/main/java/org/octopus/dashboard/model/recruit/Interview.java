package org.octopus.dashboard.model.recruit;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ss_interview")
@NamedQuery(name = "Interview.findAll", query = "SELECT j FROM Interview j")
public class Interview extends IdAuditEntity {

	protected String round;
	protected String comments;
	protected String interviewBy;
	protected String status;
	protected Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public InterviewHistory createAudit() {
		InterviewHistory t = new InterviewHistory();

		t.setVersion(this.getVersion());

		t.setUpdatedBy(this.getUpdatedBy());
		t.setUpdatedTime(this.getUpdatedTime());

		t.setRound(this.getRound());
		t.setComments(this.getComments());
		t.setInterviewBy(this.getInterviewBy());

		t.setPid(this.getId().toString());

		return t;
	}
}
