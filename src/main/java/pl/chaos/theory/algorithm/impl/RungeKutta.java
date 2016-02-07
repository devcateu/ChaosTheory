package pl.chaos.theory.algorithm.impl;


import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Runge Kutta algorithm.
 */
public class RungeKutta {
    
    private static final double H = 0.01;
    
    private LotkaVolterraModel model;
    private double t;
    private double tMax;
    private double x;
    private double y;

    /**
	 * Create a new instance of Runge Kutta.
	 *
	 * @param model - model of Lotka Voltera
         * @param t - time of simulation
	 */
    public RungeKutta(LotkaVolterraModel model, double t) {
        this.model = model;
        this.tMax = t;
        this.t = model.getT0();
        this.x = model.getX0();
        this.y = model.getY0();
    }
    
    /**
	 * Solve  Lotka Volterra algorithm using Runge Kutta 4 method.
	 *
         * @return - results, List of callculated points
	 */
    public List<LotkaVolterraResult> solve() {
        
        double k1, k2, k3, k4;
        double l1, l2, l3, l4;
        
        List <LotkaVolterraResult> results = new ArrayList<LotkaVolterraResult>();
        results.add(new LotkaVolterraResult(t, x, y));
        
        
        double stop = t + tMax;
        for(double i = t; i < stop ; i += H) {
        
            k1 = H * model.dxdt(t, x, y);
            l1 = H * model.dydt(t, x, y);

            k2 = H * model.dxdt(t + H/2, x + k1/2, y + l1/2);
            l2 = H * model.dydt(t + H/2, x + k1/2, y + l1/2);

            k3 = H * model.dxdt(t + H/2, x + k2/2, y + l2/2);
            l3 = H * model.dydt(t + H/2, x + k2/2, y + l2/2);

            k4 = H * model.dxdt(t + H, x + k3, y + l3);
            l4 = H * model.dydt(t + H, x + k3, y + l3);

            x += (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            y += (l1 + 2 * l2 + 2 * l3 + l4) / 6.0;

            t += H;
            
            results.add(new LotkaVolterraResult(t, x, y));
        
        }
        return results;
    }
    
}
