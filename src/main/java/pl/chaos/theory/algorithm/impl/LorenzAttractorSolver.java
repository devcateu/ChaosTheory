package pl.chaos.theory.algorithm.impl;


import java.util.ArrayList;
import java.util.List;

/**
 * Class solve equations for Lorenz Model.
 */
public class LorenzAttractorSolver {
    
    private static final double H = 0.001;
    
    private LorenzAtractorModel model;
    public int maxIteration;
    public double x;
    public double y;
    public double z;

    /**
	 * Create a new instance of  LorenzAttractorSolver.
	 *
	 * @param model - model of Lorenz Attractor
         * @param maxIteration - max itterations steps
	 */
    public LorenzAttractorSolver(LorenzAtractorModel model, int maxIteration) {
        this.model = model;
        this.x = model.getX();
        this.y = model.getY();
        this.z = model.getZ();
        this.maxIteration = maxIteration;
    }
    
    /**
	 * Solve Lorenz Attractor algorithm using Euler method.
	 *
         * @return - results, List of callculated points
	 */
   public List<LorenzAtractorResult> solve() {
       
       List <LorenzAtractorResult> results = new ArrayList<LorenzAtractorResult>();
       double xn = 0, yn = 0, zn = 0;
       double xp = x, yp = y, zp = z;
       for(int i = 0; i < maxIteration; i++) {

                xn = xp + H * model.dxdt(xp, yp, zp);
                yn = yp + H * model.dydt(xp, yp, zp);
                zn = zp + H * model.dzdt(xp, yp, zp);
                xp = xn;
                yp = yn;
                zp = zn;
                results.add(new LorenzAtractorResult(xp, yp, zp));
       
      }
      return results;
   }    

    @Override
    public String toString() {
        return "RK4{" + "model=" + model + ", maxIteration=" + maxIteration + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }
   
}
