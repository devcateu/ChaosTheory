package pl.chaos.theory.view.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.AlgorithmFacade;
import pl.chaos.theory.algorithm.AlgorithmInfo;
import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.algorithm.ParameterInfo;
import pl.chaos.theory.db.service.AlgorithmService;
import pl.chaos.theory.db.service.LoggedUserService;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.dto.model.UserDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

//TODO check it
@Component("calculationManager")
public class CalculationManager {

	private final AlgorithmFacade algorithmFacade;
	private final AlgorithmService algorithmService;
	private final LoggedUserService loggedUserService;

	@Autowired
	public CalculationManager(AlgorithmFacade algorithmFacade, AlgorithmService algorithmService, LoggedUserService loggedUserService) {
		this.algorithmFacade = algorithmFacade;
		this.algorithmService = algorithmService;
		this.loggedUserService = loggedUserService;
	}

	public String calculate(AlgorithmView algorithmView) {
		AlgorithmType algorithmType = algorithmView.getSelectedAlgorithm().getAlgorithmType();
		Map<String, Double> parameters = algorithmView.getInputParams();
		ImageDto imageDto = algorithmFacade.calculate(algorithmType, parameters);
		AlgorithmResultDto algorithmResultDto = algorithmService.saveResult("", algorithmType, parameters, imageDto);
		return "/result.jsf?faces-redirect=true&id=" + algorithmResultDto.getId();
	}

	public List<AlgorithmInfo> getAllAlgorithms() {
		List<AlgorithmInfo> infoAboutAllAlgorithm = null;
		if (infoAboutAllAlgorithm == null) {
			infoAboutAllAlgorithm = algorithmFacade.getInfoAboutAllAlgorithm();
		}
		return infoAboutAllAlgorithm;
	}

	public Collection<ParameterInfo> getParameters(AlgorithmView algorithmInfo) {
		if (algorithmInfo == null) {
			return new ArrayList<ParameterInfo>();
		}
		return getParameters(algorithmInfo.getSelectedAlgorithm());
	}

	public Collection<ParameterInfo> getParameters(AlgorithmInfo algorithmInfo) {
		if (algorithmInfo == null) {
			return new ArrayList<ParameterInfo>();
		}
		return algorithmFacade.getParameters(algorithmInfo.getAlgorithmType());
	}

	public Collection<AlgorithmResultDto> getAllAlgorithmResultForUser() {
		UserDto userDto = loggedUserService.getCurrentUser();
		return algorithmService.getAllResultForUser(userDto.getId());
	}

	public ImageDto getImageById(Long imageId) {
		return algorithmService.getImageById(imageId);
	}

}
