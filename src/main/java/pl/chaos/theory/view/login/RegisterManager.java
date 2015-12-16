package pl.chaos.theory.view.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;
import pl.chaos.theory.util.Request;
import pl.chaos.theory.view.login.validate.PasswordValidation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component("registerManager")
@Request
public class RegisterManager {

	private UserService userService;
	private PasswordDto passwordDto;
	private UserDto userDto;
	private PasswordValidation passwordValidation;

	@Autowired
	public RegisterManager(UserService userService, PasswordDto passwordDto, UserDto userDto, PasswordValidation passwordValidation) {
		this.userService = userService;
		this.passwordDto = passwordDto;
		this.userDto = userDto;
		this.passwordValidation = passwordValidation;
	}

	public String register() {
		String retPage;
		try {
			passwordValidation.validate(passwordDto);
			userDto.setRole(Role.USER);
			userDto = userService.create(passwordDto, userDto);
			addMessage(FacesMessage.SEVERITY_INFO, "Registration Success!");
			retPage = "login";
		} catch (Exception e) {
			addMessage(FacesMessage.SEVERITY_ERROR, "Registration Failure, " + e.getMessage());
			retPage = null;
		} finally {
			passwordDto.reset();
			userDto.reset();
		}
		return retPage;
	}

	private void addMessage(FacesMessage.Severity facesMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(facesMessage,
						message, ""));
	}
}
