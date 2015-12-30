package pl.chaos.theory.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AlgorithmFacade {
	private Map<AlgorithmType, Algorithm> algorithmMap = new HashMap<AlgorithmType, Algorithm>();

	@Autowired
	public AlgorithmFacade(List<Algorithm> algorithms) {
		for (Algorithm algorithm : algorithms) {
			algorithmMap.put(algorithm.getAlgorithmType(), algorithm);
		}
	}

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

	private Algorithm getAlgorithmImplFor(final AlgorithmType algorithmType) {
		return algorithmMap.get(algorithmType);
	}
}
