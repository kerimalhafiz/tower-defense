package TowerDefence.tower;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;

public class TourBombe extends Tour{


    public TourBombe() {
        super(new Projectile("TourBombe",2), 150, 1800, 600);
        evolutions.add(new EvolutionCadence(0.25,300));
        evolutions.add(new EvolutionPortee(0.5,250));
        evolutions.add(new EvolutionPuissance(1,200));
        evolutions.add(new EvolutionProjectile(new Projectile("ExtraBombe", 2), 400));
    }


    public void tirer(Board board) {
        ArrayList<Balloon> cibles = neighborhood(board);

        if (!cibles.isEmpty()) {
            for (Balloon b : cibles) { 
                b.takeDamage(projectile.getDamage());  

            }
        }
    }
    
    
}
    

