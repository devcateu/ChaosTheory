package pl.chaos.theory.view.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.util.Request;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Request
@Component("result")
public class ResultView {
	private AlgorithmResultDto algorithmResult;
	private ImageDto image;

	@Autowired
	public ResultView(CalculationManager calculationManager) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		long id = Long.parseLong(req.getParameter("id"));
		Result resultView = calculationManager.getResultById(id);
		this.image = resultView.getImage();
		this.algorithmResult = resultView.getAlgorithmResult();
	}

	public AlgorithmResultDto getAlgorithmResult() {
		return algorithmResult;
	}

	public void setAlgorithmResult(AlgorithmResultDto algorithmResult) {
		this.algorithmResult = algorithmResult;
	}

	public ImageDto getImage() {
		return image;
	}

	public void setImage(ImageDto image) {
		this.image = image;
	}
}
