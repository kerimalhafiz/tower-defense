package TowerDefence.tower;
import TowerDefence.Balloon.Balloon;
import TowerDefence.board.*;
import java.util.ArrayList;



/**
 * TourRballoon tower
 * this tower does not deal direct damage 
 * instead,it slow down the balloon that is closest to the en of the  
 */
public class TourRballoon extends Tour{
        protected double  effect;

    /**
     * constructor
     * @param effect  effect the slowing effect applied to the target balloon
     */
    public TourRballoon(double  effect){
        super(null, 100, 1500, 400);
        this.effect=effect;
    }


    /**
     * Shoots (applies effect) to the balloon closest to the end of the path
     * within the tower's range.
     * @param b the board 
     */
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
    
   

    /**
    *  getteur of effect
     * @return current slowing effect value
     */
    public double geteffect(){
        return this.effect;
    }

    /**
     * Sets a new slowing effect value.
     * @param temp new effect value
     */
    public void seteffect(int temp){
        this.effect=temp;

    }

}