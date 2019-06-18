package Tamagotchi;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	private JPanel pan = new JPanel();
	private JButton eatButton = new JButton("Manger");
    private JButton sportButton = new JButton("Faire du sport");
    private JButton sleepButton = new JButton("Dormir");
	
	public Window() {
		this.setTitle("Super tamagotchi");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    pan.setBackground(Color.ORANGE);        
	    this.setContentPane(pan);     
	    
	    pan.add(eatButton);
	    pan.add(sportButton);
	    pan.add(sleepButton);
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
}
