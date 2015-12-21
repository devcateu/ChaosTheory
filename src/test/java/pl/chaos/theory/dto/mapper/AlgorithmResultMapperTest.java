package pl.chaos.theory.dto.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;
import pl.chaos.theory.db.model.Algorithm;
import pl.chaos.theory.db.model.AlgorithmResult;
import pl.chaos.theory.db.model.Parameter;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ParameterDto;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmResultMapperTest extends BaseSpringTest {

	@Autowired
	private AlgorithmResultMapper algorithmResultMapper;

	@Test
	public void testMapAtoB() throws Exception {

		AlgorithmResult algorithmResult = new AlgorithmResult();
		algorithmResult.setAlgorithmId(6343241L);
		algorithmResult.setId(67242L);
		algorithmResult.setUserId(112312L);
		algorithmResult.setDescription("desxc esc");
		algorithmResult.setImageId(423L);
		algorithmResult.setAlgorithm(new Algorithm());
		algorithmResult.setParameters(new HashSet<Parameter>());

		AlgorithmResultDto algorithmResultDto = algorithmResultMapper.mapAtoB(algorithmResult);

		assertThat(algorithmResult.getId()).isEqualTo(algorithmResultDto.getId());
		assertThat(algorithmResult.getAlgorithmId()).isEqualTo(algorithmResultDto.getAlgorithmId());
		assertThat(algorithmResult.getUserId()).isEqualTo(algorithmResultDto.getUserId());
		assertThat(algorithmResult.getImageId()).isEqualTo(algorithmResultDto.getImageId());
		assertThat(algorithmResult.getDescription()).isEqualTo(algorithmResultDto.getDescription());
		assertThat(algorithmResult.getParameters()).isNotNull();
		assertThat(algorithmResult.getAlgorithmId()).isNotNull();
	}

	@Test
	public void testMapBtoA() throws Exception {

		AlgorithmResultDto algorithmResultDto = new AlgorithmResultDto();
		algorithmResultDto.setAlgorithmId(6343241L);
		algorithmResultDto.setId(67242L);
		algorithmResultDto.setUserId(112312L);
		algorithmResultDto.setDescription("desxc esc");
		algorithmResultDto.setImageId(423L);
		algorithmResultDto.setAlgorithm(new AlgorithmDto());
		algorithmResultDto.setParameters(new HashSet<ParameterDto>());

		AlgorithmResult algorithmResult = algorithmResultMapper.mapBtoA(algorithmResultDto);

		assertThat(algorithmResultDto.getId()).isEqualTo(algorithmResult.getId());
		assertThat(algorithmResultDto.getAlgorithmId()).isEqualTo(algorithmResult.getAlgorithmId());
		assertThat(algorithmResultDto.getUserId()).isEqualTo(algorithmResult.getUserId());
		assertThat(algorithmResultDto.getImageId()).isEqualTo(algorithmResult.getImageId());
		assertThat(algorithmResultDto.getDescription()).isEqualTo(algorithmResult.getDescription());
		assertThat(algorithmResultDto.getParameters()).isNotNull();
		assertThat(algorithmResultDto.getAlgorithmId()).isNotNull();

	}
}