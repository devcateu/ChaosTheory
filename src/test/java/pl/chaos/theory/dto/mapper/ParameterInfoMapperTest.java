package pl.chaos.theory.dto.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;
import pl.chaos.theory.db.model.ParameterInfo;
import pl.chaos.theory.dto.model.ParameterInfoDto;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterInfoMapperTest extends BaseSpringTest {

	@Autowired
	private ParameterInfoMapper parameterInfoMapper;

	@Test
	public void testMapAtoB() throws Exception {
		ParameterInfo parameterInfo = new ParameterInfo();
		parameterInfo.setDescription("description");
		parameterInfo.setId(31L);
		parameterInfo.setSymbol("x");
		parameterInfo.setAlgorithmId(32131L);

		ParameterInfoDto parameterInfoDto = parameterInfoMapper.mapAtoB(parameterInfo);

		assertThat(parameterInfo.getId()).isEqualTo(parameterInfoDto.getId());
		assertThat(parameterInfo.getSymbol()).isEqualTo(parameterInfoDto.getSymbol());
		assertThat(parameterInfo.getDescription()).isEqualTo(parameterInfoDto.getDescription());
		assertThat(parameterInfo.getAlgorithmId()).isEqualTo(parameterInfoDto.getAlgorithmId());
	}

	@Test
	public void testMapBtoA() throws Exception {
		ParameterInfoDto parameterInfoDto = new ParameterInfoDto();
		parameterInfoDto.setDescription("description");
		parameterInfoDto.setId(31L);
		parameterInfoDto.setSymbol("x");
		parameterInfoDto.setAlgorithmId(32131L);

		ParameterInfo parameterInfo = parameterInfoMapper.mapBtoA(parameterInfoDto);

		assertThat(parameterInfoDto.getId()).isEqualTo(parameterInfo.getId());
		assertThat(parameterInfoDto.getSymbol()).isEqualTo(parameterInfo.getSymbol());
		assertThat(parameterInfoDto.getDescription()).isEqualTo(parameterInfo.getDescription());
		assertThat(parameterInfoDto.getAlgorithmId()).isEqualTo(parameterInfo.getAlgorithmId());

	}
}