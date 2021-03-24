import java.util.ArrayList;
import java.util.Random;


public class Grand_Sorcerer_Circle {
	static Random rnd = new Random();
	static int N = rnd.nextInt(11) + 10;
	static int U = rnd.nextInt(31) + 20;
	static Thread witchThreads[] = new Thread[10];
	static Thread undeadThreads[] = new Thread[U];
	public static long startTime;

	static ArrayList<Coven> covenList = new ArrayList<Coven>(10);
	
	/**array with numbers
	 *  @author Raul Prenciu
	 *  @param covenList
	 *  @param N
	 *  @param U
	 *  @param witchThreads
	 *  @param undeadThreads
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Nr of Covens " + N);
		/**
		* Creates covens then fills them with demons
		*/
		for (int i = 0; i < N; i++) {

			final Coven coven = new Coven();
			covenList.add(coven);
			coven.id = i;

			Grand_Sorcerer_Helper.createDemons(coven, i, coven.N);
		}

			createWitches();
		System.out.println("Nr of Undeads " + U);
			createUndeads();

	}

	private static void createWitches() {

		for (int w = 0; w < 10; w++) {
			/**
			* Creates witch threads
			*/

			witchThreads[w] = new Thread(new Witch(covenList, w));
			witchThreads[w].start();
		}

	}
	private static void createUndeads() {

		for (int u = 0; u < U; u++) {
				/**
				* Creates undead threads
				*/

			undeadThreads[u] = new Thread(new Undead(covenList, u));
			undeadThreads[u].start();
		}
	}
}
