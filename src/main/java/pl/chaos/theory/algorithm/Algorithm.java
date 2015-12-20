package pl.chaos.theory.algorithm;

import pl.chaos.theory.dto.model.ImageDto;

import java.util.Map;

public interface Algorithm {
	ImageDto calculate(Map<String, Double> parameters);
}
