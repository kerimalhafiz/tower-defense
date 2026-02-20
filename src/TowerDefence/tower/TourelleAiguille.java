package TowerDefence.tower;
import TowerDefence.board.*;


public class TourelleAiguille extends Tour{

    public TourelleAiguille(Position position){
        super(new Projectile(1),80,1200,350,position);
    }

    public void augmenterPortee(){
        this.portee *= 1.2;
    }

    public void augmenterCadence(){
        this.cadence  *= 0.75;
    }
      public void cibler(Board board){};
    public void tirer(Board b){};
   
    public  void augmenterPuissance(){};
}