package TowerDefence.tower;
import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
public class TourRballoon extends Tour{

    protected int  effect;
    public TourRballoon(Position position,int effect){
        super(null, 100, 1500, 400, position);
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
    public void seteffect(int temp){
        this.effect=temp;

    }

}