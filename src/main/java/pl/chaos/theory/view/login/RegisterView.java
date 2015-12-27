package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.util.Request;

@Component("register")
@Request
public class RegisterView {
	private UserDto user = new UserDto();
	private PasswordDto password = new PasswordDto();

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PasswordDto getPassword() {
		return password;
	}

	public void setPassword(PasswordDto password) {
		this.password = password;
	}
}
