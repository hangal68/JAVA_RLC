package interface1;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class SimulationPanel extends JPanel {

	int N = 40000;
	double dt = 0.000000005;
	double t0 = 0;
	double i0 = 0;
	double di0 = 0;
	
	ArrayList<Double> t;
	ArrayList<Double> i;
	ArrayList<Double> di;
	ArrayList<Double> Ur;
	ArrayList<Double> Ul;
	ArrayList<Double> Uc;
	
	JFreeChart chart;
	public SimulationPanel() throws HeadlessException {
		
		t = new ArrayList<Double>(); 
		i = new ArrayList<Double>(); 
		di = new ArrayList<Double>(); 
		Ur = new ArrayList<Double>(); 
		Ul = new ArrayList<Double>(); 
		Uc = new ArrayList<Double>(); 
	}
	    
	public void simulate(double U0, double R, double L, double C, double f)	{
		
		double w = f*2*Math.PI;
		
		t.clear();
		i.clear();
		di.clear();
		Ur.clear();
		Ul.clear();
		Uc.clear();
		
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
	    /*
	    for (int j = 0; j < N; j++) {
	    	System.out.println(t.get(j) + "  " + Ul.get(j));
	    	
	    }
	    */
	}
	
	
	public ChartPanel graphPanel(String parametr) {
		
		XYSeries series = new XYSeries("Nazwa serii");
		

		
		switch(parametr) {
			case "Ur":
				for(int i =0; i<N-1; i++){
					series.add(t.get(i), Ur.get(i));
					}
				break;
			case "Ul":
				for(int i =0; i<N-1; i++){
					series.add(t.get(i), Ul.get(i));
					}
				break;
			case "Uc":
				for(int i =0; i<N-1; i++){
					series.add(t.get(i), Uc.get(i));
					}
				break;
			default:
				
				break;
		}
		
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
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
		return chartPanel;
	}
}


