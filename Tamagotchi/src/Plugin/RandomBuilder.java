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
		double nomrandom = Math.random()*1000;
		double calRandom = Math.random()*10000;
		double sleepRandom = Math.random()*10000;
		double WcRandom = Math.random()*10000;

		Integer num = (int) nomrandom;
		p.setName("nomRandom" + num);
		p.setFirstName("prenomRandom" + num);
		p.setDead(false);
		p.setCalories((int)calRandom);
		p.setSleep((int)sleepRandom);
		p.setWc((int)WcRandom);
		return p;
	}
	
	

}
