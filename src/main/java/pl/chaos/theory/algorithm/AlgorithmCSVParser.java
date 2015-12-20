package pl.chaos.theory.algorithm;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TODO test it
@Component
public class AlgorithmCSVParser {

	public Map<String, Double> parse(String csv) throws IOException {
		Map<String, Double> result = new HashMap<String, Double>();
		CSVParser csvParser = CSVParser.parse(csv, CSVFormat.RFC4180);
		for (CSVRecord csvRecord : csvParser.getRecords()) {
			if (csvRecord.size() > 2) {
				throw new RuntimeException("Wrong line in file: " + csvRecord.toString());
			}

			String parameterName = csvRecord.get(0);
			String parameterValueString = csvRecord.get(1);
			Double parameterValue = Double.parseDouble(parameterValueString);

			result.put(parameterName, parameterValue);
		}

		return result;
	}
}
