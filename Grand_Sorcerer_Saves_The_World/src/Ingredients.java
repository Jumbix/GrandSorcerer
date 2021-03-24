import java.util.Random;

public class Ingredients {
	static int id;
	static Random rnd = new Random();
	/**
	* @author Raul Prenciu
	* @param id
	* The class returns a string ingredient whenever it is called by the demons
	*  
	*/
	public static String Plant() {
		id = rnd.nextInt(10);
		if(id == 0) return "Taproot";
		
		else if(id == 1) return "Spider Egg";
		
		else if(id == 2) return "Nirnroot";
		
		else if(id == 3) return "Nightshade";
		
		else if(id == 4) return "Lavender";
		
		else if(id == 5) return "Elves Ear";
		
		else if(id == 6) return "Human Heart";
		
		else if(id == 7) return "Giant's Toe";
		
		else if(id == 8) return "Daedra Heart";
		
		else return "Imp Stool";
	}
}