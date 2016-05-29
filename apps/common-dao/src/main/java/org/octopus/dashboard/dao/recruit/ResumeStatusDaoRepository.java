package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.ResumeStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ResumeStatusDaoRepository extends CrudRepository<ResumeStatus, Long> {
	@Query("select s from ResumeStatus s where s.isactive = 1 ")
	Iterable<ResumeStatus> findAll();
}
