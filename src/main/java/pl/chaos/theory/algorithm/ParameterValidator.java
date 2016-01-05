package pl.chaos.theory.algorithm;

import java.util.Map;

/**
 * Interface of parameter validator for parameters of algorithm.
 */
public interface ParameterValidator {
	/**
	 * @param value         Value to validate.
	 * @param parameterInfo Validated parameter info.
	 * @param allParameters All parameters of current algorithm.
	 * @return true if value is correct, otherwise false.
	 */
	boolean validate(Double value, ParameterInfo parameterInfo, Map<String, Double> allParameters);

	/**
	 * Error Message.
	 * @param input putted parameters.
	 * @return Error Message.
	 */
	String errorMessage(Double input);
}
