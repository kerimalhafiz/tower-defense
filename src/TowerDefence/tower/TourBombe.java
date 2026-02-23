package TowerDefence.tower;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;

public class TourBombe extends Tour{


    public TourBombe() {
        super(new Projectile("TourBombe",2), 150, 1800, 600);
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
    

