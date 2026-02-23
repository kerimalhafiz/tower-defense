package TowerDefence.tower;
import TowerDefence.board.*;

import java.util.ArrayList;

import TowerDefence.Balloon.*;




public class SingeFlechettes extends Tour{

   
    
    public SingeFlechettes(){
        super(new Projectile("flechettes",1),100,1000,200);
        evolutions.add(new EvolutionCadence(0.25,150));
        evolutions.add(new EvolutionPortee(0.25,100));
        evolutions.add(new EvolutionPuissance(1,250));
    }
    
    public void cibler(Board board){};
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