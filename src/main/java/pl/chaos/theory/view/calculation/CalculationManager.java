package pl.chaos.theory.view.calculation;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component("calculationManager")
/**
 * Responsible for all allow operation in UI connected with calculation and algorithm.
 */
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

	/**
	 * Calculate selected algorithm for putted parameters.
	 *
	 * @param algorithmView Selected algorithm and parameter needed to calculate result.
	 * @return Path to result page with id for result.
	 */
	public String calculate(AlgorithmView algorithmView) {
		AlgorithmType algorithmType = algorithmView.getSelectedAlgorithm().getAlgorithmType();
		Map<String, Double> parameters = algorithmView.getInputParams();
		ImageDto imageDto = algorithmFacade.calculate(algorithmType, parameters);
                String description = algorithmView.getSelectedAlgorithm().getDescription();
		AlgorithmResultDto algorithmResultDto = algorithmService.saveResult(description, algorithmType, parameters, imageDto);
		return "/result.jsf?faces-redirect=true&id=" + algorithmResultDto.getId();
	}

	/**
	 * Return info about allow algorithm in the system.
	 *
	 * @return List of allow algorithms.
	 */
	public List<AlgorithmInfo> getAllAlgorithms() {
		return algorithmFacade.getInfoAboutAllAlgorithm();
	}

	/**
	 * Return list of parameters for selected algorithm.
	 *
	 * @param algorithmView Contains selected algorithm.
	 * @return List of parameters for selected algorithm, when algorithm is not selected return empty list.
	 */
	public Collection<ParameterInfo> getParameters(AlgorithmView algorithmView) {
		if (algorithmView == null) {
			return new ArrayList<ParameterInfo>();
		}
		return getParameters(algorithmView.getSelectedAlgorithm());
	}

	/**
	 * Return list of parameters for selected algorithm.
	 *
	 * @param algorithmInfo Selected algorithm.
	 * @return List of parameters for selected algorithm, when algorithm is not selected return empty list.
	 */
	private Collection<ParameterInfo> getParameters(AlgorithmInfo algorithmInfo) {
		if (algorithmInfo == null) {
			return new ArrayList<ParameterInfo>();
		}
		return algorithmFacade.getParameters(algorithmInfo.getAlgorithmType());
	}

	/**
	 * Return all results of algorithm for current logged user.
	 *
	 * @return Collection of all results of algorithm for current logged user.
	 */
	public Collection<AlgorithmResultDto> getAllAlgorithmResultForUser() {
		UserDto userDto = loggedUserService.getCurrentUser();
		return algorithmService.getAllResultForUser(userDto.getId());
	}

	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real StreamedContent with the image bytes.
			String id = context.getExternalContext().getRequestParameterMap().get("imageId");
			byte[] b = algorithmService.getImageBytesById(Long.parseLong(id));
			return new DefaultStreamedContent(new ByteArrayInputStream(b));
		}
	}
}
