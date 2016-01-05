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

	/**
	 * Make calculation for selected algorithm and parameters.
	 *
	 * @param algorithm  selected algorithm.
	 * @param parameters input parameters for algorithm
	 * @return Calculation result - Image.
	 */
	public ImageDto calculate(AlgorithmType algorithm, Map<String, Double> parameters) {
		return getAlgorithmImplFor(algorithm).calculate(parameters);
	}

	/**
	 * Return list of required parameter for selected algorithm.
	 * @param algorithmType algorithm.
	 * @return List of parameters for algorithm.
	 */
	public List<ParameterInfo> getParameters(AlgorithmType algorithmType) {
		return getAlgorithmImplFor(algorithmType).parameters();
	}

	/**
	 * Return list of Information about algorithms.
	 * @return List of Information about algorithms.
	 */
	public List<AlgorithmInfo> getInfoAboutAllAlgorithm() {
		ArrayList<AlgorithmInfo> algorithmInfos = new ArrayList<AlgorithmInfo>();
		for (Algorithm algorithm : algorithmMap.values()) {
			algorithmInfos.add(algorithm.getAlgorithmInfo());
		}
		return algorithmInfos;
	}

	/**
	 * Return information about selected algorithm.
	 * @param algorithmType selected algorithm.
	 * @return Information about algorithm.
	 */
	public AlgorithmInfo getAlgorithmInfo(AlgorithmType algorithmType) {
		return getAlgorithmImplFor(algorithmType).getAlgorithmInfo();
	}

	private Algorithm getAlgorithmImplFor(final AlgorithmType algorithmType) {
		return algorithmMap.get(algorithmType);
	}
}
