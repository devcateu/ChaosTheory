package pl.chaos.theory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.db.repository.UserRepository;

@Component
@Service
public class CurrentUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Autowired
	public CurrentUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findOneByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
		}
		return new CurrentUser(user);
	}
}
