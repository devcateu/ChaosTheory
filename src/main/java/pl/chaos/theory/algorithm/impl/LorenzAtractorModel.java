package pl.chaos.theory.algorithm.impl;


/**
 * * @ Implementation of Lorentz Attractor Model.
 */
public class LorenzAtractorModel {
    
    private double x;
    private double y;
    private double z;
    private double a;
    private double b;
    private double c;

    /**
	 * Create a new instance of Lorenz Attractor Model.
	 *
	 * @param x - x start point
         * @param y - y start point
         * @param z - z start point
         * @param a - parameter a
	 * @param b - parameter b
         * @param c - parameter c 
	 */
    public LorenzAtractorModel(double x, double y, double z, double a, double b, double c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println(this);    
    }
    
    /**
	 * Return value after integrated over x.
	 *
	 * @param x - x value
         * @param y - y value
         * @param z - z value
         * 
	 * @return  - integrated value over x.
	 */
    public double dxdt( double x, double y, double z) {
        return a * (y - x);
    }
    
    /**
	 * Return value after integrated over y.
	 *
	 * @param x - x value
         * @param y - y value
         * @param z - z value
         * 
	 * @return  - integrated value over y.
	 */
    public double dydt( double x, double y, double z) {
        return x * (b - z) - y;
    }
    
    /**
	 * Return value after integrated over z.
	 *
	 * @param x - x value
         * @param y - y value
         * @param z - z value
         * 
	 * @return  - integrated value over z.
	 */
     public double dzdt( double x, double y, double z) {
         return x * y - c * z;
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

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "LorentzAtractorModel{" + "x=" + x + ", y=" + y + ", z=" + z + ", a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    
}
