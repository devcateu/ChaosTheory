package pl.chaos.theory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import pl.chaos.theory.configuration.JSFInitializer;
import pl.chaos.theory.h2.H2Console;
import pl.chaos.theory.security.SecurityConfiguration;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@Import({H2Console.class, SecurityConfiguration.class})
public class ChaosTheoryApplication extends SpringBootServletInitializer {

	@Value("${init.json}")
	private String init;

	public static void main(String[] args) {
		SpringApplication.run(ChaosTheoryApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChaosTheoryApplication.class, JSFInitializer.class, SecurityConfiguration.class, H2Console.class);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean FileUploadFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new org.primefaces.webapp.filter.FileUploadFilter());
		registration.setName("PrimeFaces FileUpload Filter");
		return registration;
	}

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
		Resource sourceData;
		Jackson2RepositoryPopulatorFactoryBean factory;
		try {
			sourceData = new PathResource(init);
			if (!sourceData.exists()) {
				sourceData = new ClassPathResource(init);
			}
			factory = new Jackson2RepositoryPopulatorFactoryBean();
			factory.setResources(new Resource[]{sourceData});
		} catch (Exception e) {
			return null;
		}

		return factory;
	}

}
