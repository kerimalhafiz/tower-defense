package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;
import java.util.ArrayList;


public class TourelleAiguille extends Tour{

    public TourelleAiguille(){
        super(new Projectile("aiguille",1),80,1200,350);
    }

    public void augmenterPortee(){
        this.portee *= 1.2;
    }

    public void augmenterCadence(){
        this.cadence  *= 0.75;
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
   
    public  void augmenterPuissance(){};
}