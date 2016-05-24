package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobDaoRepository extends PagingAndSortingRepository<Job, Long> {
	Job findByName(String name);
}
