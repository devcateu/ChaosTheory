package pl.chaos.theory.dto.model;

public class ParameterDto extends Dto {
	private Long id;
	private Long algorithmResultId;
	private Double value;
	private String symbol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
