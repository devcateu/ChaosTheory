package pl.chaos.theory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();

		httpSecurity.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/javax.faces.resource/**").permitAll()
				.antMatchers("/console/*").permitAll()
				.antMatchers("/register.jsf", "/login.jsf").not().authenticated()
				.antMatchers("/roles.jsf").hasAuthority(Role.ADMIN.name())
				.antMatchers("/enter.jsf").hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
				.anyRequest().fullyAuthenticated()
				.and()
				.formLogin()
				.loginPage("/login.jsf")
				.failureUrl("/login.jsf?error=wrong")
				.defaultSuccessUrl("/index.jsf")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll(false)
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login.jsf")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/index.jsf");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService);
	}

}
