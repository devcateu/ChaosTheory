package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Algorithm;
import pl.chaos.theory.db.model.AlgorithmResult;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class AlgorithmResultMapper extends BaseMapper<AlgorithmResult, AlgorithmResultDto> {

	@Override
	public AlgorithmResultDto mapAtoB(AlgorithmResult model) {
		AlgorithmResultDto resultDto = new AlgorithmResultDto();
		resultDto.setAlgorithmId(model.getAlgorithmId());
		resultDto.setId(model.getId());
		resultDto.setUserId(model.getUserId());
		resultDto.setDescription(model.getDescription());
		resultDto.setImageId(model.getImageId());
		resultDto.setAlgorithm(mapper.map(model.getAlgorithm(), AlgorithmDto.class));
		return resultDto;
	}

	@Override
	public AlgorithmResult mapBtoA(AlgorithmResultDto dto) {
		AlgorithmResult algorithmResult = new AlgorithmResult();
		algorithmResult.setAlgorithmId(dto.getAlgorithmId());
		algorithmResult.setId(dto.getId());
		algorithmResult.setUserId(dto.getUserId());
		algorithmResult.setDescription(dto.getDescription());
		algorithmResult.setImageId(dto.getImageId());
		algorithmResult.setAlgorithm(mapper.map(dto.getAlgorithm(), Algorithm.class));
		return algorithmResult;
	}
}
