package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.AlgorithmResult;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ParameterDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
/**
 * Allow map object from AlgorithmResult into AlgorithmResultDto and vice versa.
 */
public class AlgorithmResultMapper extends BaseMapper<AlgorithmResult, AlgorithmResultDto> {

	@Override
	public AlgorithmResultDto mapAtoB(AlgorithmResult model) {
		AlgorithmResultDto resultDto = new AlgorithmResultDto();
		resultDto.setId(model.getId());
		resultDto.setUserId(model.getUserId());
		resultDto.setDescription(model.getDescription());
		resultDto.setImageId(model.getImageId());
		resultDto.setParameters(mapper.mapCollection(model.getParameters(), ParameterDto.class));
		resultDto.setAlgorithmType(model.getAlgorithmType());
		return resultDto;
	}

	@Override
	public AlgorithmResult mapBtoA(AlgorithmResultDto dto) {
		AlgorithmResult algorithmResult = new AlgorithmResult();
		algorithmResult.setId(dto.getId());
		algorithmResult.setUserId(dto.getUserId());
		algorithmResult.setDescription(dto.getDescription());
		algorithmResult.setImageId(dto.getImageId());
		algorithmResult.setParameters(mapper.mapCollection(dto.getParameters(), Parameter.class));
		algorithmResult.setAlgorithmType(dto.getAlgorithmType());
		return algorithmResult;
	}
}
