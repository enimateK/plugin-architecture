package Plugin;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import Tamagotchi.Person;

public class JsonDisplay {
/*
 * En cours de développement. Plugin non fonctionnel donc absent de ../ressources
 * */
	public JsonDisplay() {
		// TODO Auto-generated constructor stub
	}

	public String affichage(Person perso) throws IOException {
		String infoPerso = null;
		File donneesPerso=new File("../out/"+perso.getName()+perso.getFirstName()+".json");
		donneesPerso.createNewFile();
		FileWriter saveDonnees=new FileWriter(donneesPerso);
		try 
		{	
			saveDonnees.write("{\n" );
			saveDonnees.write(
				"\"name\": " + perso.getName()+"\n"+
				"\"firstName\"" + perso.getFirstName()+"\n"+
				"\"dead\""+perso.getDead()+"\n"+
				"\"calories\""+perso.getCalories()+"\n"+
				"\"sleep\""+perso.getSleep()+"\n"+
				"\"wc\""+perso.getWc()+"\n"+
				"}");
		}catch (Exception e) {
			 System.out.println("Impossible de creer le fichier");
		}
		finally {
			saveDonnees.close();
		}
	return null;
	}
}
