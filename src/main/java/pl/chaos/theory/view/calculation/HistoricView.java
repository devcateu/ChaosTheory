package pl.chaos.theory.view.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ParameterDto;
import pl.chaos.theory.util.Util;
import pl.chaos.theory.util.View;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component("historic")
@View
public class HistoricView {
	private final Set<ParameterDto> parameters = new HashSet<ParameterDto>();
	private Collection<AlgorithmResultDto> allAlgorithmResultForUser;

	@Autowired
	public HistoricView(CalculationManager calculationManager) {
		allAlgorithmResultForUser = calculationManager.getAllAlgorithmResultForUser();
	}

	public Set<ParameterDto> getParameters() {
		return parameters;
	}

	public void setParameters(Set<ParameterDto> parameters) {
		Util.copyCollection(this.parameters, parameters);
	}

	public String goToResultsPage(Long Id) {
		return "/result.jsf?faces-redirect=true&id=" + Id;
	}

	public Collection<AlgorithmResultDto> getAllAlgorithmResultForUser() {
		return allAlgorithmResultForUser;
	}
}
