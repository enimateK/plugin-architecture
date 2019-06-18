package Plugin;

import Tamagotchi.IDisplay;
import Tamagotchi.Person;

public class StrDisplay implements IDisplay {

	public StrDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	public String affichage(Person perso) {
		String infoPerso = null;
		infoPerso = perso.getName() + " " + perso.getFirstName() + " : ";
		if (perso.getDead() == false) {
			infoPerso +="calories : " + perso.getCalories() + " sommeil : " + perso.getSleep() + " hygiène : " + perso.getWc();
		}else {
			System.out.println("est mort !");
		}
		return infoPerso;		
	}

}
