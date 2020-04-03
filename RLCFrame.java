package interface1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



public class RLCFrame extends JFrame implements ActionListener{

	JPanel upperLeftPanel;
	JPanel upperRightPanel;
    JPanel lowerPanel;
    JPanel rightPanel;
    JPanel rightLowerPanel;
    Color upperColorLight = new Color(229, 204, 255);
    Color lowerColorLight = Color.white;
    Color rightColorLight = new Color(180, 180, 180);
    Color buttonColorLight = new Color(204, 240, 204);
    Color upperColorDark = new Color(53, 17, 50);
    Color lowerColorDark = new Color(40, 40, 40);
    Color rightColorDark = new Color(30, 30, 30);
    Color buttonColorDark = new Color(0, 32, 0);
    
    
    
    
    JFrame exitFrame;
    
	JButton openButton;
	JButton saveGraphButton;
	JButton saveParametersButton;
	JButton exitButton;
	JButton beginButton;

	JLabel graphLabel;
	
	JMenuBar jmb;
    JMenu options;
    JMenuItem languages;
    JMenuItem shiftMode;
    JMenuItem eng;
    JMenuItem pol;
    JMenuItem chin;
    
	
	BufferedImage image2;
	JFileChooser chooser;
	int returnVal;
	FileNameExtensionFilter filter;
	
	int mode = 0;
	
	public RLCFrame() throws HeadlessException {

		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         this.setSize(1024, 768);
		 this.setResizable(false);
         //top menu options
         jmb = new JMenuBar();
         this.setJMenuBar(jmb);
         
         options = new JMenu("Options");
         jmb.add(options);
         
         languages = new JMenu("Change language");
         
         eng = new JMenuItem("English");
         eng.setActionCommand("eng");
         eng.addActionListener(this);
         languages.add(eng);
         pol = new JMenuItem("Polski");
         pol.setActionCommand("pol");
         pol.addActionListener(this);
         languages.add(pol);
         chin = new JMenuItem("Chinese");
         chin.setActionCommand("chin");
         chin.addActionListener(this);
         languages.add(chin);
         
         options.add(languages);
         
         shiftMode = new JMenuItem("Shift Light/Dark mode");
         shiftMode.setActionCommand("mode");
         shiftMode.addActionListener(this);
         options.add(shiftMode);
         
         //upper Panel
         upperLeftPanel = new JPanel();
         upperLeftPanel.setBackground(upperColorLight);
         upperLeftPanel.setBounds(0, 0, this.getWidth() * 35/100, this.getHeight() * 4/10);
         upperLeftPanel.setLayout(new FlowLayout());
         //tutaj uk³ad
         
         upperRightPanel = new JPanel();
         upperRightPanel.setBackground(upperColorLight);
         upperRightPanel.setBounds(this.getWidth() * 35/100, 0, this.getWidth() * 43/100, this.getHeight() * 4/10);
         upperRightPanel.setLayout(new GridLayout(4, 4));
         
         
         
         //lower Panel
         lowerPanel = new JPanel();
         lowerPanel.setBounds(0, this.getHeight() * 4/10, this.getWidth() * 78/100, this.getHeight() * 6/10);
         lowerPanel.setBackground(lowerColorLight);
         
         
         //right Panel
         rightPanel = new JPanel();
         rightPanel.setBounds(this.getWidth() * 78/100, 0, this.getWidth() * 22/100, this.getHeight() * 70/100);
         rightPanel.setBackground(rightColorLight);
         rightPanel.setLayout(new FlowLayout());

         
         openButton = new JButton("Open");
         openButton.setPreferredSize(new Dimension(160, 45));
         openButton.setBackground(buttonColorLight);
         openButton.setForeground(Color.black);
         openButton.setBorder(new LineBorder(Color.black));
         
         openButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         //openButton.setBorder(BorderFactory.createLineBorder(Color.blue));
         openButton.setActionCommand("open");
         openButton.addActionListener(this);
         
         rightPanel.add(openButton);
         
         saveGraphButton = new JButton("Save grahps");
         saveGraphButton.setPreferredSize(new Dimension(160, 45));
         saveGraphButton.setBackground(buttonColorLight);
         saveGraphButton.setForeground(Color.black);
         saveGraphButton.setBorder(new LineBorder(Color.black));
         
         saveGraphButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         saveGraphButton.setActionCommand("saveGraph");
         saveGraphButton.addActionListener(this);
         
         rightPanel.add(saveGraphButton);
         
         saveParametersButton = new JButton("Save parameters");
         saveParametersButton.setPreferredSize(new Dimension(160, 45));
         saveParametersButton.setBackground(buttonColorLight);
         saveParametersButton.setForeground(Color.black);
         saveParametersButton.setBorder(new LineBorder(Color.black));
         saveParametersButton.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
         saveParametersButton.setActionCommand("saveParam");
         saveParametersButton.addActionListener(this);
         
         rightPanel.add(saveParametersButton);
         
         exitButton = new JButton("Exit");
         exitButton.setPreferredSize(new Dimension(160, 45));
         exitButton.setBackground(buttonColorLight);
         exitButton.setForeground(Color.black);
         exitButton.setBorder(new LineBorder(Color.black));
         exitButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
         exitButton.setActionCommand("exit");
         exitButton.addActionListener(this);
         
         
         rightPanel.add(exitButton);
         
         //right lower Panel
         rightLowerPanel = new JPanel();
         rightLowerPanel.setBounds(this.getWidth() * 78/100, this.getHeight() * 70/100, this.getWidth() * 22/100, this.getHeight() * 30/100);
         rightLowerPanel.setBackground(rightColorLight);
         rightLowerPanel.setLayout(new FlowLayout());
         
         beginButton = new JButton(new ImageIcon("startLight.png"));
         //beginButton.setBounds(0, 0, 160, 140);
         beginButton.setPreferredSize(new Dimension(160, 140));
         beginButton.setBorder(new LineBorder(Color.black));
         beginButton.setActionCommand("begin");
         beginButton.addActionListener(this);
         
         rightLowerPanel.add(beginButton);
         
         
         
         
         
         
         
         
         
         this.setLayout(null);
         this.add(lowerPanel);
         this.add(upperLeftPanel);
         this.add(upperRightPanel);
         this.add(rightPanel);
         this.add(rightLowerPanel);
         
	}
	 
	 
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String action = arg0.getActionCommand();

