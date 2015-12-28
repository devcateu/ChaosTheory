package pl.chaos.theory.algorithm;

import java.util.Map;

public interface ParameterValidator {
	boolean validate(Double value, ParameterInfo parameterInfo, Map<String, Double> allParameters);

	String errorMessage(Double input);
}
