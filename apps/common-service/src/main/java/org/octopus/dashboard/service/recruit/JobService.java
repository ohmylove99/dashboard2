package org.octopus.dashboard.service.recruit;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.octopus.dashboard.dao.recruit.JobDaoRepository;
import org.octopus.dashboard.dao.recruit.ResumeDaoRepository;
import org.octopus.dashboard.model.recruit.Job;
import org.octopus.dashboard.service.recruit.account.ShiroDbRealm.ShiroUser;
import org.octopus.dashboard.shared.utils.clock.ClockFactory;
import org.octopus.dashboard.shared.utils.clock.IClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JobService {

	private JobDaoRepository jobDao;
	private ResumeDaoRepository resumeDao;
	private IClock clock = ClockFactory.getClock();

	public List<Job> getAllJob() {
		return (List<Job>) jobDao.findAll();
	}

	public Job getJob(Long id) {
		return jobDao.findOne(id);
	}

	public Job findJobByName(String name) {
		return jobDao.findByName(name);
	}

	public void registerJob(Job Job) {

		Job.setOpenBy(getCurrentUserName());
		Job.setOpenTime(clock.getCurrentDate());

		jobDao.save(Job);
	}

	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	public void updateJob(Job Job) {
		jobDao.save(Job);
	}

	public void deleteJob(Long id) {
		jobDao.delete(id);
		resumeDao.deleteByJobId(id);

	}

	@Autowired
	public void setJobDao(JobDaoRepository jobDao) {
		this.jobDao = jobDao;
	}
}
