package pl.chaos.theory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;

@Component
@Service
/**
 * Allow Spring security to load user during logging into system.
 */
public class CurrentUserDetailsService implements UserDetailsService {
	private final UserService userService;

	@Autowired
	public CurrentUserDetailsService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDto user = userService.getUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
		}
		String hashedPassword = userService.getHashedPassword(email);
		return new CurrentUser(user, hashedPassword);
	}
}
