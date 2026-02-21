package TowerDefence.tower;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
public class SingeTireurElite extends Tour{
    private static  final double nb=1.25; 
    private static  final double nv=0.75;
    private static final double val_infinie = 10000;
    public SingeTireurElite(Position position){
        super(new Projectile("singe tireur elite",4),val_infinie,2000,500);
    }
    public void augmenterCadence(){
        this.cadence *= nv;
    }
    public void augmenterPuissance() {
        this.projectile.setDamage(this.projectile.getDamage()+2);
        
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
<<<<<<< HEAD
            b_proche.takeDamage(this.projectile.getDamage());
            if (b_proche.isDestroyed()){
                System.out.println("le ballon"  + b_proche.getId() + " a été detruit");
            }
=======
            b_proche.takeDamage(this.projectile.getDamage())
            
>>>>>>> d80538dd7893bb5a05c0e8b900c07f71e6c970ac
        }
        
    };
    public void augmenterPortee(){};
  
}