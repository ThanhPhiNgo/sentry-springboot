package phint2.research.sentryspringbootroot;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentrySpringBootRootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentrySpringBootRootApplication.class, args);
		try {
			throw new Exception("Spring boot test 2");
		} catch (Exception e) {
			Sentry.captureException(e);
		}
	}

}
