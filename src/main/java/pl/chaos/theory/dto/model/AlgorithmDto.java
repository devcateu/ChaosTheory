package pl.chaos.theory.dto.model;

import pl.chaos.theory.util.Util;

import java.util.HashSet;
import java.util.Set;

public class AlgorithmDto extends Dto {
	private final Set<ParameterInfoDto> parameterInfoSet = new HashSet<ParameterInfoDto>();
	private Long id;
	private String name;
	private String description;

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
		Util.copyCollection(this.parameterInfoSet, parameterInfoSet);
	}
}
