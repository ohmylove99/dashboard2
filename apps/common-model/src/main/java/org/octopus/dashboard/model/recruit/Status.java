package org.octopus.dashboard.model.recruit;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ss_m_status")
public class Status extends IdEntity {

	private String name;

	private String description;

	private String dtype;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
