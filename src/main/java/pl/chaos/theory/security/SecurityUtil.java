package pl.chaos.theory.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Util class for security.
 */
public class SecurityUtil {

	/**
	 * Return information, that current user have any of roles.
	 *
	 * @param roles Checking roles.
	 * @return true - if current logged user has one of specific role, otherwise false.
	 */
	public static boolean hasRole(String... roles) {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return false;
		}

		List<String> rolesList = Arrays.asList(roles);
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (rolesList.contains(auth.getAuthority())) {
				return true;
			}
		}

		return false;
	}

	public static boolean isAuthenticated() {
		Authentication authentication = getAuthentication();
		return authentication == null || !(authentication instanceof AnonymousAuthenticationToken);
	}

	/**
	 * Get information that current user is logged.
	 * @return true - if current user is logged, otherwise false.
	 */
	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return null;
		}

		return context.getAuthentication();
	}
}
