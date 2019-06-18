package Tamagotchi;

import java.util.HashMap;

public interface IDesc {
	public HashMap<String,String> getPropertyList();
	
	public String getClassName();
	public String getInterfaceName();
	
	public String getName();
	public String getMethodeName();
}
