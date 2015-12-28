package pl.chaos.theory.dto.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.dto.model.ParameterDto;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterMapperTest extends BaseSpringTest {

	@Autowired
	private ParameterMapper parameterMapper;

	@Test
	public void testMapAtoB() throws Exception {
		Parameter parameter = new Parameter();
		parameter.setId(1289L);
		parameter.setAlgorithmResultId(5313L);
		parameter.setValue(903123.42);
		parameter.setSymbol("sysyss");

		ParameterDto parameterDto = parameterMapper.mapAtoB(parameter);

		assertThat(parameterDto.getId()).isEqualTo(parameter.getId());
		assertThat(parameterDto.getValue()).isEqualTo(parameter.getValue());
		assertThat(parameterDto.getAlgorithmResultId()).isEqualTo(parameter.getAlgorithmResultId());
		assertThat(parameterDto.getSymbol()).isEqualTo(parameter.getSymbol());
	}

	@Test
	public void testMapBtoA() throws Exception {
		ParameterDto parameterDto = new ParameterDto();
		parameterDto.setId(1289L);
		parameterDto.setAlgorithmResultId(5313L);
		parameterDto.setValue(903123.42);

		Parameter parameter = parameterMapper.mapBtoA(parameterDto);

		assertThat(parameter.getId()).isEqualTo(parameterDto.getId());
		assertThat(parameter.getValue()).isEqualTo(parameterDto.getValue());
		assertThat(parameter.getAlgorithmResultId()).isEqualTo(parameterDto.getAlgorithmResultId());
		assertThat(parameter.getSymbol()).isEqualTo(parameterDto.getSymbol());
	}
}