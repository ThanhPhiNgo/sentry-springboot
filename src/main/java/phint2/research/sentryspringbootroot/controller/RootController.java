package phint2.research.sentryspringbootroot.controller;

import io.sentry.IHub;
import io.sentry.Sentry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import phint2.research.sentryspringbootroot.entity.Test;
import phint2.research.sentryspringbootroot.service.SentryService;

@RestController
public class RootController {

	final RestTemplate restTemplate;
	final SentryService sentryService;
	@Autowired
	final IHub hub;

	@Autowired
	public RootController(RestTemplate restTemplate, SentryService sentryService, IHub hub) {
		this.restTemplate = restTemplate;
		this.sentryService = sentryService;
		this.hub = hub;
	}

	@GetMapping("/root")
	public String getData() {

		sentryService.saveData();

		String url = "http://localhost:8081/child";
		Sentry.setExtra("content",
				"Test use sentry static function");
		ResponseEntity<String> response =
				restTemplate.getForEntity(url, String.class);
		Sentry.setTag("useSentry", "true");
		Sentry.addBreadcrumb("call spring boot child");

		sentryService.getData();
		return response.getBody();
	}

	@GetMapping("/root2")
	public String getData2() {

		sentryService.saveData();

		String url = "http://localhost:8081/child";
		hub.setExtra("content",
				"Test use sentry static function");
		ResponseEntity<String> response =
				restTemplate.getForEntity(url, String.class);
		hub.setTag("useSentry", "true");
		hub.addBreadcrumb("call spring boot child");

		sentryService.getData();
		return response.getBody();
	}
}
