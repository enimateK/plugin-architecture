package Tamagotchi.platform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import Tamagotchi.IDisplay;

public class Loader {

	private static HashSet<IDesc> initialDescriptionList=new HashSet<IDesc>();
	
	public Loader(){
		loadAllPluginDescription(Constantes.FOLDER);
	}
	
	private  void loadAllPluginDescription(final File folder){
		for (final File file : folder.listFiles()) {
			if (file.isDirectory()) {
				loadAllPluginDescription(file);
			} else {
				try {
					Desc description=new Desc();
					BufferedReader br = new BufferedReader(new FileReader(file));
					String s=br.readLine();
					while (s != null){
						int index=s.indexOf('=');
						String param=s.substring(0,index);
						String value=s.substring(index+1,s.length());
						description.getPropertyList().put(param,value);
						s=br.readLine();
					}
					initialDescriptionList.add(description);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public HashSet<Desc> getListePluginDescription(String paramInterface){
		HashSet<Desc> descriptionChoixList=new HashSet<Desc>();
		Iterator<IDesc> it=initialDescriptionList.iterator();
		while (it.hasNext()){
			Desc element=(Desc)it.next();
			String strInitial=element.getInterfaceName();
			int indexInitial=strInitial.lastIndexOf('.') + 1;
			String  interfaceValue=strInitial.substring(indexInitial,strInitial.length());
				if (interfaceValue.equals(paramInterface))
					descriptionChoixList.add(element);
		}
		return descriptionChoixList;
	}
	
	public Class<?> loadPluginDescription(Desc description) {	
		Class<?> obj=null;
		try {
			obj = Class.forName(description.getClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;	
	}
	
	public Object loadPluginDescription(String descriptionName) throws InstantiationException, IllegalAccessException {	
		Class<?> obj=null;
		Object instantiateObj = null;
		try {
			Iterator<IDesc> it=initialDescriptionList.iterator();
			while (it.hasNext()){
				Desc element=(Desc)it.next();
				if(element.getName().equals(descriptionName)) {
					obj = Class.forName(element.getClassName());
					instantiateObj = obj.newInstance();
				}
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return instantiateObj;	
	}
	
	public static HashSet<IDesc> getListeInitialDescription() {
		return initialDescriptionList;
	}
	
}
