package pl.chaos.theory.configuration;

import com.sun.faces.config.ConfigureListener;
import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

import javax.el.ELResolver;
import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
/**
 * Configuration of JSF.
 * Move all possible element from web.xml and faces-config.xml into it. Thanks that we have more control over it and don`t use awful xml.
 */
public class JSFInitializer implements ServletContextAware, ServletContextInitializer {

	private final static String facesServlet = "Faces Servlet";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("primefaces.THEME", "le-frog");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("primefaces.UPLOADER", "commons");
	}

	@Bean
	public FilterRegistrationBean FileUploadFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		FileUploadFilter filter = new FileUploadFilter();
		registration.setFilter(filter);
		registration.setName("PrimeFaces FileUpload Filter");
		registration.addUrlPatterns("/*");
		registration.addServletNames(facesServlet);
		return registration;
	}

	@Bean
	public FilterRegistrationBean springSecurityJSFFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
		registration.setFilter(filterProxy);
		registration.setName("springSecurityFilterChain");
		registration.addUrlPatterns("/*");
		registration.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST);
		return registration;
	}

	@Bean
	public ServletRegistrationBean facesServlet() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "*.jsf");
		registration.setName(facesServlet);
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ELResolver elResolver() {
		return new SpringBeanFacesELResolver();
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}
}
