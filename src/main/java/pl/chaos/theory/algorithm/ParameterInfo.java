package pl.chaos.theory.algorithm;

/**
 * Info about Parameter. Contains validator, symbol and description for that parameter .
 */
public class ParameterInfo {
	private final ParameterValidator validator;
	private final String symbol;
	private final String description;

	public ParameterInfo(ParameterValidator validator, String symbol, String description) {
		this.validator = validator;
		this.symbol = symbol;
		this.description = description;
	}

	public ParameterValidator getValidator() {
		return validator;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ParameterInfo{" +
				"validator=" + validator +
				", symbol='" + symbol + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
