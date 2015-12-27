package pl.chaos.theory.view.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;
import pl.chaos.theory.security.SecurityUtil;
import pl.chaos.theory.util.Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Map;

@Component("authManager")
public class AuthenticationManager {
	private final UserService userService;

	@Autowired
	public AuthenticationManager(UserService userService) {
		this.userService = userService;
	}

	public String changePassword(ChangePasswordView changePasswordView) throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		String passwordFromDb = userService.getHashedPassword(userName);
		String oldPassword = changePasswordView.getOldPassword();

		if (!passwordFromDb.equals(oldPassword)) {
			Util.addMessage("oldPassword", FacesMessage.SEVERITY_ERROR, "Wrong old Password.");
			return null;
		} else {
			String newPassword = changePasswordView.getNewPassword().getPassword();
			userService.changePassword(newPassword, userName);
			Util.addMessage("indexMessage", FacesMessage.SEVERITY_INFO, "Change Password successful.");
			return "index";
		}
	}

	public String login(LoginView loginView) throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	public String logout() throws IOException, ServletException {
		SecurityContextHolder.getContext().setAuthentication(null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
		SecurityContextHolder.clearContext();
		return "index";
	}

	public String register(RegisterView register) {
		String retPage;
		UserDto userDto = register.getUser();
		PasswordDto passwordDto = register.getPassword();
		try {
			userDto.setRole(Role.USER);
			userDto = userService.create(passwordDto, userDto);
			Util.addMessage(FacesMessage.SEVERITY_INFO, "Registration Success!");
			retPage = "login";
		} catch (Exception e) {
			Util.addMessage(FacesMessage.SEVERITY_ERROR, "Registration Failure, " + e.getMessage());
			retPage = null;
		} finally {
			passwordDto.reset();
			userDto.reset();
		}
		return retPage;
	}

	public void updateMessages() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		if (params.containsKey("error")) {
			Util.addMessage(null, FacesMessage.SEVERITY_ERROR, "Login failuire.");
		}
	}

	public void redirect() throws IOException {
		if (SecurityUtil.isAuthenticated()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
	}
}
