package interface1;
import javax.swing.*;
import java.awt.*;

public class UpperLeft extends JPanel {

	JPanel upperLeftpanel;
	JLabel circuit;
	Color upperColorLight = new Color(229, 204, 255);

	public UpperLeft(){
		upperLeftpanel = new JPanel();
        upperLeftpanel.setBackground(upperColorLight);
        
        upperLeftpanel.setLayout(new FlowLayout());
        
        circuit = new JLabel();
        circuit.setIcon(new ImageIcon(new ImageIcon("obrazki/circuit.jpg").getImage().getScaledInstance(270, 200, Image.SCALE_DEFAULT)));
        upperLeftpanel.add(circuit, BorderLayout.CENTER);
		
		this.add(upperLeftpanel);
	}


















}
