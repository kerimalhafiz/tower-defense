package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Random;

<<<<<<< HEAD


=======
/**
 * Gorille tower
 * this tower randomly attacks one balloon withings its range
 */
>>>>>>> 890b240 (dajout des commentaires)
public class Gorille extends Tour {

    /**
     * constructor for gorille tower
     * create a tower with:
     * a projectile named gorille dealing 2 damage 
     * a range of 200 
     * a firing rate of 300
     * a cost of 1200
     */

    public Gorille() {
        super(new Projectile("Gorille",2), 200, 300, 1200);
        evolutions.add(new EvolutionCadence(0.2,1000));
        evolutions.add(new EvolutionPortee(0.5,400));
        evolutions.add(new EvolutionPuissance(2,600));
        
    }

    

    /**
     * shoots at a random balloon within the tower's range
     * if the targeted balloon is destroyed after taking damage,
     * it is removed from the board 
     */
    public void tirer(Board board) {
        ArrayList<Balloon> cibles = neighborhood(board);
        
        if (!cibles.isEmpty()) {
            Random rand = new Random();
            Balloon cible = cibles.get(rand.nextInt(cibles.size())); 
            cible.takeDamage(projectile.getDamage());
        
            if(cible.isDestroyed()){
                board.removeBalloon(cible);
            }
            
            
            
        }
    }
<<<<<<< HEAD

    
=======
     /**
      * increases the tower's range 50%
      */
    public void augmenterPortee() {
        this.portee *= 1.5;
    }

    /**
      * increases firing speed (reduce delay between shots)
      * lower cadence value means faster attack
      */
    @Override
    public void augmenterCadence() {
        this.cadence *= 0.33; 
    }
    /**
     * increases projectile damage by 2
     */
    @Override
    public void augmenterPuissance() {
        projectile.setDamage(projectile.getDamage() + 2);
    }

>>>>>>> ce755bc (ajout des commentaires)
    

    
}
