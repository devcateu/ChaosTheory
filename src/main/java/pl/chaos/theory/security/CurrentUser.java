package pl.chaos.theory.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import pl.chaos.theory.dto.model.UserDto;

/**
 * Own implementation of Spring Security User, Allow check instance during logging into system.
 */
public class CurrentUser extends User {

	private UserDto user;

	public CurrentUser(UserDto user, String password) {
		super(user.getEmail(), password, AuthorityUtils.createAuthorityList(user.getRole().name()));
		this.user = user;
	}

	public UserDto getUser() {
		return user;
	}

	public Long getId() {
		return user.getId();
	}

	public Role getRole() {
		return user.getRole();
	}

}
