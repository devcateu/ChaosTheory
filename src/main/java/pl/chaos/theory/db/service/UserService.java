package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;

public interface UserService {

	UserDto getUserById(long id);

	UserDto getUserByEmail(String email);

	UserDto create(PasswordDto passwordDto, UserDto userDto);

	String getHashedPassword(String email);

	void changePassword(String newPassword, String oldPassword);
}
