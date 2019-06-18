package Tamagotchi;

import java.util.ArrayList;

import Tamagotchi.platform.Desc;
import Tamagotchi.platform.IDesc;
import Tamagotchi.platform.Loader;

public class Appli {
	public static void main(String[] args) {
		Loader loader = new Loader();
		
		ArrayList<String> processes = new ArrayList<String>();
		ArrayList<String> builders = new ArrayList<String>();
		ArrayList<String> displays = new ArrayList<String>();

		for(Desc d : loader.getListePluginDescription("IProcess")) {
			processes.add(d.getName());
		}
		
		for(Desc d : loader.getListePluginDescription("IBuilder")) {
			builders.add(d.getName());
		}

		for(Desc d : loader.getListePluginDescription("IDisplay")) {
			displays.add(d.getName());
		}
				
		new Window(builders, processes, displays);
	}
}
