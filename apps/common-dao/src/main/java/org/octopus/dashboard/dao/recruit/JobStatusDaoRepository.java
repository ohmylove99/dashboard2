package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.JobStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobStatusDaoRepository extends CrudRepository<JobStatus, Long> {
	@Query("select s from JobStatus s where s.isactive = 1 ")
	Iterable<JobStatus> findAll();
}
