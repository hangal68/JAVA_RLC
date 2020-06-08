package interface1;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class SimulationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int N = 40000;
	double dt = 0.000000005;
	double t0 = 0;
	double i0 = 0;
	double u0 = 0;
	
	//
    ArrayList<Double> t, Uwe;
	//do szeregowego
	ArrayList<Double> i, di, Ur, Ul, Uc;
	//do równoległego
	ArrayList<Double> u, du, Ir, Il, Ic;
	
	XYSeries series;
	XYSeries Rseries;
	XYSeries Lseries;
	XYSeries Cseries;
	
	JFreeChart chart;
	public SimulationPanel() throws HeadlessException {
		
		t = new ArrayList<Double>();
		Uwe = new ArrayList<Double>();
		//do szeregowego
		i = new ArrayList<Double>();
		di = new ArrayList<Double>(); 
		Ur = new ArrayList<Double>(); 
		Ul = new ArrayList<Double>(); 
		Uc = new ArrayList<Double>();
		
		// do r�wnoleg�ego
		u = new ArrayList<Double>();
		du = new ArrayList<Double>();
		Ir = new ArrayList<Double>();
		Il = new ArrayList<Double>();
		Ic = new ArrayList<Double>();
		
	
		XYDataset dataset = createEmptyDataSet();
		
		
		
		chart = ChartFactory.createXYLineChart(
				"U(t)",//Tytul
				"t(s)", // os X
				"U (V)", //os Y 
				dataset, // Dane 
				PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
				true, // legenda
				true, // tooltips
				false
			);
		
		ChartPanel chartPanel = new ChartPanel( chart );
		this.add(chartPanel);
	
	
	
	}
	
	public XYDataset createEmptyDataSet() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		series = new XYSeries("");
		Rseries = new XYSeries("UR");
		Lseries = new XYSeries("UL");
		Cseries = new XYSeries("UC");
		dataset.addSeries(series);
		dataset.addSeries(Rseries);
		dataset.addSeries(Lseries);
		dataset.addSeries(Cseries);
		
		
		return dataset;
	
	}
	
	public XYDataset createDataSet(String parametr) {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		dataset.addSeries(Rseries);
		dataset.addSeries(Lseries);
		dataset.addSeries(Cseries);
		
		
		return dataset;
	
	}
	    
	public void simulate(double U0, double R, double L, double C, double f, String mode)	{
		
		double w = f*2*Math.PI;
		t.clear();
		t.add(t0);
		Uwe.clear();
		Uwe.add(0.0);
		
		switch (mode) {
			case "Rser":
				i.clear();
				di.clear();
				Ur.clear();
				Ul.clear();
				Uc.clear();
				
			    i.add(i0);
			    di.add(U0 * w / R);
			    Ur.add(R * i0);
				
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	Ur.add(Uwe.get(j));
			    }			
				break;
				
			case "RLser":
				i.clear();
				di.clear();
				Ur.clear();
				Ul.clear();
				Uc.clear();
				
			    i.add(i0);
			    di.add(U0 * w / (Math.sqrt((R * R) + ((w * L) * (w * L)))));
			    Ur.add(R * i0);
			    Ul.add(L * di.get(0));
				
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	i.add(i.get(j) + di.get(j) * dt);
			    	di.add(di.get(j) + (U0 / L * w * Math.cos(w * t.get(j)) - R / L * di.get(j)) * dt);
			    	Ur.add(R * i.get(j));
			    	Ul.add(L * di.get(j));
			    }			
				break;
				
			case "RCser":
				i.clear();
				di.clear();
				Ur.clear();
				Ul.clear();
				Uc.clear();
				
			    i.add(i0);
			    Ur.add(R * i0);
			    Uc.add(Uwe.get(0) - Ul.get(0) - Ur.get(0));
			    
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	i.add(i.get(j) + (U0 * w * Math.cos(w * t.get(j))) - (i.get(j) / C) * dt);
			    	Ur.add(R * i.get(j));
			    	Uc.add(Uwe.get(j) - Ur.get(j));
			    }			
				break;
				
			case "RLCser":
				i.clear();
				di.clear();
				Ur.clear();
				Ul.clear();
				Uc.clear();
				
			    i.add(i0);
			    di.add(U0 * w / Math.sqrt((R * R) + (w * L - (1 / (w * C))) * (w * L - (1 / (w * C)))));
			    Ur.add(R * i0);
			    Ul.add(L * di.get(0));
			    Uc.add(Uwe.get(0) - Ul.get(0) - Ur.get(0));
				
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	i.add(i.get(j) + di.get(j) * dt);
			    	di.add(di.get(j) + (U0 / L * w * Math.cos(w * t.get(j)) - R / L * di.get(j) - i.get(j) / L / C) * dt);
			    	Ur.add(R * i.get(j));
			    	Ul.add(L * di.get(j));
			    	Uc.add(Uwe.get(j) - Ul.get(j) - Ur.get(j));
			    }			
				break;
	
			case "LCpar":
				u.clear();
				du.clear();
				Ir.clear();
				Il.clear();
				Ic.clear();
				
			    u.add(u0);
			    du.add(U0 * w);
			    Ic.add(C * du.get(0));
			    Il.add(Uwe.get(0) / (1 / Math.sqrt(w * C * w * C + (1 / (w * L * w * L)))) - Ic.get(0));

			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	u.add(u.get(j) + du.get(j) * dt);
			    	du.add(du.get(j) + (((U0 * w) / (R * C)) * Math.cos(w * t.get(j)) - (u.get(j) / L / C)) * dt);
			    	Ic.add(C * du.get(j));
			    	Il.add((Uwe.get(j) / (1 / Math.sqrt(w * C * w * C + (1 / (w * L * w * L))))) - Ic.get(j));
			    }
		        break;
		        
			case "RCpar":
				u.clear();
				du.clear();
				Ir.clear();
				Il.clear();
				Ic.clear();
				
			    u.add(u0);
			    du.add(U0 * w);
			    Ir.add(u0 / R);
			    Ic.add(C * du.get(0));
			    
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	u.add(u.get(j) + du.get(j) * dt);
			    	du.add(du.get(j) + (((U0 * w) / (R * C)) * Math.cos(w * t.get(j)) - ((1 / (R * C)) * du.get(j))) * dt);
			    	Ir.add(u.get(j) / R);
			    	Ic.add(C * du.get(j));
			    }
		        break;
		        
			case "RLpar":
				u.clear();
				du.clear();
				Ir.clear();
				Il.clear();
				
			    u.add(u0);
			    Ir.add(u0 / R);
			    Il.add(Uwe.get(0) / (w * R * L / Math.sqrt(R * R + w * L * w * L)) - Ir.get(0));
			    
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	u.add(u.get(j) + (U0 * w * Math.cos(w * t.get(j) - R * u.get(j) / L)) * dt);
			    	Ir.add(u.get(j) / R);
			    	Il.add((Uwe.get(j) / (w * R * L / Math.sqrt(R * R + w * L * w * L))) - Ir.get(j));
			    }
				break;
				
			case "RLCpar":
				u.clear();
				du.clear();
				Ir.clear();
				Il.clear();
				Ic.clear();
				//
			    u.add(u0);
			    du.add(U0 * w);
			    Ir.add(u0 / R);
			    Ic.add(C * du.get(0));
			    Il.add(Uwe.get(0) / ((w * L * R) / Math.sqrt((R - w * w * R * L * C) * (R - w * w * R * L * C) + (w * L) * (w * L))) - Ir.get(0) - Ic.get(0));
			    
			    for (int j = 0; j < N; j++) {
			    	t.add(t.get(j) + dt);
			    	Uwe.add(U0 * Math.sin(w * t.get(j)));
			    	u.add(u.get(j) + du.get(j) * dt);
			    	du.add(du.get(j) + (((U0 * w) / (R * C)) * Math.cos(w * t.get(j)) - ((1 / (R * C)) * du.get(j)) - (u.get(j) / L / C)) * dt);
			    	Ir.add(u.get(j) / R);
			    	Ic.add(C * du.get(j));
			    	Il.add((Uwe.get(j) / ((w * L * R) / Math.sqrt((R - w * w * R * L * C) * (R - w * w * R * L * C) + (w * L) * (w * L)))) - Ir.get(j) - Ic.get(j));
			    }
		        break;
		}
	}
	
	
	public void addingSeries(String parametr) {
		
		Rseries.clear();
		Lseries.clear();
		Cseries.clear();
		
		switch(parametr) {
			case "series":
				
				for(int i =0; i<N-1; i++){
					Rseries.add(t.get(i), Ur.get(i));
					Lseries.add(t.get(i), Ul.get(i));
					Cseries.add(t.get(i), Uc.get(i));
					//System.out.println("sda");
				}
				break;
			case "parallel":
				for(int i =0; i<N-1; i++){
					Rseries.add(t.get(i), Ir.get(i));
					Lseries.add(t.get(i), Il.get(i));
					Cseries.add(t.get(i), Ic.get(i));
				}
				break;
	
			default:
				
				break;
	}
		
		
		
	
	}
}