package pl.chaos.theory.security;

import org.springframework.security.core.authority.AuthorityUtils;
import pl.chaos.theory.dto.model.UserDto;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private UserDto user;

	public CurrentUser(UserDto user, String password) {
		super(user.getEmail(), password, AuthorityUtils.createAuthorityList(user.getRole().toString()));
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
