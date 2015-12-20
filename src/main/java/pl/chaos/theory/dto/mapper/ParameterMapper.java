package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.db.model.ParameterInfo;
import pl.chaos.theory.dto.model.ParameterDto;
import pl.chaos.theory.dto.model.ParameterInfoDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class ParameterMapper extends BaseMapper<Parameter, ParameterDto> {

	@Override
	public ParameterDto mapAtoB(Parameter model) {
		ParameterDto parameterDto = new ParameterDto();
		parameterDto.setId(model.getId());
		parameterDto.setAlgorithmResultId(model.getAlgorithmResultId());
		parameterDto.setParameterInfo(mapper.map(model.getParameterInfo(), ParameterInfoDto.class));
		parameterDto.setParameterInfoId(model.getParameterInfoId());
		parameterDto.setValue(model.getValue());
		return parameterDto;
	}

	@Override
	public Parameter mapBtoA(ParameterDto dto) {
		Parameter parameter = new Parameter();
		parameter.setId(dto.getId());
		parameter.setAlgorithmResultId(dto.getAlgorithmResultId());
		parameter.setParameterInfo(mapper.map(dto.getParameterInfo(), ParameterInfo.class));
		parameter.setParameterInfoId(dto.getParameterInfoId());
		parameter.setValue(dto.getValue());
		return parameter;
	}
}
