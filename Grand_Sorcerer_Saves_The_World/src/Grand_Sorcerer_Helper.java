import java.util.Random;

public class Grand_Sorcerer_Helper {
	Random rnd = new Random();
	public static Thread demonThreads[] = new Thread[250];
	/**
	* @author Raul Prenciu
	*  @param demonThreads
	*  
	*  The helper creates the demon threads and helps them assign to covens
	*/

	public static void createDemons(Coven coven, int i, int N) {
		/**
		*  This function creates demons and opens threads for them.
		*/
		
		
		for (int d = 0; d < N / 2; d++) {
			Demon demon = new Demon(coven, i, d);
			coven.Demons.add(demon);
			demonThreads[d] = new Thread(demon);
			demonThreads[d].start();

		}

	}
}