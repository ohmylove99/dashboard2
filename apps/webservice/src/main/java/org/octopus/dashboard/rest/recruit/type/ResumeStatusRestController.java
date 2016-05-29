package org.octopus.dashboard.rest.recruit.type;

import java.net.URI;
import java.util.List;

import org.octopus.dashboard.model.recruit.ResumeStatus;
import org.octopus.dashboard.rest.RestException;
import org.octopus.dashboard.service.recruit.TypeService;
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
@RequestMapping(value = "/api/v1/type/resumestatus")
public class ResumeStatusRestController {

	private static Logger logger = LoggerFactory.getLogger(ResumeStatusRestController.class);

	@Autowired
	private TypeService typeService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<ResumeStatus> list() {
		return typeService.getAllResumeStatus();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public ResumeStatus get(@PathVariable("id") Long id) {
		ResumeStatus interviewStatus = typeService.getResumeStatus(id);
		if (interviewStatus == null) {
			String message = "not found (id:" + id + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return interviewStatus;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody ResumeStatus interviewStatus, UriComponentsBuilder uriBuilder) {

		typeService.saveResumeStatus(interviewStatus);

		Long id = interviewStatus.getId();
		URI uri = uriBuilder.path("/api/v1/type/interviewStatus/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody ResumeStatus interviewStatus) {
		typeService.saveResumeStatus(interviewStatus);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		typeService.deleteResumeStatus(id);
	}
}
