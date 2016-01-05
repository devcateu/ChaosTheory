package pl.chaos.theory.view.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.LoggedUserService;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;
import pl.chaos.theory.security.SecurityUtil;
import pl.chaos.theory.util.Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Map;

@Component("authManager")
/**
 * Authentication manager contains method which is responsible for all authentication in system: log in, log out, register, change password.
 */
public class AuthenticationManager {
	private final UserService userService;
	private final LoggedUserService loggedUserService;

	@Autowired
	/**
	 * Constructor
	 * @param userService service which allow access to system.
	 * @param loggedUserService service which allow operate on current logged user.
	 */
	public AuthenticationManager(UserService userService, LoggedUserService loggedUserService) {
		this.userService = userService;
		this.loggedUserService = loggedUserService;
	}

	/**
	 * Allow change password. When change password is successful return index page name, thanks that JSF redirect to index view.
	 * On error during changing password page not be changed. Show on JSF page information about status operation.
	 *
	 * @param changePasswordView Should contains required parameters to change password.
	 * @return "index" on successful, otherwise null.
	 */
	public String changePassword(ChangePasswordView changePasswordView) {

		String oldPassword = changePasswordView.getOldPassword();
		String newPassword = changePasswordView.getNewPassword();

		if (!loggedUserService.changePassword(oldPassword, newPassword)) {
			Util.addMessage("oldPassword", FacesMessage.SEVERITY_ERROR, "Wrong old Password.");
			return null;
		} else {
			Util.addMessage("indexMessage", FacesMessage.SEVERITY_INFO, "Change Password successful.");
			return "index";
		}
	}

	/**
	 * Allow login into system.
	 *
	 * @return null
	 * @throws Exception throw when some error during login to system or wrong password, login combination.
	 */
	public String login() throws Exception {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	/**
	 * Allow logout from system. After successful return "index" (thanks that JSF redirect to index page).
	 *
	 * @return "index"
	 */
	public String logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		SecurityContextHolder.clearContext();
		return "index";
	}

	/**
	 * Allow register user into system. Show in UI information about status current operation.
	 * @param register Should contains required parameters for registering into system.
	 * @return null on error during register, otherwise "login".
	 */
	public String register(RegisterView register) {
		String retPage;

		UserDto userDto = new UserDto();
		userDto.setEmail(register.getEmail());
		String password = register.getPassword();
		try {
			userDto.setRole(Role.USER);
			userDto = userService.create(userDto, password);
			Util.addMessage(FacesMessage.SEVERITY_INFO, "Registration Success!");
			retPage = "login";
		} catch (Exception e) {
			Util.addMessage(FacesMessage.SEVERITY_ERROR, "Registration Failure, " + e.getMessage());
			retPage = null;
		}
		return retPage;
	}

	/**
	 * Show communicate in UI when is error param in URL.
	 */
	public void updateMessages() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		if (params.containsKey("error")) {
			Util.addMessage(null, FacesMessage.SEVERITY_ERROR, "Login failuire.");
		}
	}

	/**
	 * Redirect to index page, when user is logged into system.
	 * @throws IOException When some problem with redirecting happened.
	 */
	public void redirect() throws IOException {
		if (SecurityUtil.isAuthenticated()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		}
	}
}
