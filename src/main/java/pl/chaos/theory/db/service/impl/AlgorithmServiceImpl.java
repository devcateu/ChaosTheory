package pl.chaos.theory.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.db.model.AlgorithmResult;
import pl.chaos.theory.db.model.Image;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.db.repository.AlgorithmResultRepository;
import pl.chaos.theory.db.repository.ImageRepository;
import pl.chaos.theory.db.service.AlgorithmService;
import pl.chaos.theory.db.service.LoggedUserService;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.util.mapper.Mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
/**
 * Implementation of AlgorithmService
 */
public class AlgorithmServiceImpl implements AlgorithmService {

	@Autowired
	private AlgorithmResultRepository algorithmResultRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private Mapper mapper;
	@Autowired
	private LoggedUserService loggedUserService;

	@Override
	public Collection<AlgorithmResultDto> getAllResultForUser(Long userId) {
		return mapper.mapCollection(algorithmResultRepository.findAllByUserId(userId), AlgorithmResultDto.class);
	}

	@Override
	public ImageDto getImageById(Long imageId) {
		return mapper.map(imageRepository.getOne(imageId), ImageDto.class);
	}

	@Override
	public AlgorithmResultDto getResultById(Long id) {
		return mapper.map(algorithmResultRepository.getOne(id), AlgorithmResultDto.class);
	}

	@Override
	public AlgorithmResultDto saveResult(String description, AlgorithmType algorithmType, Map<String, Double> parametersMap, ImageDto imageDto) {
		Image image = mapper.map(imageDto, Image.class);
		image = imageRepository.save(image);

		AlgorithmResult algorithmResult = new AlgorithmResult();
		algorithmResult.setAlgorithmType(algorithmType);
		algorithmResult.setDescription(description);
		algorithmResult.setImageId(image.getId());
		algorithmResult.setParameters(prepareParameters(parametersMap, algorithmResult));
		algorithmResult.setUserId(loggedUserService.getCurrentUser().getId());
		algorithmResult = algorithmResultRepository.save(algorithmResult);
		return mapper.map(algorithmResult, AlgorithmResultDto.class);
	}

	private Set<Parameter> prepareParameters(Map<String, Double> parametersMap, AlgorithmResult algorithmResult) {

		Set<Parameter> parameters = new HashSet<Parameter>();
		for (String symbol : parametersMap.keySet()) {
			Parameter parameter = new Parameter();

			Double value = parametersMap.get(symbol);
			parameter.setSymbol(symbol);
			parameter.setValue(value);
			parameter.setAlgorithmResult(algorithmResult);
			parameters.add(parameter);
		}
		return parameters;
	}
}
