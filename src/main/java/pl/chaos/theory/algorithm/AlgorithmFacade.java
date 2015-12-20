package pl.chaos.theory.algorithm;

import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.Map;

@Component
public class AlgorithmFacade {
	public ImageDto calculate(AlgorithmDto algorithm, Map<String, Double> parameters) {
		return getAlgorithmImplFor(algorithm).calculate(parameters);
	}

	private Algorithm getAlgorithmImplFor(AlgorithmDto algorithm) {
		return new Algorithm() {
			@Override
			public ImageDto calculate(Map<String, Double> parameters) {
				return new ImageDto();
			}
		};
	}
}
