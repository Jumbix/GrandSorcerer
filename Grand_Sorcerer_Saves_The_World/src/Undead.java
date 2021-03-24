import java.util.ArrayList;
import java.util.Random;

public class Undead implements Runnable{

    private ArrayList<Coven> covenList;
    private int id;
    static Random rnd = new Random();
    /**array with numbers
     * The constructor with the borrowed coven list and an id for each undead
	 *  @author Raul Prenciu
	 *  @param id
	 *  @param covenList
	 */

    public Undead(ArrayList<Coven> covenList, int id) {
        this.covenList = covenList;
        this.id = id;
    }

    public void run() {
    	try {
    		int x = rnd.nextInt(501) + 500;
            Thread.sleep(x);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	int randomCoven = rnd.nextInt(Grand_Sorcerer_Circle.N - 1);
    		/**
			* Gets random coven
			*/

        Coven cvn = covenList.get(randomCoven);
        System.out.println("Undead " + this.id + " in coven " + this.id + " appeared");
        try {
			cvn.hasUndead();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while (true) {
        	
            

            //System.out.println("Undead " + undeadID + " is in coven " + randomCoven);
        }
    }
}