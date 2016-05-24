package org.octopus.dashboard.dao.recruit;

import org.octopus.dashboard.model.recruit.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDaoRepository extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
