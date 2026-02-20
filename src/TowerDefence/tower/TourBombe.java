package TowerDefence.tower;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;

public class TourBombe extends Tour{


    public TourBombe(Position position) {
        super(new Projectile("TourBombe",2), 150, 1800, 600, position);
    }


    public void tirer(Board board) {
        ArrayList<Balloon> cibles = neighborhood(board);

        if (!cibles.isEmpty()) {
            for (Balloon b : cibles) { 
                b.takeDamage(projectile.getDamage());
                board.affiche();
                System.out.println("le ballon :"+b.getId()+"a ete detruit");
                
                
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
    

