package pl.chaos.theory.dto.model;

import pl.chaos.theory.security.Role;

public class UserDto extends Dto {
	private String email;
	private Role role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
