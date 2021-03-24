import java.util.ArrayList;
import java.util.Random;



public class Demon implements Runnable {

	private Coven coven;
	private int s = 1, w = 0, lvl = 1;
	int i, j;
	private ArrayList<String> IngredientList = new ArrayList<String>(10);
	int id, d;
	boolean flag = true;
	static Random rnd = new Random();

	/**array with numbers
     * The coven that generates a matrix in which demons are found just like in my mind
	 *  @author Raul Prenciu
	 *  @param id
	 *  @param coven
	 *  @param d
	 *  @param i
	 *  @param j
	 *  @param s
	 *  @param w
	 *  @param lvl
	 *  @param flag
	 *  @param IngredientList
	 */

	public Demon(Coven coven, int i, int d) {
		this.coven = coven;
		this.id = i;
		this.d = d;
	}
	void socialSkillUp() {
		/**
		*  When demons meet they raise they social skill and level
		*/
		if(lvl <= 10) {
			s++;
			if(s == 100) {
				lvl++;
				s = 1;
			}
		}
	}
	/**
	* Functions that verifies if the demon is near the sides of the matrix 
	*/
	boolean hit_up() {
		if(i == 0)
			return true;
		return false;
	}
	boolean hit_down() {
		if(i == coven.N)
			return true;
		return false;
	}
	boolean hit_right() {
		if(j == coven.N)
			return true;
		return false;
	}
	boolean hit_left() {
		if(j == 0)
			return true;
		return false;
	}
	boolean hit_wall() {
		/**
		*  Identifies if there is a wall nearby
		*/
		if(hit_up() || hit_down() || hit_left() || hit_right()) {
			w++;
			return true;
		}
		else {
			return false;
		}
	}
	synchronized boolean find_demon() {
		/**
		* Searches for demons nearby whilst trying not to go out of bounds
		*/
		if(!hit_left()) 
			if(coven.CV[i][j - 1] == 2)
			return true;
			else if(!hit_down()) 
				if (coven.CV[i + 1][j] == 2) return true;
				else if(!hit_right())
					if(coven.CV[i][j + 1] == 2) return true;
					else if (!hit_up())
						if(coven.CV[i - 1][j] == 2) return true;
						else return false;
			
		
		else 
			if(!hit_down())
				if (coven.CV[i + 1][j] == 2) return true;
				else if(!hit_right())
					if(coven.CV[i][j + 1] == 2) return true;
					else if (!hit_up())
						if(coven.CV[i - 1][j] == 2) return true;
						else return false;

			else 
				if(!hit_right())
					if(coven.CV[i][j + 1] == 2) return true;
					else if (!hit_up())
						if(coven.CV[i - 1][j] == 2) return true;
						else return false;
		return false;
	}
	private void move() {
		/**
 		*  Movement trough the matrix  searching for the first available exit
 		*/
		if(!hit_left()) {
			coven.removeDemon(i, j);
			j--;
			coven.addDemon(i, j);
		}
		else {
			if(!hit_down()) {
				coven.removeDemon(i, j);
				i++;
				coven.addDemon(i, j);
			}
			else {
				if(!hit_right()) {
					coven.removeDemon(i, j);
					j++;
					coven.addDemon(i, j);
				}
				else {
					if(!hit_up()) {
					coven.removeDemon(i, j);
					i--;
					coven.addDemon(i, j);
					}
					else {
						try {
							wait(rnd.nextInt(41) + 10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	synchronized void walk() {
		/**
 		* 	The walk function that contains everything related movement
 		*/
		if(find_demon()) {
			socialSkillUp();
		}
		if(hit_wall()) {
			move();
			move();
			if (w == 10) {
				if(lvl != 1) {
					lvl--;
				} else s -= 100;
				w = 0;
			}
		}
		move();
		for(int i = 0; i <= lvl; i++) {
			IngredientList.add(Ingredients.Plant());
			//PreIngredientList.addAll(IngredientList);
		}
		try {
			wait(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coven.addIngredients(IngredientList);
	}
	synchronized void scare() {
			/**
			* They get scared periodically and lose everything that they worked for
			*/
		try {
			coven.addIngredients(IngredientList);
			wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IngredientList.clear();
	}
	void spawnDemon(int N) {
		/**
		* Spawns demon in random empty positions
		*/
		i = rnd.nextInt(N);
        j = rnd.nextInt(N);
        while(coven.CV[i][j] != 0) {
            i = rnd.nextInt(N);
            j = rnd.nextInt(N);
        }
        try {
			wait(rnd.nextInt(501) + 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        coven.addDemon(i, j);
	}
	void undeadVisit() {
		/**
		* Sees undead in cove and stops swiftly
		*/
		this.flag = false;
		coven.removeDemon(this.i, this.j);
	}

	@Override
	synchronized public void run() {
		this.spawnDemon(coven.N);
		while (flag) {
			this.walk();
			System.out.println("Demon = " + d + " from coven = " + id + " i = " + i + " and j = " + j);
			try {
				Thread.sleep(rnd.nextInt(1001));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}