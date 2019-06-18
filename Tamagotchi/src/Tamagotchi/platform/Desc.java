package Tamagotchi.platform;

import java.util.HashMap;

public class Desc implements IDesc {

	private HashMap<String, String> propertyList;
	
	private String state; //Etat : Load / Read / Run / Fail 
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Desc(){
		propertyList=new HashMap<String, String>();
	}
	
	@Override
	public HashMap<String, String> getPropertyList() {
		return propertyList;
	}

	@Override
	public String getClassName() {
		return propertyList.get(Constantes.CLASS);
	}

	@Override
	public String getInterfaceName() {
		return propertyList.get(Constantes.INTERFACE);
	}

	@Override
	public String getName() {
		return propertyList.get(Constantes.NAME);
	}
	
	public void setPropertyList( HashMap<String,String> propertyList) {
		this.propertyList=propertyList;
	}

	@Override
	public String getMethodeName() {
		return propertyList.get(Constantes.METHODE);
	}

	@Override
	public Boolean getAutorun() {
		return Boolean.parseBoolean(propertyList.get(Constantes.AUTORUN));
	}
}
