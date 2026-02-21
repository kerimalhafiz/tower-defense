package TowerDefence.tower;
import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.Board;


public class SingeTireurElite extends Tour{
    
    
   
    public SingeTireurElite(){
        super(new Projectile("singe tireur elite",4),10000,2000,500);
    }
    public void augmenterCadence(){
        this.cadence *= 0.75;
    }
    public void augmenterPuissance() {
        projectile.setDamage(projectile.getDamage() + 2);
        
    }
    
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin =neighborhood(b);
        if (ballons_voisin == null){
            return;
        }
        for (Balloon ballon : ballons_voisin){
            if (!ballon.isDestroyed() && !ballon.isOut()){
                ballon.takeDamage(this.projectile.getDamage());
            }
        }
    }
    
  
}