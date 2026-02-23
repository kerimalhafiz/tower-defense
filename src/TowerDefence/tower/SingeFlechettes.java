package TowerDefence.tower;

import TowerDefence.board.*;
import java.util.ArrayList;
import TowerDefence.Balloon.*;
/**
 * Dart Monkey tower.
 *
 * This is a basic damage-dealing tower.
 * It throws dart projectiles at balloons within its range.
 *
 * Initial characteristics:
 * - Projectile: "flechettes" (damage = 1)
 * - Range: 100
 * - Cadence: 1000 ms
 * - Cost: 200
 *
 * The tower targets the balloon that is the most advanced
 * along the path (highest position value).
 *
 * Available upgrades:
 * - Cadence upgrade
 * - Range upgrade
 * - Damage upgrade
 */
public class SingeFlechettes extends Tour{

    /**
     * Creates a Dart Monkey tower with predefined characteristics
     * and available evolutions.
     */
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
        evolutions.add(new EvolutionCadence(0.25,150));   // +25% attack speed
        evolutions.add(new EvolutionPortee(0.25,100));    // +25% range
        evolutions.add(new EvolutionPuissance(1,250));    // +1 damage
    }
    
    /**
     * Targeting method (not implemented here).
     *
     * @param board the game board
     */
    public void cibler(Board board){};
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