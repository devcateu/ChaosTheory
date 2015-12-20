package pl.chaos.theory.db.service;

import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.Collection;
import java.util.Map;

public interface AlgorithmService {

	Collection<AlgorithmDto> getAllAlgorithms();

	Collection<AlgorithmResultDto> getAllResultForUser(Long userId);

	ImageDto getImageById(Long imageId);

	AlgorithmResultDto saveResult(AlgorithmDto algorithmDto, Map<String, Double> parametersMap, ImageDto imageDto);
}
