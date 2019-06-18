package Plugin;

import Tamagotchi.IProcess;
import Tamagotchi.Person;

public class Sieste implements IProcess {

	public Sieste() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change(Person p) {
		if(p.getDead() == false) {
			if(p.getSleep() <= 500) {
				p.setSleep(0);
			}else {
				p.setSleep(p.getSleep() - 500);
			}
		}
	}

}
