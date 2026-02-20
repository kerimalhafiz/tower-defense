package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;

public class SingeFlechettes extends Tour{

 static  final double nb=1.25; 
static  final double nv=0.75; 

    public SingeFlechettes(Position position){
        super(new Projectile(1),100,1000,200,position);
    }
    public void augmenterPortee(){
        this.portee *=1.25;
    }

    public void augmenterCadence(){
        this.cadence  *= 0.75;
    }
    public void augmenterPuissance() {
        this.projectile = new Projectile(this.projectile.getDamage()+1);
    }
    public void cibler(Board board){};
    public void tirer(Board b){};
   
    
}