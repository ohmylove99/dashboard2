package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.JobHistory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobHistoryRepository
		extends PagingAndSortingRepository<JobHistory, Long>, JpaSpecificationExecutor<JobHistory> {

}
