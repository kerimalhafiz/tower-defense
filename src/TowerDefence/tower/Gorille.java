package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Random;



public class Gorille extends Tour {



    public Gorille() {
        super(new Projectile("Gorille",2), 200, 300, 1200);
        evolutions.add(new EvolutionCadence(0.2,1000));
        evolutions.add(new EvolutionPortee(0.5,400));
        evolutions.add(new EvolutionPuissance(2,600));
        
    }

    


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

    
    

    
}
