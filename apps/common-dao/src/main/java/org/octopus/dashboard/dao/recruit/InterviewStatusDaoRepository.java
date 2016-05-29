package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.InterviewStatus;
import org.springframework.data.repository.CrudRepository;

public interface InterviewStatusDaoRepository extends CrudRepository<InterviewStatus, Long> {
}
