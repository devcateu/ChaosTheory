package pl.chaos.theory.dto.model;

/**
 * Dto represent Parameter with all needed parameters.
 */
public class ParameterDto extends Dto {
	private Long algorithmResultId;
	private Double value;
	private String symbol;

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
