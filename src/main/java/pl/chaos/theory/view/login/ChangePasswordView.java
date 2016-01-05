package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.util.Request;

@Component("changePassword")
@Request
/**
 * Contains parameters required to change password.
 */
public class ChangePasswordView {
	private String newPassword;
	private String oldPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
