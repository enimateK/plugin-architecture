package Plugin;

import Tamagotchi.IDisplay;
import Tamagotchi.Person;

public class StrDisplay implements IDisplay {

	public StrDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	public String affichage(Person perso) {
		String infoPerso = null;
		infoPerso = perso.getName() + " " + perso.getFirstName() + " ";
		if (perso.getDead() == true) {
			infoPerso +=" est mort ! =( ";
		} else {
			infoPerso +=". ";
		}
		infoPerso +="Calories : " + perso.getCalories() + " sommeil : " + perso.getSleep() + " hygiene : " + perso.getWc();
		return infoPerso;	
	}

}
