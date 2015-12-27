package pl.chaos.theory.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SecurityUtil {

	public static boolean hasRole(String... roles) {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return false;
		}

		List<String> rolesList = Arrays.asList(roles);
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
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

	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return null;
		}

		return context.getAuthentication();
	}
}
