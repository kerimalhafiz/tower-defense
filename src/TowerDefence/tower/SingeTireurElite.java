package TowerDefence.tower;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;

import TowerDefence.board.*;
public class SingeTireurElite extends Tour{
    
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