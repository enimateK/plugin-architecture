package Plugin;

import Tamagotchi.IProcess;
import Tamagotchi.Person;

public class Courir implements IProcess{

	public Courir() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change(Person p) {
		if (p.getDead() == false && p.getCalories()>=1000) {
			p.setCalories(p.getCalories()-1000);
		}else if (p.getCalories()<1000 && p.getDead() == false)
			p.setCalories(0);
			
		
	}
	
	

}
