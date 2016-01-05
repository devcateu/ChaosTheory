package pl.chaos.theory.view.calculation;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.AlgorithmCSVParser;
import pl.chaos.theory.algorithm.AlgorithmInfo;
import pl.chaos.theory.util.Util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ViewScoped
@Component("algorithm")
/**
 * Represent parameters needed to new calculate.
 */
public class AlgorithmView {
	private final Map<String, Double> inputParams = new HashMap<String, Double>();
	private AlgorithmInfo selectedAlgorithm;
	private AlgorithmCSVParser algorithmCSVParser;

	@Autowired
	public AlgorithmView(CalculationManager calculationManager, AlgorithmCSVParser algorithmCSVParser) {
		List<AlgorithmInfo> allAlgorithms = calculationManager.getAllAlgorithms();
		if (allAlgorithms != null && allAlgorithms.size() > 0) {
			selectedAlgorithm = allAlgorithms.get(0);
		}
		this.algorithmCSVParser = algorithmCSVParser;
	}

	public AlgorithmInfo getSelectedAlgorithm() {
		return selectedAlgorithm;
	}

	public void setSelectedAlgorithm(AlgorithmInfo selectedAlgorithm) {
		if (!selectedAlgorithm.equals(this.selectedAlgorithm)) {
			inputParams.clear();
			this.selectedAlgorithm = selectedAlgorithm;
		}
	}

	public Map<String, Double> getInputParams() {
		return inputParams;
	}

	/**
	 * Parse CSV file and put parameters from it into current inputParams. Before putted clear inputParams Map.
	 * Error during processing will show on UI.
	 *
	 * @param event Event which contains uploaded file.
	 */
	public void handleFileUpload(FileUploadEvent event) {
		try {
			InputStream inputStream = event.getFile().getInputstream();
			String csvFromFile = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			Map<String, Double> parametersMap = algorithmCSVParser.parse(csvFromFile);
			inputParams.clear();
			inputParams.putAll(parametersMap);
		} catch (Exception e) {
			String message = e.getMessage();
			Util.addMessage("csvUploader", FacesMessage.SEVERITY_ERROR, message);
		}
	}
}
