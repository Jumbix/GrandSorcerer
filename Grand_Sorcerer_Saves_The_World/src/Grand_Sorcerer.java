import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Grand_Sorcerer {
	
	static Random rnd = new Random();
	static Semaphore sem = new Semaphore(1);
	public static int x;
	private static ArrayList<String> GrandSorcerer_Potions = new ArrayList<String>();
	private static ArrayList<String> Win_Potions = new ArrayList<String>(Arrays.asList("Potion_of_Fire","Potion_of_Water","Potion_of_Wind","Potion_of_Earth", "Potion_of_Light", "Potion_of_Darkness", "Potion_of_Blyat", "Potion_of_Cyka", "Potion_of_Hentai", "Potion_of_Anime", "Potion_of_Arcane", "Potion_of_Nature", "Potion_of_AK47", "Potion_of_Gravity", "Potion_of_Poison", "Potion_of_Thunder", "Potion_of_Ice", "Potion_of_Void", "Potion_of_Life", "Potion_of_Death"));
	/**
	 * @author Prenciu Raul
	 * @param sem
	 * @param GrandSorcerer_Potions
	 * @param WinPotions
	 */
	synchronized public static void getPotions(ArrayList<String> List) {
		// TODO Auto-generated method stub
		/**
		* Gets potions from witches
		*/
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			GrandSorcerer_Potions.addAll(List);
			if(GrandSorcerer_Potions.containsAll(Win_Potions)){			/**
																		*	Win condition
																		*/
				System.out.println("WINNER WINNER CHICKEN DINNER!!!");
				System.exit(0);
			}
		} finally {
			// TODO: handle finally clause
			sem.release();
		}
		System.out.println("Grand Sorcerer potions " + GrandSorcerer_Potions);
		
	}
	synchronized public static ArrayList<String> givePotions(ArrayList<String>List) {
		/**
		* Gives potions to witches when they request it
		*/
		List.clear();
		List.removeAll(Collections.singleton(null));
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				//System.out.println("gives random potions");
				x = rnd.nextInt(4)+2;
				if(GrandSorcerer_Potions.size() > x) {		/**
															*	Verifies if there are enough potions
															*/
				
					for(int i=0; i < x; i++) {				/**
															*	Creates x number of potions
															*/
						int randomPotion = rnd.nextInt(GrandSorcerer_Potions.size());
							List.add(GrandSorcerer_Potions.remove(randomPotion));
					}
				}
				return List;
			} finally {
				// TODO: handle finally clause
				sem.release();
			}
	}
}
