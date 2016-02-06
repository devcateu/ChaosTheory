package pl.chaos.theory.algorithm.impl;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Component;
import pl.chaos.theory.algorithm.Algorithm;
import pl.chaos.theory.algorithm.AlgorithmInfo;
import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.algorithm.ParameterInfo;
import pl.chaos.theory.algorithm.validation.RangeValidator;
import pl.chaos.theory.dto.model.ImageDto;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//TODO : implemnt it
@Component
/**
 * Implementation of Population Growth Algorithm.
 */
public class PopulationGrowth implements Algorithm {
	private final static AlgorithmType algorithmType = AlgorithmType.POPULATION_GROWTH;

	@Override
	public ImageDto calculate(Map<String, Double> parameters) {
            LotkaVolterraModel model = new LotkaVolterraModel(parameters.get("x"),
                    parameters.get("y"), parameters.get("t"), parameters.get("a"),
                    parameters.get("b"), parameters.get("c"), parameters.get("d"));
            RungeKutta rk = new RungeKutta(model, parameters.get("time"));
            List<LotkaVolterraResult> results;
            results = rk.solve();

		XYSeries xSeries = new XYSeries("preys");
		for (LotkaVolterraResult result : results) {
			xSeries.add(result.getT(), result.getX());
		}

		XYSeries ySeries = new XYSeries("predators");
		for (LotkaVolterraResult result : results) {
			ySeries.add(result.getT(), result.getY());
		}

		XYSeriesCollection colecion = new XYSeriesCollection();
		colecion.addSeries(ySeries);
		colecion.addSeries(xSeries);

		OutputStream outImage=new ByteArrayOutputStream();

		JFreeChart chart = ChartFactory.createXYLineChart("Frequency",
				"time", "population", colecion, PlotOrientation.VERTICAL, true, true, true);
		ImageDto image = new ImageDto();
		image.setImage(chart.createBufferedImage(1000,800));
		return image;
	}

	@Override
	public List<ParameterInfo> parameters() {
		ArrayList<ParameterInfo> parameterInfos = new ArrayList<ParameterInfo>();
		parameterInfos.add(new ParameterInfo(new RangeValidator(1, 1000), "x", "Initial populations of prey"));
		parameterInfos.add(new ParameterInfo(new RangeValidator(1, 1000), "y", "Initial populations of predators"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(1, 100), "t", "Start time of simulation"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(1, 1000), "time", "Time of simulation"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "a", "Birth rate of prey"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "b", "Mortality rate of prey"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "c", "Birth rate of predators"));
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "d", "Mortality rate of predators"));
		return parameterInfos;
	}

	@Override
	public AlgorithmInfo getAlgorithmInfo() {
		return new AlgorithmInfo(algorithmType.name(), 
                        "Algorithm describes the dynamics of bilogical system in witch two species interact.", algorithmType);
	}

	@Override public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}
}
