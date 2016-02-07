package pl.chaos.theory.algorithm.impl;

/**
 * * @ Implementation of Lotka Volterra Model.
 */
public class LotkaVolterraModel {
    
    private double x0;
    private double y0;
    private double t0;
    private double alpha;
    private double beta;
    private double gamma;
    private double delta;

    /**
	 * Create a new instance of Lorenz Attractor Model.
	 *
	 * @param x0 - x start point
         * @param y0 - y start point
         * @param t0 - z start point
         * @param alpha - parameter alpha
	 * @param beta - parameter beta
         * @param gamma - parameter gamma
         * @param delta - parameter delta
	 */
    public LotkaVolterraModel(double x0, double y0, double t0, double alpha, double beta, double gamma, double delta) {
        this.x0 = x0;
        this.y0 = y0;
        this.t0 = t0;
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
        this.delta = delta;
    }

    public double getT0() {
        return t0;
    }

    public void setT0(int t0) {
        this.t0 = t0;
    }
    
    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getGamma() {
        return gamma;
    }

    public double getDelta() {
        return delta;
    }
    
      /**
	 * Return value after integrated over x.
	 *
	 * @param t - time value
         * @param x - y value
         * @param y - z value
         * 
	 * @return  - integrated value over x.
	 */
    public double dxdt(double t, double x, double y) {
        return alpha * x - beta * x * y;
    }
    
      /**
	 * Return value after integrated over y.
	 *
	 * @param t - time value
         * @param x - x value
         * @param y - y value
         * 
	 * @return  - integrated value over y.
	 */
    public double dydt(double t, double x, double y) {
        return gamma * x * y - delta * y;
    }
}