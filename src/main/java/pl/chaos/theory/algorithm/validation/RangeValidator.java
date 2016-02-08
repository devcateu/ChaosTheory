package pl.chaos.theory.algorithm.validation;

import pl.chaos.theory.algorithm.ParameterInfo;
import pl.chaos.theory.algorithm.ParameterValidator;

import java.util.Map;

/**
 * Implementation of Parameter validator for selected range.
 */
public class RangeValidator implements ParameterValidator {
	private final double minimum;
	private final double maximum;

	public RangeValidator(double minimum, double maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

	@Override
	public boolean validate(Double value, ParameterInfo parameterInfo, Map<String, Double> allParameters) {
		return value >= minimum && value <= maximum;
	}

	@Override
	public String errorMessage(Double inputParam) {
		return String.format("Value should be in range: (%s , %s) ", minimum, maximum);
	}
}
