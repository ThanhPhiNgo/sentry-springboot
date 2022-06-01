package phint2.research.sentryspringbootroot.config;

import io.sentry.IHub;
import io.sentry.spring.tracing.SentrySpanClientHttpRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class AppConfig {

	@Bean
	RestTemplate restTemplate(IHub hub) {
		RestTemplate restTemplate = new RestTemplate();
		SentrySpanClientHttpRequestInterceptor sentryRestTemplateInterceptor =
				new SentrySpanClientHttpRequestInterceptor(hub);
		restTemplate.setInterceptors(Collections.singletonList(sentryRestTemplateInterceptor));
		return restTemplate;
	}
}
