package pl.chaos.theory.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.LoggedUserService;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.CurrentUser;

@Component
public class LoggedUserServiceImpl implements LoggedUserService {

	@Autowired
	private UserService userService;

	@Override
	public UserDto getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser currentUser = (CurrentUser) auth.getPrincipal();
		return currentUser.getUser();
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		String email = getCurrentUser().getEmail();
		String passwordFromDb = userService.getHashedPassword(email);
		if (passwordFromDb.equals(oldPassword)) {
			userService.changePassword(newPassword, email);
			return true;
		} else {
			return false;
		}
	}
}
