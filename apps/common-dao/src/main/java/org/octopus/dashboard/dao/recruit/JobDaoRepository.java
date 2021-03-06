package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.Job;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobDaoRepository extends PagingAndSortingRepository<Job, Long>, JpaSpecificationExecutor<Job> {
	Job findByName(String name);
}
