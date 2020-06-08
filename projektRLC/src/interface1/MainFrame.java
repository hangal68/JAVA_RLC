package interface1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class MainFrame extends JFrame {

	
	LowerRight lowerRightPanel;
	Menu menuBar;
	RightPanel rightPanel;
	UpperRight upperRightPanel;
	UpperLeft upperLeftPanel;
	SimulationPanel simulationPanel;
	JPanel lowerPanel;
	
	Color rightColorLight = new Color(180, 180, 180);
	double freq = 70710;
    double R = 42;
    double L = 0.02;
    double C = 0.00000001;
    double S = 5;
	public MainFrame(){
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1024, 800);
		//this.setResizable(false);
		this.setLayout(null);
		
	//PRAWY DOLNY
		lowerRightPanel = new LowerRight();
		lowerRightPanel.setBounds(this.getWidth() * 78/100, this.getHeight() * 70/100, this.getWidth() * 22/100, this.getHeight() * 30/100);
		this.add(lowerRightPanel);
		
	//LEWY GORNY
		upperLeftPanel = new UpperLeft();
		upperLeftPanel.setBounds(0, 0, this.getWidth() * 35/100, this.getHeight() * 4/10);
		this.add(upperLeftPanel);
		
	//PRAWY GORNY
		upperRightPanel = new UpperRight();
		upperRightPanel.setBounds(this.getWidth() * 35/100, 0, this.getWidth() * 43/100, this.getHeight() * 4/10);
		this.add(upperRightPanel);
		
	//RIGHT PANEL
		RightPanel rightPanel = new RightPanel();
		rightPanel.setBackground(rightColorLight);
		rightPanel.setBounds(this.getWidth() * 78/100, 0, this.getWidth() * 22/100, this.getHeight() * 70/100);
		this.add(rightPanel);
		
		
	//PANEL WYKRESOWY
		simulationPanel = new SimulationPanel();
		simulationPanel.setBounds(0, this.getHeight() * 4/10, this.getWidth() * 78/100, this.getHeight() * 6/10);
		simulationPanel.setBackground(Color.white);
		simulationPanel.setLayout(new GridLayout(1,2));
		
		
		//simulationPanel.simulate(S, R, L, C, freq);
        this.add(simulationPanel);
        //this.add(lowerPanel);
	
	//MENU
		menuBar = new Menu();
		this.setJMenuBar(menuBar);
	
		
		
		
	
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

}
