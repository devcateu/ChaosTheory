package pl.chaos.theory.dto.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;
import pl.chaos.theory.db.model.Algorithm;
import pl.chaos.theory.db.model.ParameterInfo;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.ParameterInfoDto;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmMapperTest extends BaseSpringTest {

	@Autowired
	private AlgorithmMapper algorithmMapper;

	@Test
	public void testMapAtoB() throws Exception {
		Algorithm algorithm = new Algorithm();
		algorithm.setId(13243L);
		algorithm.setName("zbyszel");
		algorithm.setDescription("extra fast");
		algorithm.setParameterInfoSet(new HashSet<ParameterInfo>());

		AlgorithmDto algorithmDto = algorithmMapper.mapAtoB(algorithm);

		assertThat(algorithm.getId()).isEqualTo(algorithmDto.getId());
		assertThat(algorithm.getName()).isEqualTo(algorithmDto.getName());
		assertThat(algorithm.getDescription()).isEqualTo(algorithmDto.getDescription());
		assertThat(algorithm.getParameterInfoSet()).isNotNull();
	}

	@Test
	public void testMapBtoA() throws Exception {
		AlgorithmDto algorithmDto = new AlgorithmDto();
		algorithmDto.setId(13243L);
		algorithmDto.setName("zbyszel");
		algorithmDto.setDescription("extra fast");
		algorithmDto.setParameterInfoSet(new HashSet<ParameterInfoDto>());

		Algorithm algorithm = algorithmMapper.mapBtoA(algorithmDto);

		assertThat(algorithmDto.getId()).isEqualTo(algorithm.getId());
		assertThat(algorithmDto.getName()).isEqualTo(algorithm.getName());
		assertThat(algorithmDto.getDescription()).isEqualTo(algorithm.getDescription());
		assertThat(algorithmDto.getParameterInfoSet()).isNotNull();

	}
}