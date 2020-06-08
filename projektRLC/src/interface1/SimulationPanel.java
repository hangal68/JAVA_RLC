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

	int N = 40000;
	double dt = 0.000000005;
	double t0 = 0;
	double i0 = 0;
	double di0 = 0;
	
	double freq;
    double R;
    double L;
    double C;
    double S;
	
	ArrayList<Double> t;
	ArrayList<Double> i;
	ArrayList<Double> di;
	ArrayList<Double> Ur;
	ArrayList<Double> Ul;
	ArrayList<Double> Uc;
	
	XYSeries series;
	XYSeries Rseries;
	XYSeries Lseries;
	XYSeries Cseries;
	
	JFreeChart chart;
	public SimulationPanel() throws HeadlessException {
		
		t = new ArrayList<Double>(); 
		i = new ArrayList<Double>(); 
		di = new ArrayList<Double>(); 
		Ur = new ArrayList<Double>(); 
		Ul = new ArrayList<Double>(); 
		Uc = new ArrayList<Double>(); 
	
	
	
		
		XYDataset dataset = createDataSet(null);
		
		
		
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
	
	public XYDataset createDataSet(String parametr) {
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
	
	
	public void addingSeries(String parametr) {
		
		
		switch(parametr) {
			case "Ur":
				for(int i =0; i<N-1; i++){
					Rseries.add(t.get(i), Ur.get(i));
					}
				break;
			case "Ul":
				for(int i =0; i<N-1; i++){
					Lseries.add(t.get(i), Ul.get(i));
					}
				break;
			case "Uc":
				for(int i =0; i<N-1; i++){
					Cseries.add(t.get(i), Uc.get(i));
					}
				break;
			default:
				
				break;
		}
		
		
		
	
	}
}