package pl.chaos.theory.algorithm.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.Algorithm;
import pl.chaos.theory.algorithm.AlgorithmInfo;
import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.algorithm.ParameterInfo;
import pl.chaos.theory.algorithm.validation.RangeValidator;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//TODO : implemnt it
@Component
/**
 * Implementation of Chaos Number Generation Algorithm.
 */
public class LorenzAttractor implements Algorithm {
	private final static AlgorithmType algorithmType = AlgorithmType.LORENZ_ATTRACTOR;

	@Override
	public ImageDto calculate(Map<String, Double> parameters) {
            
            LorenzAtractorModel model = new LorenzAtractorModel(
                    parameters.get("x"), parameters.get("y"), parameters.get("z"),
                    parameters.get("a"), parameters.get("b"), parameters.get("c"));
            
            LorenzAttractorSolver solver = new LorenzAttractorSolver(model, 50000);
            List<LorenzAtractorResult> results = solver.solve();
            
            XYSeriesCollection colection = new XYSeriesCollection();
            XYSeries series = new XYSeries("data");
            
            for (LorenzAtractorResult res : results) {
            series.add(res.getX(), res.getZ());
            }
            
            colection.addSeries(series);
            
            OutputStream outImage = new ByteArrayOutputStream();
            
            JFreeChart chart = ChartFactory.createScatterPlot("Lorenz Attractor",
                "x", "y", colection, PlotOrientation.VERTICAL, true, true, true);
            
            ImageDto image = new ImageDto();
            image.setImage(chart.createBufferedImage(800, 800));
            return image;
	}

	@Override
	public List<ParameterInfo> parameters() {
		ArrayList<ParameterInfo> parameterInfos = new ArrayList<ParameterInfo>();
		parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "x", "x starting value"));
		parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "y", "y starting value"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "z", "z starting value"));
		parameterInfos.add(new ParameterInfo(new RangeValidator(0, 50), "a", "parameter a (Lorenz default value: 10)"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 50), "b", "parameter b (Lorenz default value: 28)"));
		parameterInfos.add(new ParameterInfo(new RangeValidator(0, 50), "c", "parameter c (Lorenz default value: 2.26)"));
		return parameterInfos;
	}

	@Override
	public AlgorithmInfo getAlgorithmInfo() {
		return new AlgorithmInfo(algorithmType.name(), "deeees", algorithmType);
	}

	@Override
	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

}
