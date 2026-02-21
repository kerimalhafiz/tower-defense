package TowerDefence.tower;
import TowerDefence.board.*;

import java.util.ArrayList;

import TowerDefence.Balloon.*;


public class SingeFlechettes extends Tour{

   
   
    
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
    }
    public void augmenterPortee(){
        this.portee *=1.25;
    }

    public void augmenterCadence(){
        this.cadence  *= 0.75;
    }
    public void augmenterPuissance() {
        projectile.setDamage(projectile.getDamage() + 1);
    }
   
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin =neighborhood(b);
        if (ballons_voisin == null){
            return;
        }
        for (Balloon ballon : ballons_voisin){
            ballon.takeDamage(this.projectile.getDamage());
            
        }
    }
   
    
}