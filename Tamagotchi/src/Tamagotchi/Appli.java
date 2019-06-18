package Tamagotchi;

public class Appli {
	public static void main(String[] args) {
		
		
		String[] builders =  {"RandomIn"};
		String[] processes = {"MangerSalade", "Sieste"};
		String[] displays = {"StrOut"};
		
		new Window(builders, processes, displays);
	}
}
