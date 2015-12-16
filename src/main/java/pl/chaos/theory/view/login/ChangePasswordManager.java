package pl.chaos.theory.view.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.util.Request;
import pl.chaos.theory.view.login.validate.PasswordValidation;

@Component("changePasswordManager")
@Request
public class ChangePasswordManager {
	private final PasswordDto password;
	private final UserService userService;
	private final PasswordValidation passwordValidation;

	@Autowired
	public ChangePasswordManager(UserService userService, PasswordDto password, PasswordValidation passwordValidation) {
		this.userService = userService;
		this.password = password;
		this.passwordValidation = passwordValidation;
	}

	public void change(String oldPassword) throws Exception {
		System.out.println(oldPassword);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		String passwordFromDb = userService.getHashedPassword(userName);
		if (!passwordFromDb.equals(oldPassword)) {
			throw new RuntimeException("wrong old password");
		}

		passwordValidation.validate(password);
		userService.changePassword(password.getPassword(), userName);
	}
}
