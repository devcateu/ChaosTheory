package pl.chaos.theory;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import pl.chaos.theory.configuration.JSFInitializer;
import pl.chaos.theory.h2.H2Console;
import pl.chaos.theory.security.SecurityConfiguration;
import pl.chaos.theory.util.ViewScope;

@SpringBootApplication
@Import({H2Console.class, SecurityConfiguration.class})
/**
 * Main application class, start application server and configure Spring context.
 */
public class ChaosTheoryApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChaosTheoryApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChaosTheoryApplication.class, JSFInitializer.class, SecurityConfiguration.class, H2Console.class);
	}

	@Bean
	public CustomScopeConfigurer customScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		ViewScope viewScope = new ViewScope();
		configurer.addScope(viewScope.getConversationId(), viewScope);

		return configurer;
	}
}
