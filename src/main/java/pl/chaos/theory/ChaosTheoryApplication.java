package pl.chaos.theory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import pl.chaos.theory.configuration.JSFInitializer;
import pl.chaos.theory.h2.H2Console;
import pl.chaos.theory.security.SecurityConfiguration;

@SpringBootApplication
@Import({H2Console.class, SecurityConfiguration.class})
public class ChaosTheoryApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChaosTheoryApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChaosTheoryApplication.class, JSFInitializer.class, SecurityConfiguration.class, H2Console.class);
	}
}
