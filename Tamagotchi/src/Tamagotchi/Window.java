package Tamagotchi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Tamagotchi.platform.Desc;
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
	private Loader loader = new Loader();
	
	public Window(ArrayList<String> builders, ArrayList<String> processes, ArrayList<String> displays) {
		super();
		
		this.builders = builders;
		this.processes = processes;
		this.displays = displays;
		
		build();
	}
	
	private void build() {
		this.setTitle("Super tamagotchi");
		this.setSize(800, 800);
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
		 pan.removeAll();
		 pan.add(buildersLabel);
		 pan.add(builderList);

		 pan.add(displayersLabel);
		 pan.add(displayerList);

		 pan.add(processersLabel);
		 pan.add(processList);

		 for( ActionListener al : buildButton.getActionListeners() ) {
	    	buildButton.removeActionListener( al );
		 }
		 for( ActionListener al : processButton.getActionListeners() ) {
			 processButton.removeActionListener( al );
		 }

		 buildButton.addActionListener(this);
		 processButton.addActionListener(this);
		 
		 pan.add(buildButton);
		 pan.add(processButton);
		
		 ArrayList<Desc> plugins = new ArrayList<Desc>();
		
		 for(Desc d : loader.getListePluginDescription("IProcess")) {
			 plugins.add(d);
		 }
		
		 for(Desc d : loader.getListePluginDescription("IBuilder")) {
			 plugins.add(d);
		 }
		
		 for(Desc d : loader.getListePluginDescription("IDisplay")) {
			 plugins.add(d);
		 }
		 
		 Object[][] pluginsArray = new Object[plugins.size()][2];
		 int i = 0;
		 for (Desc d : plugins) {
			 pluginsArray[i][0] = d.getName();
			 pluginsArray[i][1] = d.getState();
			 i++;
		 }
		 String[] entetes = {"Plugin", "Etat"};
		 
		 JTable tableau = new JTable(pluginsArray, entetes);
		 JScrollPane scroll= new JScrollPane(tableau); 
		 
		 pan.add(scroll);
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
		build();
	}
}
