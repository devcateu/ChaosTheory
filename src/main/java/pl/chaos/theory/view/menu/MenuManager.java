package pl.chaos.theory.view.menu;

import org.springframework.stereotype.Component;
import pl.chaos.theory.security.SecurityUtil;
import pl.chaos.theory.util.Request;

@Request
@Component("menuManager")
public class MenuManager {

	public boolean hasRole(String... roles) {
		return SecurityUtil.hasRole(roles);
	}

	public boolean isAuthenticated() {
		return SecurityUtil.isAuthenticated();
	}
}
