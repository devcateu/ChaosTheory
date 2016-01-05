package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.UserDto;

import java.util.Collection;

public interface UserService {

	UserDto getUserById(long id);

	UserDto getUserByEmail(String email);

	UserDto create(UserDto userDto, String password);

	String getHashedPassword(String email);

	void changePassword(String newPassword, String oldPassword);

	Collection<UserDto> getAll();

	void updateRole(UserDto userDto);
}
