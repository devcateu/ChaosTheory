package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.ParameterInfo;
import pl.chaos.theory.dto.model.ParameterInfoDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class ParameterInfoMapper extends BaseMapper<ParameterInfo, ParameterInfoDto> {

	@Override
	public ParameterInfoDto mapAtoB(ParameterInfo model) {
		ParameterInfoDto parameterInfoDto = new ParameterInfoDto();
		parameterInfoDto.setDescription(model.getDescription());
		parameterInfoDto.setId(model.getId());
		parameterInfoDto.setSymbol(model.getSymbol());
		parameterInfoDto.setAlgorithmId(model.getAlgorithmId());
		return parameterInfoDto;
	}

	@Override
	public ParameterInfo mapBtoA(ParameterInfoDto dto) {
		ParameterInfo parameterInfo = new ParameterInfo();
		parameterInfo.setAlgorithmId(dto.getAlgorithmId());
		parameterInfo.setSymbol(dto.getSymbol());
		parameterInfo.setDescription(dto.getDescription());
		parameterInfo.setId(dto.getId());
		return parameterInfo;
	}
}
