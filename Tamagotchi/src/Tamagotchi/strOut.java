package Tamagotchi;

public class strOut implements IOut {

	public strOut() {
		// TODO Auto-generated constructor stub
	}
	
	public void affichage(Person perso) {
		System.out.println(perso.getName() + " " + perso.getFirstName() + " : ");
		if (perso.getDead() == false) {
			System.out.println("calories : " + perso.getCalories());
			System.out.println("sommeil : " + perso.getSleep());
			System.out.println("hygiène : " + perso.getWc());
		}else {
			System.out.println("est mort !");
		}
		
	}

}
