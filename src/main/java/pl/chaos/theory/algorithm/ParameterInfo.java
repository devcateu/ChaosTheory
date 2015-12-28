package pl.chaos.theory.algorithm;

public class ParameterInfo {
	private final ParameterValidator validation;
	private final String symbol;
	private final String description;

	public ParameterInfo(ParameterValidator validation, String symbol, String description) {
		this.validation = validation;
		this.symbol = symbol;
		this.description = description;
	}

	public ParameterValidator getValidation() {
		return validation;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getDescription() {
		return description;
	}

	@Override public String toString() {
		return "ParameterInfo{" +
				"validation=" + validation +
				", symbol='" + symbol + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
