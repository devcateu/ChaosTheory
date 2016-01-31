package pl.chaos.theory.algorithm.impl;

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
            RungeKutta rk = new RungeKutta(model, parameters.get("time") * 10);
            List<LotkaVolterraResult> results = new ArrayList<LotkaVolterraResult>();
            results = rk.solve();
            
   
            return new ImageDto();
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
                parameterInfos.add(new ParameterInfo(new RangeValidator(0, 10), "d", "Mortality rate of prey"));
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
