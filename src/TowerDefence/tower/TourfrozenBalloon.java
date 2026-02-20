package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;


public class TourfrozenBalloon extends Tour {
    protected float effect;
    public TourfrozenBalloon(int portee, int cadence, int cout,Position position,float effect){
    super(null, portee, cadence, cout, position);
    this.effect=effect;
   }
 

    public void cibler(Board board){};
    public void tirer(Board b){};
    public void augmenterPortee(){
        this.portee+=100;
    };
    public  void augmenterCadence(){
        this.cadence+=1500;
    };
    public  void augmenterPuissance(){};

    public float geteffect(){
        return this.effect;
    }
    public void seteffect(float temp){
        this.effect=temp;

    }

}



