package interface1;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Listeners implements ActionListener {

	
	Color upperColorLight = new Color(229, 204, 255);
    Color lowerColorLight = Color.white;
    Color rightColorLight = new Color(180, 180, 180);
    Color buttonColorLight = new Color(204, 240, 204);
    Color upperColorDark = new Color(53, 17, 50);
    Color lowerColorDark = new Color(40, 40, 40);
    Color rightColorDark = new Color(30, 30, 30);
    Color buttonColorDark = new Color(0, 32, 0);
	
	
	
	
		LowerRight lowerRight = new LowerRight();
		Menu menu = new Menu();
		RightPanel right = new RightPanel();
		UpperLeft upperLeft = new UpperLeft();
		UpperRight upperRight = new UpperRight();
		SimulationPanel simulationPanel = new SimulationPanel();
		
		
	
		
	
	public void actionPerformed(ActionEvent arg0) {
		
		
		String action = arg0.getActionCommand();

		switch (action) {
			case "begin":
				//test.simulate(S, R, L, C, freq);
		        //lowerPanel.add(test.graphPanel("Ul"));
		        
				break;
			case "open":
				/*
				chooseropen = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt");
	            chooseropen.setFileFilter(filter);
				//int returnV = 
				chooseropen.showDialog(null, "Load");*/
				
				// OTWIERANIE PLIKU:
				//try {
					//if(returnV == JFileChooser.APPROVE_OPTION) {
		               	 //file = chooser.getSelectedFile();
					//}
				
				break;
			case "saveGraph":
				
				/*JFileChooser chooser = new JFileChooser();
				BufferedImage image = new BufferedImage(centralPanel.getWidth(), centralPanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                
                
                
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                int returnV = chooser.showDialog(null, "Save");
                try { 
                    if(returnV == JFileChooser.APPROVE_OPTION) {
                        ImageIO.write(image, "png", chooser.getSelectedFile());
                        
                    }
                } catch (IOException ee) {
                    System.out.println(ee.getMessage());
                }
				/*
				chooserGraph = new JFileChooser();
				//File fileToSave = null;
				FileNameExtensionFilter filterG = new FileNameExtensionFilter("jpg files", "jpg");
	            chooserGraph.setFileFilter(filterG);
	            chooserGraph.showDialog(null, "Save");
	            BufferedImage im = new BufferedImage(lowerPanel.getWidth(), lowerPanel.getHeight(),BufferedImage.TYPE_INT_RGB);
				
				try {
					int userSelection = chooserGraph.showDialog(null, "Save");
					
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    fileToSave = chooser.getSelectedFile();
					}
					
			        
			           
			            Graphics g = lowerPanel.getGraphics();
			            paint(g);
			            ImageIO.write(im, "jpg", fileToSave);
					
				} catch (IOException ee) {
					ee.printStackTrace();
				}*/
            
				/*
				 * BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, type, new File(name+"."+type));
		} catch (Exception e) {
			e.printStackTrace();
		}
				 */
				
				break;
			case "saveParam":
				
				
		
				/*
				File outputFile = null;
				chooserPar = new JFileChooser("Save");
				FileNameExtensionFilter filterP = new FileNameExtensionFilter("txt files", "txt");
	            chooserPar.setFileFilter(filterP);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	outputFile = chooser.getSelectedFile();
			    }
				
				try {
					ImageIO.write(image, "png", outputFile);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				*/
				//chooserPar.showDialog(null, "Save");
				break;
			case "exit":
				right.exitFrame = new JFrame("Exit");
			    if (JOptionPane.showConfirmDialog(right.exitFrame,"Are you sure you want to exit?","RLC simulator", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			    	System.exit(0);
		        break;
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
			case "Rpar":
				
				break;
				
			case "Rser":
				simulationPanel.R = Double.parseDouble(upperRight.RTextField.getText());
				break;
				
			case "Cpar":
				
				break;
				
			case "Cser":
				simulationPanel.C = Double.parseDouble(upperRight.CTextField.getText());
				break;
				
			case "Lpar":
				
				break;
				
			case "Lser":
				simulationPanel.L = Double.parseDouble(upperRight.LTextField.getText());
				break;
				
			case "Spar":
				
				break;
				
			case "Sser":
				simulationPanel.S = Double.parseDouble(upperRight.STextField.getText());
				break;
		}
	
	
	}
}
