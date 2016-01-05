package pl.chaos.theory.algorithm;

/**
 * Exception which was throw when some parameter in csv file is repeated.
 */
public class RepeatedParameterException extends Exception {
	private final String symbol;
	private final Double valueFirst;
	private final Double valueSecond;

	public RepeatedParameterException(String symbol, Double valueFirst, Double valueSecond) {
		super("CSV file contain two value for single parameter: " + symbol
				+ " , first value = " + valueFirst
				+ " , second value = " + valueSecond);
		this.symbol = symbol;
		this.valueFirst = valueFirst;
		this.valueSecond = valueSecond;
	}

	public String getSymbol() {
		return symbol;
	}

	public Double getValueFirst() {
		return valueFirst;
	}

	public Double getValueSecond() {
		return valueSecond;
	}
}
