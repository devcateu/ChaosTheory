package pl.chaos.theory.algorithm.impl;


import java.util.ArrayList;
import java.util.List;


public class RungeKutta {
    
    private static final double H = 0.1;
    
    private LotkaVolterraModel model;
    private double t;
    private double tMax;
    private double x;
    private double y;

    public RungeKutta(LotkaVolterraModel model, double t) {
        this.model = model;
        this.tMax = t;
        this.t = model.getT0();
        this.x = model.getX0();
        this.y = model.getY0();
    }
    
    public List<LotkaVolterraResult> solve() {
        
        double k1, k2, k3, k4;
        double l1, l2, l3, l4;
        
        List <LotkaVolterraResult> results = new ArrayList<LotkaVolterraResult>();
        results.add(new LotkaVolterraResult(t, x, y));
        
        for(int i = 0; i < tMax * 10; i++) {
        
            k1 = model.dxdt(t, x, y);
            l1 = model.dydt(t, x, y);

            k2 = model.dxdt(t + H/2, x + k1/2, y + l1/2);
            l2 = model.dydt(t + H/2, x + k1/2, y + l1/2);

            k3 = model.dxdt(t + H/2, x + k2/2, y + l2/2);
            l3 = model.dydt(t + H/2, x + k2/2, y + l2/2);

            k4 = model.dxdt(t + H, x + k3, y + l3);
            l4 = model.dydt(t + H, x + k3, y + l3);

            x += H * (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            y += H * (l1 + 2 * l2 + 2 * l3 + l4) / 6.0;

            t += H;
            
            results.add(new LotkaVolterraResult(t, x, y));
        
        }
        return results;
    }
    
}
