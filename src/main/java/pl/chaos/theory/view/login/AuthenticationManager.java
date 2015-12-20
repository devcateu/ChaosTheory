package pl.chaos.theory.view.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component("authenticationManager")
public class AuthenticationManager {
	private final UserService userService;
	private final PasswordValidation passwordValidation;

	@Autowired
	public AuthenticationManager(UserService userService, PasswordValidation passwordValidation) {
		this.userService = userService;
		this.passwordValidation = passwordValidation;
	}

	public void changePassword(String oldPassword, PasswordDto password) throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		String passwordFromDb = userService.getHashedPassword(userName);
		if (!passwordFromDb.equals(oldPassword)) {
			throw new RuntimeException("wrong old password");
		}

		passwordValidation.validate(password);
		userService.changePassword(password.getPassword(), userName);
	}

	public String login() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	public String register(PasswordDto passwordDto, UserDto userDto) {
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
