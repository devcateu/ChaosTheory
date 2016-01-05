package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.UserDto;

/**
 * Service which allow operate on current logged user.
 */
public interface LoggedUserService {
	/**
	 * If current user is logged return object represent their, otherwise return null.
	 *
	 * @return If current user is logged return object represent their, otherwise return null
	 */
	UserDto getCurrentUser();

	/**
	 * Change password for current logged user.
	 * @param oldPassword Old password.
	 * @param newPassword New password.
	 * @return true if operation end with succesfull otherwise false.
	 */
	boolean changePassword(String oldPassword, String newPassword);
}
