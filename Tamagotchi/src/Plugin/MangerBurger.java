package Plugin;

import Tamagotchi.IProcess;
import Tamagotchi.Person;

public class MangerBurger implements IProcess{

	public MangerBurger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change(Person p) {
		if(p.getDead() == false) {
			p.setCalories(p.getCalories()+800);
		}
		if(p.getCalories() > 10000) {
			p.setDead(true);
		}	
	}
}
