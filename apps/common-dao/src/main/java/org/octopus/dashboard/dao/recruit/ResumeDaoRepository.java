package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.Resume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResumeDaoRepository extends PagingAndSortingRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {
	Page<Resume> findByJobId(Long id, Pageable pageRequest);

	@Modifying
	@Query("delete from Resume resume where resume.job.id=?1")
	void deleteByJobId(Long id);
}
