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
    public void augmenterPortee() {
        this.portee *= 1.5;
    }

    @Override
    public void augmenterCadence() {
        this.cadence *= 0.75;
    }

    @Override
    public void augmenterPuissance() {
        projectile.setDamage(projectile.getDamage() + 1);
    }

    public void changerProjectile() {
        this.projectile = new Projectile("ExtraBombe",2);
    }
}
    

