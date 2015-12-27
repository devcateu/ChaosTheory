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
public class AdminManager {

	private final UserService userService;
	private List<UserDto> allUsers = null;

	@Autowired
	public AdminManager(UserService userService) {
		this.userService = userService;
	}

	public List<UserDto> getAllUsers() {
		if (allUsers == null) {
			allUsers = new ArrayList<UserDto>(userService.getAll());
		}
		return allUsers;
	}

	public void saveChangeRole(UserDto userDto) {
		userService.updateRole(userDto);
	}

	public List<Role> getRoles() {
		return Arrays.asList(Role.values());
	}
}
