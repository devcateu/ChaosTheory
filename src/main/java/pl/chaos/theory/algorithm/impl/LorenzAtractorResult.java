package pl.chaos.theory.algorithm.impl;



/**
 * Implementation of Lorenz Atractor Result. Class contains calculated points.
 */
public class LorenzAtractorResult {
    
    private double x;
    private double y;
    private double z;

     /**
	 * Create a new instance of LorenzAtractorResult.
	 *
	 * @param x - x calculated point
         * @param y - y calculated point
         * @param z - z calculated point
	 */
    public LorenzAtractorResult(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
}
