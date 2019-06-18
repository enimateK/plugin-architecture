package Tamagotchi;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton buildButton = new JButton("Build");
    private JButton processButton = new JButton("Process");
    private JButton displayButton = new JButton("Display");
    private JComboBox<Object> builderList;
	private JComboBox<Object> displayerList;
	private JComboBox<Object> processList;
	
	public Window() {
		this.setTitle("Super tamagotchi");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(pan); 
	    
	    //aller chercher les elements
	    Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};
	    
	    JLabel buildersLabel = new JLabel("Builders :");
	    JLabel displayersLabel = new JLabel("Displayers :");
	    JLabel processersLabel = new JLabel("Processers :");

	    
	    builderList = new JComboBox<Object>(elements);
	    displayerList = new JComboBox<Object>(elements);
	    processList = new JComboBox<Object>(elements);
	    
	    pan.add(buildersLabel);
	    pan.add(builderList);
	    
	    pan.add(displayersLabel);
	    pan.add(displayerList);
	    
	    pan.add(processersLabel);
	    pan.add(processList);
	    
	    pan.add(buildButton);
	    pan.add(processButton);
	    pan.add(displayButton);
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
}
