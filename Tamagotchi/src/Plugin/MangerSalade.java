package Plugin;

import Tamagotchi.IProcess;
import Tamagotchi.Person;

public class MangerSalade implements IProcess{

	public MangerSalade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change(Person p) {
		if(p.getDead() == false) {
			p.setCalories(p.getCalories()+300);
		}
		if(p.getCalories() > 10000) {
			p.setDead(true);
		}
		
		
	}

}
