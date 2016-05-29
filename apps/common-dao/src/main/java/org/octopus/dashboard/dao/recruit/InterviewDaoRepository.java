package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.Interview;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterviewDaoRepository
		extends PagingAndSortingRepository<Interview, Long>, JpaSpecificationExecutor<Interview> {
	Interview findByComments(String comment);
}
