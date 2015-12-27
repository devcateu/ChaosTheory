package pl.chaos.theory.view.login;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.util.Request;

@Component("changePassword")
@Request
public class ChangePasswordView {
	private PasswordDto newPassword = new PasswordDto();
	private String oldPassword;

	public PasswordDto getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(PasswordDto newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
