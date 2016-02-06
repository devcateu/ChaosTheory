package pl.chaos.theory.algorithm.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krzgac
 */
public class LorenzAtractorModel {
    
    private double x;
    private double y;
    private double z;
    private double a;
    private double b;
    private double c;

    public LorenzAtractorModel(double x, double y, double z, double a, double b, double c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println(this);    
    }
    
    public double dxdt( double x, double y, double z) {
        double res = a * (y - x);
        return res;
    }
    
    public double dydt( double x, double y, double z) {
        double res = x * (b - z) - y;
        return res;
    }
    
     public double dzdt( double x, double y, double z) {
         double res = x * y - c * z;
         return res;
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
