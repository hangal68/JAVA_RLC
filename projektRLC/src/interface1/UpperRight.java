package interface1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import interface1.RLCFrame.SliderChangeListener;

public class UpperRight extends JPanel {

	JPanel upperRightPanel;
	
	JPanel UpperR, UpperC, UpperL, UpperS, UpperSlider;
    JSlider slider;
    JLabel sliderLabel;
    JFormattedTextField SliderTextField;
    int min = 0;
    int max = 80000;
    int init = 70710;
    double freq = 70710;
    Color upperColorLight = new Color(229, 204, 255);
    Color buttonColorLight = new Color(204, 240, 204);
    		
    JLabel Rlabel, Clabel, Llabel, Slabel;
    JFormattedTextField RTextField, CTextField, LTextField, STextField;
    JButton RParallel, RSeries, CParallel, CSeries, LParallel, LSeries, SParallel, SSeries; //parallel - rĂłwnolegĹ‚e; series - szeregowe

    public UpperRight() {
    	 //upperRightPanel.setBackground(upperColorLight);
    	 upperRightPanel = new JPanel();
         upperRightPanel.setLayout(new GridLayout(5, 1));
         
       //panele
         UpperR = new JPanel();
         UpperR.setBackground(upperColorLight);
         UpperR.setLayout(new FlowLayout());
         
         UpperC = new JPanel();
         UpperC.setBackground(upperColorLight);
         UpperC.setLayout(new FlowLayout());
         
         UpperL = new JPanel();
         UpperL.setBackground(upperColorLight);
         UpperL.setLayout(new FlowLayout());
         
         UpperS = new JPanel();
         UpperS.setBackground(upperColorLight);
         UpperS.setLayout(new FlowLayout());
         
         UpperSlider = new JPanel();
         UpperSlider.setBackground(upperColorLight);
         UpperSlider.setLayout(new FlowLayout());
         
         //suwak
         sliderLabel = new JLabel("Frequency");
         
         slider = new JSlider(JSlider.HORIZONTAL, min, max, init);
         //slider.addChangeListener(new SliderChangeListener());
         slider.setMajorTickSpacing(20000);
         slider.setMinorTickSpacing(10000);
         slider.setPaintTicks(true);
         slider.setPaintLabels(true);
         slider.setBackground(upperColorLight);
         
         
         SliderTextField = new JFormattedTextField("70710.0 Hz");
         SliderTextField.setPreferredSize(new Dimension(70, 35));
         
         UpperSlider.add(SliderTextField);
         UpperSlider.add(slider);
         UpperSlider.add(sliderLabel);
         
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
         RTextField = new JFormattedTextField("42");
         RTextField.setPreferredSize(new Dimension(50, 35));
         
         CTextField = new JFormattedTextField("0.00000001");
         CTextField.setPreferredSize(new Dimension(50, 35));
         
         LTextField = new JFormattedTextField("0.02");
         LTextField.setPreferredSize(new Dimension(50, 35));
         
         STextField = new JFormattedTextField("5");
         STextField.setPreferredSize(new Dimension(50, 35));
         
         //guziki
         RParallel = new JButton("parallel");
         RParallel.setPreferredSize(new Dimension(115, 35));
         RParallel.setActionCommand("Rpar");
         //RParallel.addActionListener(this);
         RParallel.setBackground(buttonColorLight);
         RParallel.setForeground(Color.black);
         
         
         RSeries = new JButton("series");
         RSeries.setPreferredSize(new Dimension(115, 35));
         RSeries.setActionCommand("Rser");
         //RSeries.addActionListener(this);
         RSeries.setBackground(buttonColorLight);
         RSeries.setForeground(Color.black);
         
         
         CParallel = new JButton("parallel");
         CParallel.setPreferredSize(new Dimension(115, 35));
         CParallel.setActionCommand("Cpar");
        // CParallel.addActionListener(this);
         CParallel.setBackground(buttonColorLight);
         CParallel.setForeground(Color.black);
         
         
         CSeries = new JButton("series");
         CSeries.setPreferredSize(new Dimension(115, 35));
         CSeries.setActionCommand("Cser");
         //CSeries.addActionListener(this);
         CSeries.setBackground(buttonColorLight);
         CSeries.setForeground(Color.black);
         
         
         LParallel = new JButton("parallel");
         LParallel.setPreferredSize(new Dimension(115, 35));
         LParallel.setActionCommand("Lpar");
         //LParallel.addActionListener(this);
         LParallel.setBackground(buttonColorLight);
         LParallel.setForeground(Color.black);
         
        
         LSeries = new JButton("series");
         LSeries.setPreferredSize(new Dimension(115, 35));
         LSeries.setActionCommand("Lser");
        // LSeries.addActionListener(this);
         LSeries.setBackground(buttonColorLight);
         LSeries.setForeground(Color.black);
         
         
         SParallel  = new JButton("parallel");
         SParallel.setPreferredSize(new Dimension(115, 35));
         SParallel.setActionCommand("Spar");
         //SParallel.addActionListener(this);
         SParallel.setBackground(buttonColorLight);
         SParallel.setForeground(Color.black);
         
         
         SSeries = new JButton("series");
         SSeries.setPreferredSize(new Dimension(115, 35));
         SSeries.setActionCommand("Sser");
         //SSeries.addActionListener(this);
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
         
         //zrodlo
         UpperS.add(Slabel);
         UpperS.add(STextField);
         UpperS.add(SParallel);
         UpperS.add(SSeries);
         upperRightPanel.add(UpperS);
         
         //
         upperRightPanel.add(UpperSlider);
         
         this.add(upperRightPanel);
    
    
    
    
    }




}
