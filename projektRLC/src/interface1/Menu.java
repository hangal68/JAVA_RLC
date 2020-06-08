package interface1;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

	LowerRight lowerRight = new LowerRight();
	RightPanel right = new RightPanel();
	UpperLeft upperLeft = new UpperLeft();
	UpperRight upperRight = new UpperRight();
	SimulationPanel simulationPanel = new SimulationPanel();
	
	
	JMenuBar jmb;
    JMenu options;
    JMenuItem languages;
    JMenuItem shiftMode;
    JMenuItem eng;
    JMenuItem pol;
    JMenuItem chin;
    
    LowerRight LR = new LowerRight();
    
    
    Color upperColorLight = new Color(229, 204, 255);
    Color lowerColorLight = Color.white;
    Color rightColorLight = new Color(180, 180, 180);
    Color buttonColorLight = new Color(204, 240, 204);
    Color upperColorDark = new Color(53, 17, 50);
    Color lowerColorDark = new Color(40, 40, 40);
    Color rightColorDark = new Color(30, 30, 30);
    Color buttonColorDark = new Color(0, 32, 0);
    
    int mode = 0;
    public Menu() {
    	
    	jmb = new JMenuBar();
    	
    	 options = new JMenu("Options");
         jmb.add(options);
         
         languages = new JMenu("Change language");
         
         eng = new JMenuItem("English");
         eng.setActionCommand("eng");
         //eng.addActionListener(new Listeners());
         languages.add(eng);
         pol = new JMenuItem("Polski");
         pol.setActionCommand("pol");
         //pol.addActionListener(new Listeners());
         languages.add(pol);
         chin = new JMenuItem("汉语");
         chin.setActionCommand("chin");
         chin.addActionListener(btnActionListener);
         languages.add(chin);
         
         options.add(languages);
         
         shiftMode = new JMenuItem("Shift Light/Dark mode");
         shiftMode.setActionCommand("mode");
         //shiftMode.addActionListener(new Listeners());
         options.add(shiftMode);
         this.add(jmb);
    	
    }
    Listeners btnActionListener = new Listeners() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			String action = arg0.getActionCommand();

			switch (action) {
		case "mode":
			if (menu.mode == 0)
			{
				upperLeft.upperLeftpanel.setBackground(upperColorDark);
				upperRight.UpperR.setBackground(upperColorDark);
				upperRight.UpperC.setBackground(upperColorDark);
				upperRight.UpperL.setBackground(upperColorDark);
				upperRight.UpperS.setBackground(upperColorDark);
				upperRight.upperRightPanel.setBackground(upperColorDark);
				//simulationPanel.setBackground(lowerColorDark);
			    right.rightpanel.setBackground(rightColorDark);
			    lowerRight.LRPanel.setBackground(rightColorDark);
			    
			    right.openButton.setBackground(buttonColorDark);
			    right.openButton.setForeground(Color.gray);
				
			    right.saveGraphButton.setBackground(buttonColorDark);
			    right.saveGraphButton.setForeground(Color.gray);
				
			    right.saveParametersButton.setBackground(buttonColorDark);
			    right.saveParametersButton.setForeground(Color.gray);
				
			    right.exitButton.setBackground(buttonColorDark);
			    right.exitButton.setForeground(Color.gray);
				
			    upperRight.RParallel.setBackground(buttonColorDark);
			    upperRight.RParallel.setForeground(Color.gray);
			    upperRight.RSeries.setBackground(buttonColorDark);
			    upperRight.RSeries.setForeground(Color.gray);
				
			    upperRight.CParallel.setBackground(buttonColorDark);
			    upperRight.CParallel.setForeground(Color.gray);
			    upperRight.CSeries.setBackground(buttonColorDark);
			    upperRight.CSeries.setForeground(Color.gray);
				
			    upperRight.LParallel.setBackground(buttonColorDark);
			    upperRight.LParallel.setForeground(Color.gray);
			    upperRight.LSeries.setBackground(buttonColorDark);
			    upperRight.LSeries.setForeground(Color.gray);
				
			    upperRight.SParallel.setBackground(buttonColorDark);
			    upperRight.SParallel.setForeground(Color.gray);
			    upperRight.SSeries.setBackground(buttonColorDark);
			    upperRight.SSeries.setForeground(Color.gray);
				
				
				lowerRight.beginButton.setIcon(new ImageIcon("obrazki/startDark.png"));
			    
			
				
				upperRight.Rlabel.setIcon(new ImageIcon((new ImageIcon("obrazki/RDark.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Llabel.setIcon(new ImageIcon((new ImageIcon("obrazki/LDark.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Clabel.setIcon(new ImageIcon((new ImageIcon("obrazki/CDark.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Slabel.setIcon(new ImageIcon((new ImageIcon("obrazki/SourceDark.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
			   
				upperRight.UpperSlider.setBackground(upperColorDark);
				upperRight.slider.setBackground(upperColorDark);
				menu.mode = 1;
			}
			else
			{
				upperLeft.upperLeftpanel.setBackground(upperColorLight);
				upperRight.upperRightPanel.setBackground(upperColorLight);
				upperRight.UpperR.setBackground(upperColorLight);
				upperRight.UpperC.setBackground(upperColorLight);
				upperRight.UpperL.setBackground(upperColorLight);
				upperRight.UpperS.setBackground(upperColorLight);
				//simulationPanel.setBackground(lowerColorLight);
			    right.rightpanel.setBackground(rightColorLight);
			    lowerRight.LRPanel.setBackground(rightColorLight);
			    
			    right.openButton.setBackground(buttonColorLight);
			    right.openButton.setForeground(Color.black);
			    right.saveGraphButton.setBackground(buttonColorLight);
			    right.saveGraphButton.setForeground(Color.black);
				
			    right.saveParametersButton.setBackground(buttonColorLight);
			    right.saveParametersButton.setForeground(Color.black);
				
			    right.exitButton.setBackground(buttonColorLight);
			    right.exitButton.setForeground(Color.black);
				
			    upperRight.RParallel.setBackground(buttonColorLight);
			    upperRight.RParallel.setForeground(Color.black);
			    upperRight.RSeries.setBackground(buttonColorLight);
			    upperRight.RSeries.setForeground(Color.black);
				
			    upperRight.CParallel.setBackground(buttonColorLight);
			    upperRight.CParallel.setForeground(Color.black);
			    upperRight.CSeries.setBackground(buttonColorLight);
			    upperRight.CSeries.setForeground(Color.black);
				
			    upperRight.LParallel.setBackground(buttonColorLight);
			    upperRight.LParallel.setForeground(Color.black);
			    upperRight.LSeries.setBackground(buttonColorLight);
			    upperRight.LSeries.setForeground(Color.black);
				
			    upperRight.SParallel.setBackground(buttonColorLight);
			    upperRight.SParallel.setForeground(Color.black);
			    upperRight.SSeries.setBackground(buttonColorLight);
			    upperRight.SSeries.setForeground(Color.black);
				
				lowerRight.beginButton.setIcon(new ImageIcon("obrazki/startLight.png"));
				
				upperRight.Rlabel.setIcon(new ImageIcon((new ImageIcon("obrazki/R.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Llabel.setIcon(new ImageIcon((new ImageIcon("obrazki/L.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Clabel.setIcon(new ImageIcon((new ImageIcon("obrazki/C.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
				upperRight.Slabel.setIcon(new ImageIcon((new ImageIcon("obrazki/source.jpg").getImage().getScaledInstance(60, 35, Image.SCALE_DEFAULT))));
			    
				upperRight.UpperSlider.setBackground(upperColorLight);
				upperRight.slider.setBackground(upperColorLight);
				menu.mode = 0;
			}
			break;
		case "eng":
			upperRight.RParallel.setText("parallel");
			upperRight.RSeries.setText("series");
			upperRight.LParallel.setText("parallel");
			upperRight.LSeries.setText("series");
			upperRight.CParallel.setText("parallel");
			upperRight.CSeries.setText("series");
			upperRight.SParallel.setText("parallel");
			upperRight.SSeries.setText("series");
			
			right.openButton.setText("Open");
			right.saveGraphButton.setText("Save graph");
			right.saveParametersButton.setText("Save parameters");
			right.exitButton.setText("Exit");
			
			menu.options.setText("Options");
			menu.languages.setText("Change language");
			menu.shiftMode.setText("Shift Light/Dark mode");
			break;
		case "pol":
			upperRight.RParallel.setText("rĂłwnolegle");
			upperRight.RSeries.setText("szeregowo");
			upperRight.LParallel.setText("rĂłwnolegle");
			upperRight.LSeries.setText("szeregowo");
			upperRight.CParallel.setText("rĂłwnolegle");
			upperRight.CSeries.setText("szeregowo");
			upperRight.SParallel.setText("rĂłwnolegle");
			upperRight.SSeries.setText("szeregowo");
			
			right.openButton.setText("OtwĂłrz");
			right.saveGraphButton.setText("Zapisz wykres");
			right.saveParametersButton.setText("Zapisz parametry");
			right.exitButton.setText("WyjĹ›cie");
			
			menu.options.setText("Opcje");
			menu.languages.setText("ZmieĹ„ jÄ™zyk");
			menu.shiftMode.setText("Tryb jasny/ciemny");
			
			break;
		case "chin":
			upperRight.RParallel.setText("ĺą¶č�”");
			upperRight.RSeries.setText("ä¸˛č�”");
			upperRight.LParallel.setText("ĺą¶č�”");
			upperRight.LSeries.setText("ä¸˛č�”");
			upperRight.CParallel.setText("ĺą¶č�”");
			upperRight.CSeries.setText("ä¸˛č�”");
			upperRight.SParallel.setText("ĺą¶č�”");
			upperRight.SSeries.setText("ä¸˛č�”");
			
			right.openButton.setText("ĺĽ€");
			right.saveGraphButton.setText("äżťĺ­�ĺ›ľć ‡");
			right.saveParametersButton.setText("äżťĺ­�ĺŹ‚ć•°");
			right.exitButton.setText("é€€ĺ‡ş");
			
			menu.options.setText("ćśźćť�");
			menu.languages.setText("č˝¬ćŤ˘čŻ­č¨€");
			menu.shiftMode.setText("ç™˝/é»‘čż�čˇŚć–ąĺĽŹ");
			
			break;
			}	
		}
	};
    
    }
