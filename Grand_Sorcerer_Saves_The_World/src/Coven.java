import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Coven {
	public int id;
	public int N;
	boolean undead;
	int undeadNr = 0;
	Random rnd = new Random();
	
	ArrayList<Demon> Demons = new ArrayList<Demon>(N/2);
	ArrayList<String> ingredientsList = new ArrayList<String>(10);

	Lock lock = new ReentrantLock();
	private Semaphore sem = new Semaphore(1);

	volatile int[][] CV;
	/**array with numbers
     * The coven that generates a matrix in which demons are found just like in my mind
	 *  @author Raul Prenciu
	 *  @param id
	 *  @param Demons
	 *  @param ingredientList
	 */

	
	public Coven() {
		/**
		* Instantiates the coven
		*/
		Random rnd = new Random();
		N = rnd.nextInt(401) + 100;

		int[][] CV = new int[N +1][N + 1];
		this.CV = CV;
		for(int i = 0; i <= N; i++)
			for(int j = 0; j <= N; j++)
				CV[i][j] = 0;

	}
	

	public void addDemon(int i, int j) {
		/**
		* Adds Demon
		*/
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CV[i][j] = 2;
		
		sem.release();

	}

	public void removeDemon(int i, int j) {
		/**
		* Removes Demon
		*/
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CV[i][j] = 0;
		
		sem.release();
	}

	synchronized ArrayList<String> getIngredients() {
		/**
		* Gives witches ingredients
		*/
		if(!this.undead){
			try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return ingredientsList;
		} finally {
			// TODO: handle finally clause
			sem.release();
		}
		
	}
		ArrayList<String> List = new ArrayList<String>();
		return List;
	}
	synchronized void addIngredients(ArrayList<String> ingredients) {
		/**
		* Demon adds ingredients
		*/
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ingredientsList.addAll(ingredients);
		} finally {
			// TODO: handle finally clause
			sem.release();
		}
	}
	
	public void hasUndead() throws InterruptedException {
		/**
		* Generates undead in coven
		*/
		this.undead = true;
		this.undeadNr++;
		int d = (rnd.nextInt(6) + 5) * undeadNr;
		for(int i = 0; i < d; i++) {
			this.retireDemon();
		}
	}
	public void removesUndead(ArrayList<String>List) {
		/**
		* Removes undead from coven
		*/
		System.out.println("Undead in coven " + this.id + " removed");
		List.clear();
		List.removeAll(Collections.singleton(null));
		this.undead = false;
		this.undeadNr--;
	}
	
	public void retireDemon() {
		/**
		* Retires demon from current coven
		*/
		if(Demons.size() > 1){
				int randomDemon = rnd.nextInt(Demons.size());
				Demon imp = Demons.get(randomDemon);
				imp.undeadVisit();
				}
	}
}
