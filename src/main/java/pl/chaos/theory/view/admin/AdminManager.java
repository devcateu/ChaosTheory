package pl.chaos.theory.view.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;

import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("adminManager")
@ViewScoped
/**
 * Contains all operation allowed only for admin.
 */
public class AdminManager {

	private final UserService userService;
	private List<UserDto> allUsers = null;

	@Autowired
	public AdminManager(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Return list of all users registered in system.
	 *
	 * @return List of all users registered in system
	 */
	public List<UserDto> getAllUsers() {
		if (allUsers == null) {
			allUsers = new ArrayList<UserDto>(userService.getAll());
		}
		return allUsers;
	}

	/**
	 * Save changed role for selected user.
	 * @param userDto Selected user for which should be role updated.
	 */
	public void saveChangeRole(UserDto userDto) {
		userService.updateRole(userDto);
	}

	/**
	 * Return list of allowed Role.
	 * @return List of allowed Role.
	 */
	public List<Role> getRoles() {
		return Arrays.asList(Role.values());
	}
}
