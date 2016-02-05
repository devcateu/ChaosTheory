package pl.chaos.theory.view.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.service.AlgorithmService;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.util.Request;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Request
@Component("result")
public class ResultView {
	private AlgorithmResultDto algorithmResult;

	@Autowired
	public ResultView(AlgorithmService algorithmService) {
		tryToFillParametersForUrlId(algorithmService);
	}

	private void tryToFillParametersForUrlId(AlgorithmService algorithmService) {
		try {
			long id = getResultIdFromUrl();
			fillParameters(algorithmService, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long getResultIdFromUrl() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String id = req.getParameter("id");
		return Long.parseLong(id);
	}

	/**
	 * Fill parameters for selected calculation.
	 *
	 * @param resultId Selected calculation id.
	 */
	private void fillParameters(AlgorithmService algorithmService, Long resultId) {
		algorithmResult = algorithmService.getResultById(resultId);
	}

	public AlgorithmResultDto getAlgorithmResult() {
		return algorithmResult;
	}

	public void setAlgorithmResult(AlgorithmResultDto algorithmResult) {
		this.algorithmResult = algorithmResult;
	}
}
