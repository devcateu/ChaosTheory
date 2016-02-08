package pl.chaos.theory.algorithm.impl;

/**
 * Implementation of Lotka Volterra Result. Class contains calculated points.
 */
public class LotkaVolterraResult {
    
    double t;
    double x;
    double y;

     /**
	 * Create a new instance of  Lotka Volterra Result.
	 *
	 * @param t - time of simulation
         * @param x - x calculated point
         * @param y - y calculated point
	 */
    public LotkaVolterraResult(double t, double x, double y) {
        this.t = t;
        this.x = x;
        this.y = y;
    }

    public void setT(double t) {
        this.t = t;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getT() {
        return t;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "LotkaVolterraResult{" + "t=" + t + ", x=" + x + ", y=" + y + '}';
    }
 
}
