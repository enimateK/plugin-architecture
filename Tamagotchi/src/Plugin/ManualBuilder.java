package Plugin;
import Tamagotchi.IBuilder;
import Tamagotchi.Person;

public class ManualBuilder implements IBuilder {

	public ManualBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person creation() {
		Person p = new Person();
		p.setName("Jean");
		p.setFirstName("Paul");
		p.setDead(false);
		p.setCalories(3000);
		p.setSleep(3000);
		p.setWc(3000);
		return p;
	}

}
