package TowerDefence.tower;
import TowerDefence.board.*;
public class TourRballoon extends Tour{

    protected float effet;
    public TourRballoon(int portee,int cadence,int cout,Position position,float effect){
        super(null, portee, cadence, cout, position);
        this.effet=effect;
    }


    
    public void cibler(Board board){};
    public void tirer(Board b){};
    public void augmenterPortee(){};
    public  void augmenterCadence(){};
    public  void augmenterPuissance(){};
}
