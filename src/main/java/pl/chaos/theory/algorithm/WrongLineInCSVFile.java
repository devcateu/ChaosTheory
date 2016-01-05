package pl.chaos.theory.algorithm;

import org.apache.commons.csv.CSVRecord;

/**
 * Exception which was throw when is wrong number of information in line.
 */
public class WrongLineInCSVFile extends Exception {
	private final CSVRecord csvRecord;
	private final String csv;

	public WrongLineInCSVFile(CSVRecord csvRecord, String csv) {
		super("Wrong record " + csvRecord.toString() + ", in CSV file " + csv);
		this.csvRecord = csvRecord;
		this.csv = csv;
	}

	public CSVRecord getCsvRecord() {
		return csvRecord;
	}

	public String getCsv() {
		return csv;
	}
}
