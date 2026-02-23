package TowerDefence.tower;
import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import  java.util.*;


public class TourfrozenBalloon extends Tour {
    protected int effect;
    public TourfrozenBalloon( int effect){
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
                   if (bl.getprogress() > target.getprogress()) {
                target=bl;
                   }
            }
                
            
        }
        if (target!=null) {
            
            target.freeze(effect);
        }
    }
   

    public float geteffect(){
        return this.effect;
    }
    public void seteffect(int  temp){
        this.effect=temp;

    }

}



