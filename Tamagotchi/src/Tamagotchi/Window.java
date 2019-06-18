package Tamagotchi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton buildButton = new JButton("Build");
    private JButton processButton = new JButton("Process");
    private JComboBox<Object> builderList;
	private JComboBox<Object> displayerList;
	private JComboBox<Object> processList;
	private String[] builders;
	private String[] processes;
	private String[] displays;
	
	public Window(String[] builders, String[] processes, String[] displays) {
		super();
		
		this.builders = builders;
		this.processes = processes;
		this.displays = displays;
		
		build();
	}
	
	private void build() {
		this.setTitle("Super tamagotchi");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		 JLabel buildersLabel = new JLabel("Builders :");
		 JLabel displayersLabel = new JLabel("Displayers :");
		 JLabel processersLabel = new JLabel("Processers :");
		    
		 builderList = new JComboBox<Object>(builders);
		 displayerList = new JComboBox<Object>(processes);
		 processList = new JComboBox<Object>(displays);
		    
		 pan.add(buildersLabel);
		 pan.add(builderList);

		 pan.add(displayersLabel);
		 pan.add(displayerList);

		 pan.add(processersLabel);
		 pan.add(processList);

		 buildButton.addActionListener(this);
		 processButton.addActionListener(this);
		 
		 pan.add(buildButton);
		 pan.add(processButton);
		 this.setContentPane(pan);
		 this.setVisible(true);

		 return pan;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == buildButton){
			String selected = builderList.getSelectedItem().toString();
			try {
				Class<?> cl = Class.forName("Plugin.RandomIn");
				IBuilder builder = (IBuilder) cl.newInstance();
				Person person = builder.creationAleatoire();
				JOptionPane.showMessageDialog(null, person.toString());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(source == processButton){
			String selected = processList.getSelectedItem().toString();
		}
	}
}
