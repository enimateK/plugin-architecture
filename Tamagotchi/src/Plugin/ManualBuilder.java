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
		p.setName("CasDe");
		p.setFirstName("Test");
		p.setDead(false);
		p.setCalories(9800);
		p.setSleep(9800);
		p.setWc(9800);
		return p;
	}

}
