package pl.chaos.theory.db.service;

import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.Collection;
import java.util.Map;

public interface AlgorithmService {

	Collection<AlgorithmResultDto> getAllResultForUser(Long userId);

	ImageDto getImageById(Long imageId);

	AlgorithmResultDto saveResult(String description, AlgorithmType algorithmType, Map<String, Double> parametersMap, ImageDto imageDto);
}
