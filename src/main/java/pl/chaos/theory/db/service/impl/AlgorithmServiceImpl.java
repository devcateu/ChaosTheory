package pl.chaos.theory.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.AlgorithmResult;
import pl.chaos.theory.db.model.Image;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.db.repository.AlgorithmRepository;
import pl.chaos.theory.db.repository.AlgorithmResultRepository;
import pl.chaos.theory.db.repository.ImageRepository;
import pl.chaos.theory.db.service.AlgorithmService;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.dto.model.ParameterInfoDto;
import pl.chaos.theory.util.mapper.Mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class AlgorithmServiceImpl implements AlgorithmService {

	@Autowired
	private AlgorithmRepository algorithmRepository;
	@Autowired
	private AlgorithmResultRepository algorithmResultRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private Mapper mapper;

	@Override
	public Collection<AlgorithmDto> getAllAlgorithms() {
		return mapper.mapCollection(algorithmRepository.findAll(), AlgorithmDto.class);
	}

	@Override
	public Collection<AlgorithmResultDto> getAllResultForUser(Long userId) {
		return mapper.mapCollection(algorithmResultRepository.findAllByUserId(userId), AlgorithmResultDto.class);
	}

	@Override
	public ImageDto getImageById(Long imageId) {
		return mapper.map(imageRepository.getOne(imageId), ImageDto.class);
	}

	@Override
	public AlgorithmResultDto saveResult(AlgorithmDto algorithmDto, Map<String, Double> parametersMap, ImageDto imageDto) {
		Image image = mapper.map(imageDto, Image.class);
		image = imageRepository.save(image);

		AlgorithmResult algorithmResult = new AlgorithmResult();
		algorithmResult.setAlgorithmId(algorithmDto.getId());
		algorithmResult.setDescription(algorithmDto.getDescription());
		algorithmResult.setImageId(image.getId());
		algorithmResult.setParameters(prepareParameters(algorithmDto, parametersMap));
		return null;
	}

	private Set<Parameter> prepareParameters(AlgorithmDto algorithmDto, Map<String, Double> parametersMap) {

		Set<Parameter> parameters = new HashSet<Parameter>();
		Set<ParameterInfoDto> parameterInfoDtos = algorithmDto.getParameterInfoSet();
		for (ParameterInfoDto parameterInfoDto : parameterInfoDtos) {
			Parameter parameter = new Parameter();
			parameter.setParameterInfoId(parameterInfoDto.getId());

			Double value = parametersMap.get(parameterInfoDto.getSymbol());
			parameter.setValue(value);
			parameters.add(parameter);
		}
		return parameters;
	}
}
