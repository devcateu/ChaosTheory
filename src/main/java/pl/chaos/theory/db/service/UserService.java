package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.UserDto;

import java.util.Collection;

/**
 * Service which allow operate on user.
 */
public interface UserService {

	/**
	 * Return User by email
	 *
	 * @param email Email which is used to searching user in DB.
	 * @return User of selected email, if not find return null.
	 */
	UserDto getUserByEmail(String email);

	/**
	 * Create user for data.
	 * @param userDto User object to create.
	 * @param password Password of new object.
	 * @return New created user.
	 */
	UserDto create(UserDto userDto, String password);

	/**
	 * Return password for user selected by email.
	 * @param email Email which is used to searching user password in DB.
	 * @return User password.
	 */
	String getHashedPassword(String email);

	/**
	 * Change password for user selected by email
	 *
	 * @param newPassword New password.
	 * @param email       User email for which password should be changed.
	 */
	void changePassword(String newPassword, String email);

	/**
	 * Return all users in DB.
	 * @return All users in DB.
	 */
	Collection<UserDto> getAll();

	/**
	 * Update role for selected user.
	 * @param userDto User data to change in DB.
	 */
	void updateRole(UserDto userDto);
}
