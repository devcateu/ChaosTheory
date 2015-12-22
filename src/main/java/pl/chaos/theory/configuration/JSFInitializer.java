package pl.chaos.theory.configuration;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class JSFInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.err.println("------------------------------------");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("primefaces.THEME", "le-frog");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
	}

}
