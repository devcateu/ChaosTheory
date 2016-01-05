package pl.chaos.theory.view.calculation;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;

import javax.faces.bean.ViewScoped;

@ViewScoped
@Component("result")
public class ResultView {
	private AlgorithmResultDto algorithmResult;
	private ImageDto image;

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
