package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;

public class SingeFlechettes extends Tour{

 static  final double nb=1.25; 
static  final double nv=0.75; 
    protected 
    public SingeFlechettes(Position position){
        super(new Projectile(1,"flechettes"),100,1000,200,position);
    }
    public void augmenterPortee(){
        this.portee *=1.25;
    }

    public void augmenterCadence(){
        this.cadence  *= 0.75;
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
        for (Balloon b : ballons_voisin){
            if (!b.isDestroyed() && !b.isOut()){
                b.takeDamage(this.projectile.getDamage());
            }
        }
    };
   
    
}