import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Potion {
	/**
	*  @author Raul Prenciu
	*  @param ArrayList's
	*  
	*  Randomly creates a potion and holds all the recipes
	*/
	//static int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0,a7 = 0,a8 = 0,a9 = 0,a10 = 0,a11 = 0,a12 = 0,a13 = 0,a14 = 0,a15 = 0,a16 = 0,a17 = 0,a18 = 0,a19 = 0,a20 = 0;
	
	ArrayList<String> Potion_of_Fire = new ArrayList<String>(Arrays.asList("Taproot","Spider Egg","Nirnroot","Imp Stool"));			//1
	
	ArrayList<String> Potion_of_Water = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Nirnroot","Lavender"));		//2
	
	ArrayList<String> Potion_of_Wind = new ArrayList<String>(Arrays.asList("Taproot","Spider Egg","Lavender","Human Heart"));		//3
	
	ArrayList<String> Potion_of_Earth = new ArrayList<String>(Arrays.asList("Taproot","Spider Egg","Giant's Toe","Human Heart"));	//4
	
	ArrayList<String> Potion_of_Light = new ArrayList<String>(Arrays.asList("Taproot","Spider Egg","Imp Stool","Lavender"));		//5

	ArrayList<String> Potion_of_Darkness = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Taproot","Imp Stool"));	//6

	ArrayList<String> Potion_of_Death = new ArrayList<String>(Arrays.asList("Daedra Heart","Imp Stool","Spider Egg","Giant's Toe"));	//7
	
	ArrayList<String> Potion_of_Life = new ArrayList<String>(Arrays.asList("Imp Stool","Human Heart","Elves Ear","Lavender"));		//8
	
	ArrayList<String> Potion_of_Void = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Nirnroot","Daedra Heart"));	//9
	
	ArrayList<String> Potion_of_Ice = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Elves Ear","Lavender", "Taproot"));		//10
	
	ArrayList<String> Potion_of_Thunder = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Elves Ear","Daedra Heart", "Taproot"));	//11
	
	ArrayList<String> Potion_of_Poison = new ArrayList<String>(Arrays.asList("Nightshade","Taproot","Nirnroot","Lavender", "Spider Egg"));		//12
	
	ArrayList<String> Potion_of_Gravity = new ArrayList<String>(Arrays.asList("Nightshade","Daedra Heart","Nirnroot","Lavender", "Giant's Toe"));	//13
	
	ArrayList<String> Potion_of_AK47 = new ArrayList<String>(Arrays.asList("Daedra Heart","Giant's Toe","Human Heart","Lavender"));	//14
	
	ArrayList<String> Potion_of_Nature = new ArrayList<String>(Arrays.asList("Nightshade","Taproot","Nirnroot","Lavender", "Elves Ear", "Giant's Toe"));	//15
	
	ArrayList<String> Potion_of_Arcane = new ArrayList<String>(Arrays.asList("Daedra Heart","Spider Egg","Giant's Toe","Elves Ear", "Imp Stool"));	//16
	
	ArrayList<String> Potion_of_Anime = new ArrayList<String>(Arrays.asList("Nightshade","Elves Ear","Nirnroot","Lavender", "Taproot"));		//17
	
	ArrayList<String> Potion_of_Hentai = new ArrayList<String>(Arrays.asList("Nightshade","Spider Egg","Imp Stool","Lavender", "Elves Ear", "Taproot"));	//18
	
	ArrayList<String> Potion_of_Cyka = new ArrayList<String>(Arrays.asList("Human Heart","Spider Egg","Nirnroot","Giant's Toe", "Imp Stool", "Nightshade"));		//19
	
	ArrayList<String> Potion_of_Blyat = new ArrayList<String>(Arrays.asList("Daedra Heart","Spider Egg","Giant's Toe","Lavender", "Nirnroot", "Taproot"));		//20

	public String recipe(ArrayList <String> List) {
		
		Random rnd = new Random();
		int id = rnd.nextInt(20);
		if(id == 0 && List.containsAll(Potion_of_Poison)) {
			//a1++;
			List.removeAll(Potion_of_Poison);
			List.removeAll(Collections.singleton(null));
			return "Potion_Of_Poison";
		}
		
		if(id == 1 && List.containsAll(Potion_of_Gravity)) {
			//a2++;
			List.removeAll(Potion_of_Gravity);
			return "Potion_of_Gravity";
		}
		
		if(id == 2 && List.containsAll(Potion_of_Nature)) {
			//a3++;
			List.removeAll(Potion_of_Nature);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Nature";
		}
		
		if(id == 3 && List.containsAll(Potion_of_Arcane)) {
			//a4++;
			List.removeAll(Potion_of_Arcane);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Arcane";
		}
		if(id == 4 && List.containsAll(Potion_of_Anime)) {
			//a5++;
			List.removeAll(Potion_of_Anime);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Anime";
		}
		if(id == 5 && List.containsAll(Potion_of_Hentai)) {
			//a6++;
			List.removeAll(Potion_of_Hentai);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Hentai";
		}
		if(id == 6 && List.containsAll(Potion_of_Cyka)) {
			//a7++;
			List.removeAll(Potion_of_Cyka);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Cyka";
		}
		if(id == 7 && List.containsAll(Potion_of_Blyat)) {
			//a8++;
			List.removeAll(Potion_of_Blyat);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Blyat";
		}
		if(id == 8 && List.containsAll(Potion_of_AK47)) {
			//a9++;
			List.removeAll(Potion_of_AK47);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_AK47";
		}
		if(id == 9 && List.containsAll(Potion_of_Fire)) {
			//a10++;
			List.removeAll(Potion_of_Fire);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Fire";
		}
		if(id == 10 && List.containsAll(Potion_of_Water)) {
			//a11++;
			List.removeAll(Potion_of_Water);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Water";
		}
		if(id == 11 && List.containsAll(Potion_of_Wind)) {
			//a12++;
			List.removeAll(Potion_of_Wind);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Wind";
		}
		if(id == 12 && List.containsAll(Potion_of_Earth)) {
			//a13++;
			List.removeAll(Potion_of_Earth);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Earth";
		}
		if(id == 13 && List.containsAll(Potion_of_Light)) {
			//a14++;
			List.removeAll(Potion_of_Light);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Light";
		}
		if(id == 14 && List.containsAll(Potion_of_Darkness)) {
			//a15++;
			List.removeAll(Potion_of_Darkness);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Darkness";
		}
		if(id == 15 && List.containsAll(Potion_of_Death)) {
			//a16++;
			List.removeAll(Potion_of_Death);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Death";
		}
		if(id == 16 && List.containsAll(Potion_of_Life)) {
			//a17++;
			List.removeAll(Potion_of_Life);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Life";
		}
		if(id == 17 && List.containsAll(Potion_of_Void)) {
			//a18++;
			List.removeAll(Potion_of_Void);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Void";
		}
		if(id == 18 && List.containsAll(Potion_of_Ice)) {
			//a19++;
			List.removeAll(Potion_of_Ice);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Ice";
		}
		if(id == 19 && List.containsAll(Potion_of_Thunder)) {
			//a20++;
			List.removeAll(Potion_of_Thunder);
			List.removeAll(Collections.singleton(null));
			return "Potion_of_Thunder";
		}
		
		else{
			List.removeAll(Collections.singleton(null));
			return null;
			}
	}
}