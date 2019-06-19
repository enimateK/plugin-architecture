package Plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Tamagotchi.IBuilder;
import Tamagotchi.IDisplay;
import Tamagotchi.IProcess;
import Tamagotchi.Person;
import Tamagotchi.platform.Loader;

public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton buildButton = new JButton("Build");
    private JButton processButton = new JButton("Process");
    private JComboBox<Object> builderList;
	private JComboBox<Object> displayerList;
	private JComboBox<Object> processList;
	private ArrayList<String> builders;
	private ArrayList<String> processes;
	private ArrayList<String> displays;
	private Person person;
	
	public Window(ArrayList<String> builders, ArrayList<String> processes, ArrayList<String> displays) {
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
		    
		 builderList = new JComboBox<Object>(builders.toArray());
		 displayerList = new JComboBox<Object>(displays.toArray());
		 processList = new JComboBox<Object>(processes.toArray());
		    
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
		Loader loader = new Loader();
		if(source == buildButton){
			String selectedBuilder = builderList.getSelectedItem().toString();
			
			try {
				IBuilder builder = (IBuilder) loader.loadPluginDescription(selectedBuilder);
				person = builder.creation();
				String selectedDisplay = displayerList.getSelectedItem().toString();
				
				IDisplay display = (IDisplay) loader.loadPluginDescription(selectedDisplay);
				String displayString = display.affichage(person);
				JOptionPane.showMessageDialog(null,displayString);
			} catch (InstantiationException | IllegalAccessException e2) {
				e2.printStackTrace();
			}
		} else if(source == processButton){
			String selectedProcess = processList.getSelectedItem().toString();
			
			try {
				if (person != null) {
					IProcess process = (IProcess) loader.loadPluginDescription(selectedProcess);
					process.change(person);
					String selectedDisplay = displayerList.getSelectedItem().toString();
					
					IDisplay display = (IDisplay) loader.loadPluginDescription(selectedDisplay);
					String displayString = display.affichage(person);
					JOptionPane.showMessageDialog(null,displayString);
				}
			} catch (InstantiationException | IllegalAccessException e2) {
				e2.printStackTrace();
			}
		}
	}
}
