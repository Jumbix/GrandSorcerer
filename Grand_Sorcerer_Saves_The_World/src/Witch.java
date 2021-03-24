import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Witch implements Runnable {

    private ArrayList<String> WitchIngredientsList = new ArrayList<String>();
    private ArrayList<String> potionsList = new ArrayList<String>();
    private ArrayList<String> undeadPotion = new ArrayList<String>();
    static Random rnd = new Random();
	private int w;
    private List<Coven> covenList;
    /**Witch thread constructor, it's run application
     * and a function that creates potions
	 *  @author Raul Prenciu
	 *  @param WitchIngredientList
	 *  @param potionsList
	 *  @param undeadPotion
	 *  @param w
	 */
    public Witch(List<Coven> covenList, int w) {
        this.covenList = covenList;
        this.w = w;
    }

    public void run() {
        while (true) {
            int randomCoven = rnd.nextInt(Grand_Sorcerer_Circle.N - 1);
            try {
				Thread.sleep(rnd.nextInt(1001));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            Coven cvn = covenList.get(randomCoven);			/**
             												* Gets random coven
             												*/
            if(cvn.undead) {
            	/**
    			* Finds undead in a coven and requests potions
    			*/
            	Grand_Sorcerer.givePotions(undeadPotion);
            	
            	if(!undeadPotion.isEmpty()) {
            		//System.out.println("Undead potions " + undeadPotion);
            		cvn.removesUndead(undeadPotion);
            	}
            }
            WitchIngredientsList.addAll(cvn.getIngredients());
            cvn.ingredientsList.clear();
            
            createPotion();		/**
            					* Creates a potion after she gets the coven items
            					*/
            System.out.println("Witch " + w + " is in coven " + randomCoven + " ingredients are : " + WitchIngredientsList); 
        }
    }

    private void createPotion() {
        Potion pot = new Potion();
        String auxPotion;
        auxPotion = pot.recipe(WitchIngredientsList);
        if(auxPotion != null)
            potionsList.add(auxPotion);
        Grand_Sorcerer.getPotions(potionsList);
        potionsList.clear();
    }
}