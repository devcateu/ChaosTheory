package pl.chaos.theory.dto.model;

import pl.chaos.theory.security.Role;

public class UserDto extends Dto {
	private Long id;
	private String email;
	private Role role;
	private boolean locked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void reset() {
		role = null;
		email = null;
		id = null;
		locked = false;
	}
}
