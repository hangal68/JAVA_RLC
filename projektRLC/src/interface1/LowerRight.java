package interface1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LowerRight extends JPanel {

	JPanel LRPanel;
	JButton beginButton;
	Color rightColorLight = new Color(180, 180, 180);
	
	public LowerRight() {
		LRPanel = new JPanel();
        //LRPanel.setBounds(this.getWidth() * 78/100, this.getHeight() * 70/100, this.getWidth() * 22/100, this.getHeight() * 30/100); //DO DODANIA W MAIN FRAME
        LRPanel.setBackground(rightColorLight);
        LRPanel.setLayout(new FlowLayout());
        
        beginButton = new JButton(new ImageIcon("obrazki/startLight.png"));
        //beginButton.setBounds(0, 0, 160, 140);
        beginButton.setPreferredSize(new Dimension(160, 140));
        beginButton.setBorder(new LineBorder(Color.black));
        //beginButton.setActionCommand("begin");
        beginButton.addActionListener(BeginActionListener);
        
        LRPanel.add(beginButton);
        this.add(LRPanel);
	}
	
	ActionListener BeginActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
			
	};
	
}
