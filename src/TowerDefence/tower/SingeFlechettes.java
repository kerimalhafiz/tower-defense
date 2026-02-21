package TowerDefence.tower;
import TowerDefence.board.*;

import java.util.ArrayList;

import TowerDefence.Balloon.*;



/**
 * SingeFlechettes (Dart Monkey) tower.
 * 
 * This tower attacks the balloon that has progressed the most
 * along the path (the closest to the exit).
 */
public class SingeFlechettes extends Tour{

<<<<<<< HEAD
   
    
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
        evolutions.add(new EvolutionCadence(0.25,150));
        evolutions.add(new EvolutionPortee(0.25,100));
        evolutions.add(new EvolutionPuissance(1,250));
    }
    
    public void cibler(Board board){};
=======
   private static  final double nb=1.25; 
   private static  final double nv=0.75; 
    /**
     * Constructor.
     * 
     * Creates a dart monkey with:
     * - Projectile "flechettes" dealing 1 damage
     * - Range: 100
     * - Cadence: 1000
     * - Cost: 200
     */
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
    }

    /**
     * Increases the tower range by 25%.
     */
    public void augmenterPortee(){
        this.portee *=nb;
    }
      
    /**
     * Increases firing speed (reduces cooldown).
     */
    public void augmenterCadence(){
        this.cadence  *= nv;
    }

    /**
     * Increases projectile damage by 1.
     */
    public void augmenterPuissance() {
        this.projectile.setDamage(this.projectile.getDamage()+1);
    }

     
    /**
     * Shoots at the balloon that is the most advanced on the path.
     * @param b the board when the balloon move 
     */
>>>>>>> ce755bc (ajout des commentaires)
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin = neighborhood(b);
        if (ballons_voisin.isEmpty()){
            return;
        }
        Balloon b_proche = null;
        for (Balloon ballon : ballons_voisin){
            if (ballon == null || ballon.isDestroyed() || ballon.isOut()){
                continue;
            }
            if (b_proche == null || ballon.getPosition() > b_proche.getPosition()){
                b_proche = ballon;
            }
        }
        if (b_proche != null){
            b_proche.takeDamage(this.projectile.getDamage());
            if (b_proche.isDestroyed()){
                System.out.println("le ballon"  + b_proche.getId() + " a été detruit");
            }

            b_proche.takeDamage(this.projectile.getDamage());
        }
        
    }

   
    
}