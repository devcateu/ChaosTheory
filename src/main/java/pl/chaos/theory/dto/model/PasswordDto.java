package pl.chaos.theory.dto.model;

public class PasswordDto {
	private String password;
	private String passwordRepeated;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public void reset() {
		password = null;
		passwordRepeated = null;
	}
}
