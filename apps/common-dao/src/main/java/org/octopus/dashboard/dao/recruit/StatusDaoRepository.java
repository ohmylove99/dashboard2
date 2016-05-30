package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatusDaoRepository extends CrudRepository<Status, Long> {
	@Query("select s from Status s where s.isactive = 1")
	Iterable<Status> findAll();

	@Query("select s from Status s where s.isactive = 1 and s.dtype=?1")
	Iterable<Status> findByDtype(String dtype);
}
