package TowerDefence.tower;
import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
public class TourRballoon extends Tour{

    protected double  effect;
    public TourRballoon(double  effect){
        super(null, 100, 1500, 400);
        this.effect=effect;
    }



 public void tirer(Board b){
        ArrayList<Balloon> candidate=neighborhood(b);
        if (candidate.isEmpty()) {
            return;
        }
        Balloon target=null;
        int bestevolu=Integer.MAX_VALUE;
        for(Balloon bl:candidate){
            if (bl==null||bl.isDestroyed()||bl.isOut()||bl.getPath()==null)continue;
           int m=(bl.getPath().size()-1)-bl.getPosition();
           if (m<bestevolu) {
                bestevolu=m;
                target=bl;
           }
           else if (m==bestevolu && target!=null){
                target=bl;
            }
                
            
        }
        if (target!=null) {
            target.Subtractspeed(effect);
        }
    }
    
    public void augmenterPortee(){
        this.portee+=100;
    };
    public  void augmenterCadence(){
        this.cadence+=1500;
    };
    public  void augmenterPuissance(){};

    public double geteffect(){
        return this.effect;
    }
    public void seteffect(int temp){
        this.effect=temp;

    }

}