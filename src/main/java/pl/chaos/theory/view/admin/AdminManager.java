package pl.chaos.theory.view.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;

import java.util.Collection;

//TODO check it
@Component("adminManager")
public class AdminManager {

	private final UserService userService;

	@Autowired
	public AdminManager(UserService userService) {
		this.userService = userService;
	}

	public Collection<UserDto> getAllUser() {
		return userService.getAll();
	}

	public void saveLock(UserDto userDto) {
		userService.updateLock(userDto);
	}
}
