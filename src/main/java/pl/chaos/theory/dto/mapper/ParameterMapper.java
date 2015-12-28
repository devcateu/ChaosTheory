package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.dto.model.ParameterDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class ParameterMapper extends BaseMapper<Parameter, ParameterDto> {

	@Override
	public ParameterDto mapAtoB(Parameter model) {
		ParameterDto parameterDto = new ParameterDto();
		parameterDto.setId(model.getId());
		parameterDto.setAlgorithmResultId(model.getAlgorithmResultId());
		parameterDto.setValue(model.getValue());
		parameterDto.setSymbol(model.getSymbol());
		return parameterDto;
	}

	@Override
	public Parameter mapBtoA(ParameterDto dto) {
		Parameter parameter = new Parameter();
		parameter.setId(dto.getId());
		parameter.setAlgorithmResultId(dto.getAlgorithmResultId());
		parameter.setValue(dto.getValue());
		parameter.setSymbol(dto.getSymbol());
		return parameter;
	}
}
