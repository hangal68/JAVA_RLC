package interface1;

import java.awt.BorderLayout;
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
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
    
    //upper right
    JPanel UpperR, UpperC, UpperL, UpperS;
    JLabel Rlabel, Clabel, Llabel, Slabel;
    JFormattedTextField RTextField, CTextField, LTextField, STextField;
    JButton RParallel, RSeries, CParallel, CSeries, LParallel, LSeries, SParallel, SSeries; //parallel - równoległe; series - szeregowe
    
    JLabel circuit; //upper left
    
    //lower
    JLabel graph1, graph2;
    
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
         
         circuit = new JLabel();
         circuit.setIcon(new ImageIcon(new ImageIcon("obrazki/circuit.jpg").getImage().getScaledInstance(270, 200, Image.SCALE_DEFAULT)));
         upperLeftPanel.add(circuit, BorderLayout.CENTER);
         
         
         
         
         upperRightPanel = new JPanel();
         upperRightPanel.setBackground(upperColorLight);
         upperRightPanel.setBounds(this.getWidth() * 35/100, 0, this.getWidth() * 43/100, this.getHeight() * 4/10);
         upperRightPanel.setLayout(new GridLayout(4, 1));
         
         //panele
         UpperR = new JPanel();
         UpperR.setLayout(new FlowLayout());
         
         UpperC = new JPanel();
         UpperC.setLayout(new FlowLayout());
         
         UpperL = new JPanel();
         UpperL.setLayout(new FlowLayout());
         
         UpperS = new JPanel();
         UpperS.setLayout(new FlowLayout());
         
         
         //obrazki
         
         
         Rlabel = new JLabel();
         Rlabel.setIcon(new ImageIcon(new ImageIcon("obrazki/R.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT)));
         
         Clabel = new JLabel();
         Clabel.setIcon(new ImageIcon(new ImageIcon("obrazki/C.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT)));
         
         Llabel = new JLabel(); 
         Llabel.setIcon(new ImageIcon(new ImageIcon("obrazki/L.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT)));
         
         Slabel = new JLabel();
         Slabel.setIcon(new ImageIcon(new ImageIcon("obrazki/source.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT)));

         
         //pola tekstowe
         RTextField = new JFormattedTextField();
         RTextField.setPreferredSize(new Dimension(50, 35));
         
         CTextField = new JFormattedTextField();
         CTextField.setPreferredSize(new Dimension(50, 35));
         
         LTextField = new JFormattedTextField();
         LTextField.setPreferredSize(new Dimension(50, 35));
         
         STextField = new JFormattedTextField();
         STextField.setPreferredSize(new Dimension(50, 35));
         
         //guziki
         RParallel = new JButton("parallel");
         RParallel.setPreferredSize(new Dimension(100, 35));
         RParallel.setBackground(buttonColorLight);
         RParallel.setForeground(Color.black);
         
         
         RSeries = new JButton("series");
         RSeries.setPreferredSize(new Dimension(100, 35));
         RSeries.setBackground(buttonColorLight);
         RSeries.setForeground(Color.black);
         
         
         CParallel = new JButton("parallel");
         CParallel.setPreferredSize(new Dimension(100, 35));
         CParallel.setBackground(buttonColorLight);
         CParallel.setForeground(Color.black);
         
         
         CSeries = new JButton("series");
         CSeries.setPreferredSize(new Dimension(100, 35));
         CSeries.setBackground(buttonColorLight);
         CSeries.setForeground(Color.black);
         
         
         LParallel = new JButton("parallel");
         LParallel.setPreferredSize(new Dimension(100, 35));
         LParallel.setBackground(buttonColorLight);
         LParallel.setForeground(Color.black);
         
        
         LSeries = new JButton("series");
         LSeries.setPreferredSize(new Dimension(100, 35));
         LSeries.setBackground(buttonColorLight);
         LSeries.setForeground(Color.black);
         
         
         SParallel  = new JButton("parallel");
         SParallel.setPreferredSize(new Dimension(100, 35));
         SParallel.setBackground(buttonColorLight);
         SParallel.setForeground(Color.black);
         
         
         SSeries = new JButton("series");
         SSeries.setPreferredSize(new Dimension(100, 35));
         SSeries.setBackground(buttonColorLight);
         SSeries.setForeground(Color.black);
         
         
         //opcje wierszami
         
         //opornik
         UpperR.add(Rlabel);
         UpperR.add(RTextField);
         UpperR.add(RParallel);
         UpperR.add(RSeries);
         upperRightPanel.add(UpperR);
         
         //kondensator
         UpperC.add(Clabel);
         UpperC.add(CTextField);
         UpperC.add(CParallel);
         UpperC.add(CSeries);
         upperRightPanel.add(UpperC);
         
         //cewka
         UpperL.add(Llabel);
         UpperL.add(LTextField);
         UpperL.add(LParallel);
         UpperL.add(LSeries);
         upperRightPanel.add(UpperL);
         
         //źródło
         UpperS.add(Slabel);
         UpperS.add(STextField);
         UpperS.add(SParallel);
         UpperS.add(SSeries);
         upperRightPanel.add(UpperS);
         
         //lower Panel
         lowerPanel = new JPanel();
         lowerPanel.setBounds(0, this.getHeight() * 4/10, this.getWidth() * 78/100, this.getHeight() * 6/10);
         lowerPanel.setBackground(lowerColorLight);
         lowerPanel.setLayout(new GridLayout(1,2));
         graph1 = new JLabel();
         graph1.setIcon(new ImageIcon(new ImageIcon("obrazki/wykres1.jpg").getImage().getScaledInstance(409, 299, Image.SCALE_DEFAULT)));
         graph2 = new JLabel();
         graph2.setIcon(new ImageIcon(new ImageIcon("obrazki/wykres2.jpg").getImage().getScaledInstance(409, 299, Image.SCALE_DEFAULT)));
         lowerPanel.add(graph1);
         lowerPanel.add(graph2);
         
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
         
         saveGraphButton = new JButton("Save graphs");
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
         
         beginButton = new JButton(new ImageIcon("obrazki/startLight.png"));
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
					UpperR.setBackground(upperColorDark);
					UpperC.setBackground(upperColorDark);
					UpperL.setBackground(upperColorDark);
					UpperS.setBackground(upperColorDark);
					upperRightPanel.setBackground(upperColorDark);
				    lowerPanel.setBackground(lowerColorDark);
				    rightPanel.setBackground(rightColorDark);
				    rightLowerPanel.setBackground(rightColorDark);
				    
				    openButton.setBackground(buttonColorDark);
				    openButton.setForeground(Color.gray);
					
				    saveGraphButton.setBackground(buttonColorDark);
					saveGraphButton.setForeground(Color.gray);
					
					saveParametersButton.setBackground(buttonColorDark);
					saveParametersButton.setForeground(Color.gray);
					
					exitButton.setBackground(buttonColorDark);
					exitButton.setForeground(Color.gray);
					
					RParallel.setBackground(buttonColorDark);
					RParallel.setForeground(Color.gray);
					RSeries.setBackground(buttonColorDark);
					RSeries.setForeground(Color.gray);
					
					CParallel.setBackground(buttonColorDark);
					CParallel.setForeground(Color.gray);
					CSeries.setBackground(buttonColorDark);
					CSeries.setForeground(Color.gray);
					
					LParallel.setBackground(buttonColorDark);
					LParallel.setForeground(Color.gray);
					LSeries.setBackground(buttonColorDark);
					LSeries.setForeground(Color.gray);
					
					SParallel.setBackground(buttonColorDark);
					SParallel.setForeground(Color.gray);
					SSeries.setBackground(buttonColorDark);
					SSeries.setForeground(Color.gray);
					
					
					beginButton.setIcon(new ImageIcon("obrazki/startDark.png"));
				    
				    mode = 1;
				}
				else
				{
					upperLeftPanel.setBackground(upperColorLight);
					upperRightPanel.setBackground(upperColorLight);
					UpperR.setBackground(upperColorLight);
					UpperC.setBackground(upperColorLight);
					UpperL.setBackground(upperColorLight);
					UpperS.setBackground(upperColorLight);
				    lowerPanel.setBackground(lowerColorLight);
				    rightPanel.setBackground(rightColorLight);
				    rightLowerPanel.setBackground(rightColorLight);
				    
				    openButton.setBackground(buttonColorLight);
				    openButton.setForeground(Color.black);
					saveGraphButton.setBackground(buttonColorLight);
					saveGraphButton.setForeground(Color.black);
					
					saveParametersButton.setBackground(buttonColorLight);
					saveParametersButton.setForeground(Color.black);
					
					exitButton.setBackground(buttonColorLight);
					exitButton.setForeground(Color.black);
					
					RParallel.setBackground(buttonColorLight);
					RParallel.setForeground(Color.black);
					RSeries.setBackground(buttonColorLight);
					RSeries.setForeground(Color.black);
					
					CParallel.setBackground(buttonColorLight);
					CParallel.setForeground(Color.black);
					CSeries.setBackground(buttonColorLight);
					CSeries.setForeground(Color.black);
					
					LParallel.setBackground(buttonColorLight);
					LParallel.setForeground(Color.black);
					LSeries.setBackground(buttonColorLight);
					LSeries.setForeground(Color.black);
					
					SParallel.setBackground(buttonColorLight);
					SParallel.setForeground(Color.black);
					SSeries.setBackground(buttonColorLight);
					SSeries.setForeground(Color.black);
					
					beginButton.setIcon(new ImageIcon("obrazki/startLight.png"));
				    
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