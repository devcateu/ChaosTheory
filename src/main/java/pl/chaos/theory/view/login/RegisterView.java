package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.util.Request;

@Component("register")
@Request
/**
 * Contains parameters required to register.
 */
public class RegisterView {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
