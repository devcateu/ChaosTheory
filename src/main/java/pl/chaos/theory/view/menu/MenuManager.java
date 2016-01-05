package pl.chaos.theory.view.menu;

import org.springframework.stereotype.Component;
import pl.chaos.theory.security.SecurityUtil;
import pl.chaos.theory.util.Request;

@Request
@Component("menuManager")
/**
 * JSF managed bean, contains methods for informing about authentication level. It is using in menubar.
 */
public class MenuManager {

	/**
	 * Return information, that current user have any of roles.
	 *
	 * @param roles Checking roles.
	 * @return true - if current logged user has one of specific role, otherwise false.
	 */
	public boolean hasRole(String... roles) {
		return SecurityUtil.hasRole(roles);
	}

	/**
	 * Get information that current user is logged.
	 * @return true - if current user is logged, otherwise false.
	 */
	public boolean isAuthenticated() {
		return SecurityUtil.isAuthenticated();
	}
}
