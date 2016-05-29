package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.InterviewHistory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterviewHistoryRepository
		extends PagingAndSortingRepository<InterviewHistory, Long>, JpaSpecificationExecutor<InterviewHistory> {

}
