package pl.chaos.theory.view.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.util.Request;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@Component("passwordValidation")
@Request
public class PasswordValidation implements Validator {
	private UIInput passwordd;

	public void validate(PasswordDto password) throws Exception {
		if (!password.getPassword().equals(password.getPasswordRepeated())) {
			throw new Exception("Passwords do not match!!");
		}
	}

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}
		Map<String, Object> attributes = uiComponent.getAttributes();
		String password = (String) attributes.get("password21");

		String passwordRepeated = value.toString();
		if (StringUtils.hasText(passwordRepeated) && !passwordRepeated.equals(password)) {
			((UIInput) uiComponent).setValid(false);

			throw new ValidatorException(new FacesMessage("Password must match confirm password."));
		}

	}
}
