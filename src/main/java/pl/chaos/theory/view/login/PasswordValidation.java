package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.PasswordDto;

@Component
public class PasswordValidation {
	public void validate(PasswordDto password) throws Exception {
		if (!password.getPassword().equals(password.getPasswordRepeated())) {
			throw new Exception("Passwords do not match!!");
		}
	}
}
