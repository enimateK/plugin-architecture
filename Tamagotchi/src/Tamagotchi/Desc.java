package Tamagotchi;

import java.util.HashMap;

public class Desc implements IDesc {

	private HashMap<String, String> propertyList;
	
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
}
