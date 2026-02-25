package TowerDefence.tower;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;
/**
 * Sniper Monkey tower.
 *
 * This is a long-range damage-dealing tower.
 * It throws a very sharp dart at balloons anywhere on the map.
 *
 * Initial characteristics:
 * - Projectile: "flechette tres pointue" (damage = 4)
 * - Range: 10000 (can reach almost the entire board)
 * - Cadence: 2000 ms
 * - Cost: 500
 *
 * The tower targets the most advanced balloon on the path
 * (highest position value).
 *
 * Available upgrades:
 * - Cadence upgrade
 * - Damage upgrade
 */
public class SingeTireurElite extends Tour{
    /**
     * Creates a Sniper Monkey tower with predefined characteristics
     * and available evolutions.
     */
    public SingeTireurElite(){
        super(new Projectile("flechette tres pointue",4),10000,2000,500);
        evolutions.add(new EvolutionCadence(0.25,200));
        evolutions.add(new EvolutionPuissance(2,300));
       
    }
    
    /**
     * Makes the tower attack.
     *
     * The method:
     * 1) collects balloons within range,
     * 2) ignores invalid balloons (null, destroyed, or out),
     * 3) selects the most advanced balloon (highest position),
     * 4) applies damage using the projectile,
     * 5) prints a message if the balloon is destroyed.
     *
     * @param b the game board
     */
    public void tirer(Board b){
        super.tirer(b);
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
        }
    }
  
}