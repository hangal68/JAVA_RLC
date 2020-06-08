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
         //chin.addActionListener(new Listeners());
         languages.add(chin);
         
         options.add(languages);
         
         shiftMode = new JMenuItem("Shift Light/Dark mode");
         shiftMode.setActionCommand("mode");
         //shiftMode.addActionListener(new Listeners());
         options.add(shiftMode);
         this.add(jmb);
    }
    
   
}
