package TowerDefence.tower;
import TowerDefence.board.*;


public class TourelleAiguille extends Tour{

    public TourelleAiguille(Position position){
        super(new Projectile(1,"aiguille"),80,1200,350,position);
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