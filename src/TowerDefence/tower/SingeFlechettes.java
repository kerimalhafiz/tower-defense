package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;

public class SingeFlechettes extends Tour{

   private static  final double nb=1.25; 
   private static  final double nv=0.75; 
    
    public SingeFlechettes(Position position){
        super(new Projectile("flechettes",1),100,1000,200,position);
    }
    public void augmenterPortee(){
        this.portee *=nb;
    }

    public void augmenterCadence(){
        this.cadence  *= nv;
    }
    public void augmenterPuissance() {
        this.projectile.setDamage(this.projectile.getDamage()+1);
    }
    public void cibler(Board board){};
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin =neighborhood(b);
        if (ballons_voisin isempty()){
            return;
        }
        Balloon b_proche = null;
        for (Balloon ballon : ballons_voisin){
            if (ballon == null || ballon isDestroyed() || ballon isOut()){
                continue;
            }
            if (cible == null || b.getPosition() > cible.getPosition()){
                b_proche = ballon;
            }
        }
        if (b_proche != null){
            b_proche.takeDamage(this.projectile.getDamage())
        
        }
        
    };
   
    
}