package pl.chaos.theory.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.chaos.theory.configuration.Profiles;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.db.repository.UserRepository;
import pl.chaos.theory.security.Role;

@Component
@Profile(value = Profiles.H2)
public class UserInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static boolean started = false;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (started) {
			return;
		}
		started = true;

		User user = new User();
		user.setEmail("user");
		user.setPasswordHash("user");
		user.setRole(Role.USER);
		userRepository.save(user);

		User admin = new User();
		admin.setEmail("admin");
		admin.setPasswordHash("admin");
		admin.setRole(Role.ADMIN);
		userRepository.save(admin);

		User userBlock = new User();
		userBlock.setEmail("userBlock");
		userBlock.setPasswordHash("userBlock");
		userBlock.setRole(Role.BLOCKED_USER);
		userRepository.save(userBlock);
	}
}
