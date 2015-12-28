package pl.chaos.theory.algorithm;

public class ParserException extends Exception {
	private final String csv;

	public ParserException(String csv) {
		super("Error during parsing csv: " + csv);
		this.csv = csv;
	}

	public String getCsv() {
		return csv;
	}
}
