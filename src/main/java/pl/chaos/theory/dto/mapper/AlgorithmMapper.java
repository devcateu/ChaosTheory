package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Algorithm;
import pl.chaos.theory.db.model.ParameterInfo;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.ParameterInfoDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class AlgorithmMapper extends BaseMapper<Algorithm, AlgorithmDto> {

	@Override
	public AlgorithmDto mapAtoB(Algorithm algorithm) {
		AlgorithmDto algorithmDto = new AlgorithmDto();
		algorithmDto.setId(algorithm.getId());
		algorithmDto.setName(algorithm.getName());
		algorithmDto.setDescription(algorithm.getDescription());
		algorithmDto.setParameterInfoSet(mapper.mapCollection(algorithm.getParameterInfoSet(), ParameterInfoDto.class));
		return algorithmDto;
	}

	@Override
	public Algorithm mapBtoA(AlgorithmDto algorithmDto) {
		Algorithm algorithm = new Algorithm();
		algorithm.setId(algorithmDto.getId());
		algorithm.setName(algorithmDto.getName());
		algorithm.setDescription(algorithmDto.getDescription());
		algorithm.setParameterInfoSet(mapper.mapCollection(algorithmDto.getParameterInfoSet(), ParameterInfo.class));
		return algorithm;
	}
}
