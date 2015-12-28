package pl.chaos.theory.view.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.chaos.theory.algorithm.AlgorithmFacade;
import pl.chaos.theory.algorithm.AlgorithmInfo;
import pl.chaos.theory.algorithm.AlgorithmType;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component("algorithmInfoConverter")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AlgorithmInfoConverter implements Converter {

	@Autowired
	private AlgorithmFacade algorithmFacade;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) throws ConverterException {
		if (value != null && value.trim().length() > 0) {
			return algorithmFacade.getAlgorithmInfo(AlgorithmType.valueOf(value));
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) throws ConverterException {
		if (object != null && object instanceof AlgorithmInfo) {
			return ((AlgorithmInfo) object).getName();
		} else {
			return null;
		}
	}
}