		switch (action) {
			case "begin":
				
				break;
			case "open":
				
				break;
			case "saveGraph":
				
				break;
			case "saveParam":
				
				break;
			case "exit":
				exitFrame = new JFrame("Exit");
			    if (JOptionPane.showConfirmDialog(exitFrame,"Are you sure you want to exit?","RLC simulator", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			    	System.exit(0);
		        break;
			case "mode":
				if (mode == 0)
				{
					upperLeftPanel.setBackground(upperColorDark);
					upperRightPanel.setBackground(upperColorDark);
				    lowerPanel.setBackground(lowerColorDark);
				    rightPanel.setBackground(rightColorDark);
				    rightLowerPanel.setBackground(rightColorDark);
				    openButton.setBackground(buttonColorDark);
				    
					saveGraphButton.setBackground(buttonColorDark);
					
					saveParametersButton.setBackground(buttonColorDark);
					
					exitButton.setBackground(buttonColorDark);
					
					
					beginButton.setIcon(new ImageIcon("startDark.png"));
				    
				    mode = 1;
				}
				else
				{
					upperLeftPanel.setBackground(upperColorLight);
					upperRightPanel.setBackground(upperColorLight);
				    lowerPanel.setBackground(lowerColorLight);
				    rightPanel.setBackground(rightColorLight);
				    rightLowerPanel.setBackground(rightColorLight);
				    openButton.setBackground(buttonColorLight);
				    
					saveGraphButton.setBackground(buttonColorLight);
					
					saveParametersButton.setBackground(buttonColorLight);
					
					exitButton.setBackground(buttonColorLight);
					
					beginButton.setIcon(new ImageIcon("startLight.png"));
				    
				    mode = 0;
				}
				break;
			case "eng":
				
				break;
			case "pol":
				
				break;
			case "chin":
				
				break;
		}
		
	}

	
	public static void main(String[] args) {
		
		RLCFrame frame = new RLCFrame();
        frame.setVisible(true);
	}


	

}

