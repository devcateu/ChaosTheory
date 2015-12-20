package pl.chaos.theory.view.calculation;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.AlgorithmCSVParser;
import pl.chaos.theory.algorithm.AlgorithmFacade;
import pl.chaos.theory.db.service.AlgorithmService;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.AlgorithmDto;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.dto.model.UserDto;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

//TODO check it
@Component("calculationManager")
public class CalculationManager {

	private final AlgorithmCSVParser algorithmCSVParser;
	private final AlgorithmFacade algorithmFacade;
	private final AlgorithmService algorithmService;
	private final UserService userService;

	@Autowired
	public CalculationManager(AlgorithmCSVParser algorithmCSVParser,
														AlgorithmFacade algorithmFacade,
														AlgorithmService algorithmService, UserService userService) {
		this.algorithmCSVParser = algorithmCSVParser;
		this.algorithmFacade = algorithmFacade;
		this.algorithmService = algorithmService;
		this.userService = userService;
	}

	public AlgorithmResultDto calculateFromCSVFile(Part file, AlgorithmDto algorithmDto) throws IOException {
		InputStream inputStream = file.getInputStream();
		String csvFromFile = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		Map<String, Double> parametersMap = algorithmCSVParser.parse(csvFromFile);
		ImageDto imageDto = algorithmFacade.calculate(algorithmDto, parametersMap);
		return algorithmService.saveResult(algorithmDto, parametersMap, imageDto);
	}

	public Collection<AlgorithmDto> getAllAlgorithms() {
		return algorithmService.getAllAlgorithms();
	}

	public Collection<AlgorithmResultDto> getAllAlgorithmResultForUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDto userDto = userService.getUserByEmail(auth.getName());
		return algorithmService.getAllResultForUser(userDto.getId());
	}

	public ImageDto getImageById(Long imageId) {
		return algorithmService.getImageById(imageId);
	}
}
