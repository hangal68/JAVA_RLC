package interface1;

import java.awt.HeadlessException;
import java.util.ArrayList;

public class SimulationPanel {

	int N = 2000;
	double dt = 0.01;
	double t0 = 0;
	double i0 = 0;
	double di0 = 0;
	double f = 1000;
	double w = f*2*Math.PI;
	ArrayList<Double> t;
	ArrayList<Double> i;
	ArrayList<Double> di;
	ArrayList<Double> Ur;
	ArrayList<Double> Ul;
	ArrayList<Double> Uc;
	
	public SimulationPanel() throws HeadlessException {
		
		t = new ArrayList<Double>(); 
		i = new ArrayList<Double>(); 
		di = new ArrayList<Double>(); 
		Ur = new ArrayList<Double>(); 
		Ul = new ArrayList<Double>(); 
		Uc = new ArrayList<Double>(); 
	}
	    
	void simulate(double U0, double R, double C, double L)	{
		
		t.add(t0);
	    i.add(i0);
	    di.add(di0);
	    Ur.add(R * i0);
	    Ul.add(L * di0);
	    Uc.add(0.0);// do zmiany
	    
	    for (int j = 0; j < N; j++) {
	    
	    	t.add(t.get(j) + dt);
	    	i.add(i.get(j) + di.get(j) * dt);
	    	di.add(di.get(j) + (U0 / L * w *Math.cos(w * t.get(j)) - R / L * di.get(j) - i.get(j) / L / C) * dt);
	    	Ur.add(R * i.get(j));
	    	Ul.add(L * di.get(j));
	    	// Uc.add
	    	
	    }

	}
}
