package Plugin;

import Tamagotchi.IBuilder;
import Tamagotchi.Person;

public class RandomBuilder implements IBuilder {

	public RandomBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person creation() {
		Person p = new Person();
		Integer num = (int)Math.random()*1000;
		p.setName("nomRandom" + num);
		p.setFirstName("prenomRandom" + num);
		p.setDead(false);
		p.setCalories((int)Math.random()*10000);
		p.setSleep((int)Math.random()*10000);
		p.setWc((int)Math.random()*10000);
		return p;
	}
	
	

}
