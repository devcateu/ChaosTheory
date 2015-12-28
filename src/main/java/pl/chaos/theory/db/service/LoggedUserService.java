package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.UserDto;

public interface LoggedUserService {
	UserDto getCurrentUser();

	boolean changePassword(String oldPassword, String newPassword);
}
