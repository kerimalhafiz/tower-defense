package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;
import java.util.ArrayList;
public class TourelleAiguille extends Tour{ 
    private static  final double nv=0.75; 
    private static  final double nc=1.2; 
    public TourelleAiguille(){
        super(new Projectile("aiguille",1),80,1200,350);
    }

    public void augmenterPortee(){
        this.portee *= nc;
    }

    public void augmenterCadence(){
        this.cadence  *= nv;
    }
    //public void cibler(Board board){};
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
        }
        
    };
   
    public  void augmenterPuissance(){};
}