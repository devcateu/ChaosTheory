package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.util.Request;

@Component("login")
@Request
public class LoginView {
	private String password;
	private String email;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override public String toString() {
		return "LoginView{" +
				"password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
