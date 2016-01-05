package pl.chaos.theory.algorithm;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
/**
 * Parse csv file into parameter symbol - value map.
 */
public class AlgorithmCSVParser {

	/**
	 * Parse csv file into symbol of parameter - value map.
	 *
	 * @param csv Input file to parse.
	 * @return Parsed map(symbol - value).
	 * @throws ParserException            Throw when error in parsing CSV file.
	 * @throws WrongLineInCSVFile         Throw when some line in csv is wrong number of parameters.
	 * @throws RepeatedParameterException Throw when some parameter is repeated in csv file
	 */
	public Map<String, Double> parse(String csv) throws ParserException, WrongLineInCSVFile, RepeatedParameterException {

		try {
			CSVParser csvParser = CSVParser.parse(csv, CSVFormat.RFC4180);
			return readLines(csv, csvParser);
		} catch (IOException e) {
			throw new ParserException(csv);
		}
	}

	private Map<String, Double> readLines(String csv, CSVParser csvParser) throws IOException, WrongLineInCSVFile, RepeatedParameterException {
		Map<String, Double> result = new HashMap<String, Double>();
		for (CSVRecord csvRecord : csvParser.getRecords()) {
			readLine(csv, result, csvRecord);
		}
		return result;
	}

	private void readLine(String csv, Map<String, Double> result, CSVRecord csvRecord) throws WrongLineInCSVFile, RepeatedParameterException {
		if (csvRecord.size() != 2) {
			throw new WrongLineInCSVFile(csvRecord, csv);
		}

		String parameterName = csvRecord.get(0);
		String parameterValueString = csvRecord.get(1);
		Double parameterValue = Double.parseDouble(parameterValueString);
		if (result.containsKey(parameterName)) {
			throw new RepeatedParameterException(parameterName, result.get(parameterName), parameterValue);
		}

		result.put(parameterName, parameterValue);
	}
}
