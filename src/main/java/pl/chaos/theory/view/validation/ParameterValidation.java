package pl.chaos.theory.view.validation;

import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.ParameterInfo;
import pl.chaos.theory.algorithm.ParameterValidator;
import pl.chaos.theory.util.Request;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Collections;
import java.util.Map;

@Component("parameterValidation")
@Request
public class ParameterValidation implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
		Double input = (Double) o;

		Map<String, Object> attributes = uiComponent.getAttributes();
		Map<String, Double> allParams = (Map<String, Double>) attributes.get("allParams");
		ParameterInfo algorithmParameter = (ParameterInfo) attributes.get("algorithmParameter");

		ParameterValidator parameterValidator = algorithmParameter.getValidator();

		if (!parameterValidator.validate(input, algorithmParameter, Collections.unmodifiableMap(allParams))) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", parameterValidator.errorMessage(input)));
		}

	}
}
