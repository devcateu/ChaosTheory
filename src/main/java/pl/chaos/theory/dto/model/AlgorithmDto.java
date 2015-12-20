package pl.chaos.theory.dto.model;

import java.util.Set;

public class AlgorithmDto extends Dto {
	private Long id;
	private String name;
	private String description;
	private Set<ParameterInfoDto> parameterInfoSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ParameterInfoDto> getParameterInfoSet() {
		return parameterInfoSet;
	}

	public void setParameterInfoSet(Set<ParameterInfoDto> parameterInfoSet) {
		this.parameterInfoSet = parameterInfoSet;
	}
}
