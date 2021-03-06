package org.octopus.dashboard.rest.recruit;

import java.net.URI;
import java.util.List;

import javax.validation.Validator;

import org.octopus.dashboard.model.recruit.Job;
import org.octopus.dashboard.rest.RestException;
import org.octopus.dashboard.service.recruit.JobService;
import org.octopus.dashboard.shared.beanvalidator.BeanValidators;
import org.octopus.dashboard.shared.constants.MediaTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/v1/job")
public class JobRestController {

	private static Logger logger = LoggerFactory.getLogger(JobRestController.class);

	@Autowired
	private JobService jobService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Job> list() {
		return jobService.getAllJob();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Job get(@PathVariable("id") Long id) {
		Job job = jobService.getJob(id);
		if (job == null) {
			String message = "not found (id:" + id + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return job;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody Job job, UriComponentsBuilder uriBuilder) {

		BeanValidators.validateWithException(validator, job);

		jobService.createJob(job);

		Long id = job.getId();
		URI uri = uriBuilder.path("/api/v1/job/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Job job) {

		BeanValidators.validateWithException(validator, job);

		jobService.updateJob(job);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		jobService.deleteJob(id);
	}
}
