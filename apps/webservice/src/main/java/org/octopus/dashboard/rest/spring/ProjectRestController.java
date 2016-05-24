package org.octopus.dashboard.rest.spring;

import java.net.URI;
import java.util.List;

import javax.validation.Validator;

import org.octopus.dashboard.model.TProject;
import org.octopus.dashboard.rest.RestException;
import org.octopus.dashboard.service.spring.ProjectService;
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
@RequestMapping(value = "/api/v1/project")
public class ProjectRestController {

	private static Logger logger = LoggerFactory.getLogger(ProjectRestController.class);

	@Autowired
	private ProjectService projectServiceImpl;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<TProject> list() {
		return projectServiceImpl.gets();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public TProject get(@PathVariable("id") Long id) {
		TProject task = projectServiceImpl.get(id);
		if (task == null) {
			String message = "not found (id:" + id + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return task;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody TProject task, UriComponentsBuilder uriBuilder) {

		BeanValidators.validateWithException(validator, task);

		projectServiceImpl.save(task);

		Long id = task.getId();
		URI uri = uriBuilder.path("/api/v1/task/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody TProject task) {

		BeanValidators.validateWithException(validator, task);

		projectServiceImpl.save(task);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		projectServiceImpl.delete(id);
	}
}
