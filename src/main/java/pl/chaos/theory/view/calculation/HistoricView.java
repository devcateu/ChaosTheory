package pl.chaos.theory.view.calculation;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.ParameterDto;
import pl.chaos.theory.util.Util;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.HashSet;
import java.util.Set;

@ViewScoped
@ManagedBean(name = "historicV")
@Component("historic")
public class HistoricView {
	private final Set<ParameterDto> parameters = new HashSet<ParameterDto>();

	public Set<ParameterDto> getParameters() {
		return parameters;
	}

	public void setParameters(Set<ParameterDto> parameters) {
		Util.copyCollection(this.parameters, parameters);
	}

    public String ViewDetails(Long Id){
        return "/result.jsf?faces-redirect=true&id=" + Id;
    }
}
