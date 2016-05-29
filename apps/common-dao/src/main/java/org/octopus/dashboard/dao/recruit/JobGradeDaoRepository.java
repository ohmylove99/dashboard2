package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.JobGrade;
import org.springframework.data.repository.CrudRepository;

public interface JobGradeDaoRepository extends CrudRepository<JobGrade, Long> {
}
