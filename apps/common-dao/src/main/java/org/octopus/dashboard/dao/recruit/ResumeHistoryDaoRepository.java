package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.ResumeHistory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResumeHistoryDaoRepository
		extends PagingAndSortingRepository<ResumeHistory, Long>, JpaSpecificationExecutor<ResumeHistory> {

}
