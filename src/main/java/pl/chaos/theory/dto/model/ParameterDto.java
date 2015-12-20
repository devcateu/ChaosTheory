package pl.chaos.theory.dto.model;

public class ParameterDto extends Dto {
	private Long id;
	private Long parameterInfoId;
	private Long algorithmResultId;
	private ParameterInfoDto parameterInfo;
	private Double value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParameterInfoId() {
		return parameterInfoId;
	}

	public void setParameterInfoId(Long parameterInfoId) {
		this.parameterInfoId = parameterInfoId;
	}

	public ParameterInfoDto getParameterInfo() {
		return parameterInfo;
	}

	public void setParameterInfo(ParameterInfoDto parameterInfo) {
		this.parameterInfo = parameterInfo;
	}

	public Long getAlgorithmResultId() {
		return algorithmResultId;
	}

	public void setAlgorithmResultId(Long algorithmResultId) {
		this.algorithmResultId = algorithmResultId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
