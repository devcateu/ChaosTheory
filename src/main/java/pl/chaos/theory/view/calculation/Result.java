package pl.chaos.theory.view.calculation;

import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;

public class Result {
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
