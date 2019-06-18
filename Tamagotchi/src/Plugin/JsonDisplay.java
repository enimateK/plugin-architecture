package Plugin;

import Tamagotchi.Person;

public class JsonDisplay {

	public JsonDisplay() {
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
