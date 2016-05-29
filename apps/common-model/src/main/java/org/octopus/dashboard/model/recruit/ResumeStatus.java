package org.octopus.dashboard.model.recruit;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "ss_m_jobstatus")
public class ResumeStatus extends IdEntity {

	private String name;

	private Long isactive;

	public Long getIsactive() {
		return isactive;
	}

	public void setIsactive(Long isactive) {
		this.isactive = isactive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
