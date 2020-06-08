package interface1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RightPanel extends JPanel {

	JPanel rightpanel;
	 Color buttonColorLight = new Color(204, 240, 204);
	 Color buttonColorDark = new Color(0, 32, 0);
	JButton openButton;
	JButton saveGraphButton;
	JButton saveParametersButton;
	JButton exitButton;
	
	JFrame exitFrame;
	
	
	public RightPanel() {
		 
		 rightpanel = new JPanel();
		
		 rightpanel.setLayout(new FlowLayout());
		
		 openButton = new JButton("Open");
         openButton.setPreferredSize(new Dimension(160, 45));
         openButton.setBackground(buttonColorLight);
         openButton.setForeground(Color.black);
         openButton.setBorder(new LineBorder(Color.black));
         
         openButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         //openButton.setBorder(BorderFactory.createLineBorder(Color.blue));
         openButton.setActionCommand("open");
         //openButton.addActionListener(rightActionListener);
         
         rightpanel.add(openButton);
         
         saveGraphButton = new JButton("Save graphs");
         saveGraphButton.setPreferredSize(new Dimension(160, 45));
         saveGraphButton.setBackground(buttonColorLight);
         saveGraphButton.setForeground(Color.black);
         saveGraphButton.setBorder(new LineBorder(Color.black));
         
         saveGraphButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         saveGraphButton.setActionCommand("saveGraph");
        // saveGraphButton.addActionListener(rightActionListener);
         
         rightpanel.add(saveGraphButton);
         
         saveParametersButton = new JButton("Save parameters");
         saveParametersButton.setPreferredSize(new Dimension(160, 45));
         saveParametersButton.setBackground(buttonColorLight);
         saveParametersButton.setForeground(Color.black);
         saveParametersButton.setBorder(new LineBorder(Color.black));
         saveParametersButton.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
         saveParametersButton.setActionCommand("saveParam");
       //  saveParametersButton.addActionListener(rightActionListener);
         
         rightpanel.add(saveParametersButton);
         
         exitButton = new JButton("Exit");
         exitButton.setPreferredSize(new Dimension(160, 45));
         exitButton.setBackground(buttonColorLight);
         exitButton.setForeground(Color.black);
         exitButton.setBorder(new LineBorder(Color.black));
         exitButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         exitButton.setActionCommand("exit");
         //exitButton.addActionListener(rightActionListener);
         
         
         rightpanel.add(exitButton);
         
         this.add(rightpanel);
         
         exitFrame = new JFrame();
	}
	
}


	
