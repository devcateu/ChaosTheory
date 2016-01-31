package pl.chaos.theory.algorithm.impl;


public class LotkaVolterraModel {
    
    private double x0;
    private double y0;
    private double t0;
    private double alpha;
    private double beta;
    private double gamma;
    private double delta;

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
    
    public double dxdt(double t, double x, double y) {
        return alpha * x - beta * x * y;
    }
    
    public double dydt(double t, double x, double y) {
        return gamma * x * y - delta * y;
    }
}