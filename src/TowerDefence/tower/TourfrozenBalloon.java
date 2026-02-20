package TowerDefence.tower;
import TowerDefence.board.*;
import TowerDefence.Balloon.*;
import  java.util.*;


public class TourfrozenBalloon extends Tour {
    protected int effect;
    public TourfrozenBalloon(int portee, int cadence, int cout,Position position,int effect){
    super(null, portee, cadence, cout, position);
    this.effect=effect;
   }
 

    public void cibler(Board board){};
    public void tirer(Board b){
        ArrayList<Balloon> candidate=neighborhood(b);
        if (candidate.isEmpty()) {
            return;
        }
        Balloon target=null;
        for(Balloon bl:candidate){
            if (bl==null||bl.isDestroyed()||bl.isOut())continue;
            if (target==null ||bl.getPosition()>target.getPosition()){
                target=bl;
            }
                
            
        }
        if (target!=null) {
            target.freeze(effect);
        }
    };
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
    public void seteffect(int  temp){
        this.effect=temp;

    }

}



