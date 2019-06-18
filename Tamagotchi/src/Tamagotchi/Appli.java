package Tamagotchi;

import java.util.ArrayList;

import Tamagotchi.platform.Desc;
import Tamagotchi.platform.IDesc;
import Tamagotchi.platform.Loader;

public class Appli {
	public static void main(String[] args) {
		Loader loader = new Loader();
		
		ArrayList<Class<?>> toto = new ArrayList<Class<?>>();
		
		//Liste les plugins en fonction de l'interface ..
		for(Desc d : loader.getListePluginDescription("IProcess")) {
			//normalement 2 ..
			Class<?> test = loader.loadPluginDescription(d);
			toto.add(test);
		}
		//donc dans toto on a les class qui implement IProcess
		System.out.println(toto.toString());
		
		new Window();
	}
}
