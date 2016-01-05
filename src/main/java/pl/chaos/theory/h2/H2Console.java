package pl.chaos.theory.h2;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.chaos.theory.Profiles;

@Profile(value = Profiles.DEVELOPMENT)
@Configuration
/**
 * Configuration which allow access to h2Console from browser.
 */
public class H2Console {
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/console/*");

		return registration;
	}
}
