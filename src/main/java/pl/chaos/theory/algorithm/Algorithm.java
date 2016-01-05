package pl.chaos.theory.algorithm;

import pl.chaos.theory.dto.model.ImageDto;

import java.util.List;
import java.util.Map;

/**
 * Interface which should implement all algorithms in system.
 */
public interface Algorithm {

	/**
	 * Make calculation for that algorithm with parameters.
	 *
	 * @param parameters input parameters for algorithm
	 * @return Calculation result - Image.
	 */
	ImageDto calculate(Map<String, Double> parameters);

	/**
	 * Return list of required parameter for algorithm.
	 * @return List of parameters for algorithm.
	 */
	List<ParameterInfo> parameters();

	/**
	 * Return information about algorithm.
	 * @return Information about algorithm.
	 */
	AlgorithmInfo getAlgorithmInfo();

	/**
	 * Algorithm type
	 * @return Current algorithm type.
	 */
	AlgorithmType getAlgorithmType();
}
