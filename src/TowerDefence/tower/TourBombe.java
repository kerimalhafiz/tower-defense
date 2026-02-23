package TowerDefence.tower;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;

/**
 * Bomb tower.
 *
 * This tower shoots bombs that deal damage to balloons within its range.
 * The bomb projectile is intended to have an area effect (affecting multiple balloons).
 *
 * Initial characteristics (from the project specification):
 * - Cost: 600
 * - Range: 150
 * - Cadence: 1800 ms
 * - Projectile: Bombe (damage level 2)
 * Evolutions (from the project specification):
 * - Increase power (+1 damage)
 * - Increase range (+50%)
 * - Increase cadence (+25% faster shooting)
 * - Change projectile to "Extra bombe"
 */
public class TourBombe extends Tour{



    /**
     * Creates a new bomb tower with its default projectile and parameters.
     */
    public TourBombe() {
        super(new Projectile("TourBombe",2), 150, 1800, 600);
    }


     /**
     * Shoots using the current projectile.
     *
     * The tower looks for balloons in its neighborhood (within range) and
     * applies the projectile damage to each target.
     *
     * @param board the game board
     */
    public void tirer(Board board) {
        ArrayList<Balloon> cibles = neighborhood(board);

        if (!cibles.isEmpty()) {
            for (Balloon b : cibles) { 
                b.takeDamage(projectile.getDamage());  

            }
        }
    }

    /**
     * Increases the tower range.
     * According to the specification, the bomb tower range can be increased by 50%.
     */
    public void augmenterPortee() {
        this.portee *= 1.5;
    }

      /**
     * Increases the shooting cadence (shoots more often).
     * In this project, cadence represents the time between two shots (in milliseconds),
     * so increasing the cadence means decreasing this value.
     * According to the specification, the cadence improvement corresponds to 25% faster shooting.
     */
    @Override
    public void augmenterCadence() {
        this.cadence *= 0.75;
    }
   
    /**
     * Increases the power of the tower by increasing the projectile damage level.
     * According to the specification, this evolution increases damage by +1.
     */
    @Override
    public void augmenterPuissance() {
        projectile.setDamage(projectile.getDamage() + 1);
    }

      /**
     * Changes the projectile used by this tower.
     *
     * According to the specification, the bomb tower can switch from "Bombe"
     * to "Extra bombe".
     */
    public void changerProjectile() {
        this.projectile = new Projectile("ExtraBombe",2);
    }
}
    

