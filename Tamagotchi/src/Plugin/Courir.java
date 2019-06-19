package Plugin;

import Tamagotchi.IProcess;
import Tamagotchi.Person;

public class Courir implements IProcess{

	public Courir() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change(Person p) {
		if (p.getDead() == false) {
			 if(p.getCalories()>=1000) {
					p.setCalories(p.getCalories()-1000);
				}else {
					p.setCalories(0);
				}
			 p.setSleep(p.getSleep()+500);
			 if (p.getSleep()>10000)
				 p.setDead(true);
		}
			
		
	}
	
	

}
