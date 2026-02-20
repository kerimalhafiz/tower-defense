package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;

public class SingeFlechettes extends Tour{

   private static  final double nb=1.25; 
   private static  final double nv=0.75; 
    
    public SingeFlechettes(Position position){
        super(new Projectile(1,"flechettes"),100,1000,200,position);
    }
    public void augmenterPortee(){
        this.portee *=nb;
    }

    public void augmenterCadence(){
        this.cadence  *= nv;
    }
    public void augmenterPuissance() {
        this.projectile = new Projectile(this.projectile.getDamage()+1,"flechette");
    }
    public void cibler(Board board){};
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
    };
   
    
}