package pl.chaos.theory.dto.model;

import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.util.Util;

import java.util.HashSet;
import java.util.Set;

public class AlgorithmResultDto extends Dto {
	private final Set<ParameterDto> parameters = new HashSet<ParameterDto>();
	private Long userId;
	private Long imageId;
	private String description;
	private AlgorithmType algorithmType;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ParameterDto> getParameters() {
		return parameters;
	}

	public void setParameters(Set<ParameterDto> parameters) {
		Util.copyCollection(this.parameters, parameters);
	}

	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}
}
