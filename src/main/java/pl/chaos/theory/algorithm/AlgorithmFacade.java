package pl.chaos.theory.algorithm;

import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.validation.RangeValidator;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AlgorithmFacade {
	public ImageDto calculate(AlgorithmType algorithm, Map<String, Double> parameters) {
		return getAlgorithmImplFor(algorithm).calculate(parameters);
	}

	public List<ParameterInfo> getParameters(AlgorithmType algorithmType) {
		return getAlgorithmImplFor(algorithmType).parameters();
	}

	public List<AlgorithmInfo> getInfoAboutAllAlgorithm() {
		ArrayList<AlgorithmInfo> algorithmInfos = new ArrayList<AlgorithmInfo>();
		for (AlgorithmType algorithmType : AlgorithmType.values()) {
			algorithmInfos.add(getAlgorithmImplFor(algorithmType).getAlgorithmInfo());
		}
		return algorithmInfos;
	}

	public AlgorithmInfo getAlgorithmInfo(AlgorithmType algorithmType) {
		return getAlgorithmImplFor(algorithmType).getAlgorithmInfo();
	}

	private Algorithm getAlgorithmImplFor(final AlgorithmType algorithm) {
		return new Algorithm() {
			@Override
			public ImageDto calculate(Map<String, Double> parameters) {
				return new ImageDto();
			}

			@Override
			public List<ParameterInfo> parameters() {
				ArrayList<ParameterInfo> parameterInfos = new ArrayList<ParameterInfo>();
				parameterInfos.add(new ParameterInfo(new RangeValidator(3, 10), "x", "jol"));
				if (algorithm == AlgorithmType.CHAOS_NUMBER_GENERATOR) {
					parameterInfos.add(new ParameterInfo(new RangeValidator(5, 100), "z", "jol"));
				} else {
					parameterInfos.add(new ParameterInfo(new RangeValidator(0, 3), "m", "jol"));
				}
				return parameterInfos;
			}

			@Override
			public AlgorithmInfo getAlgorithmInfo() {
				return new AlgorithmInfo(algorithm.name(), "deeees", algorithm);
			}
		};
	}
}
