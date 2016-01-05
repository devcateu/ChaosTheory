package pl.chaos.theory.algorithm;

/**
 * Exception which was throw during parsing csv file.
 */
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
