package TowerDefence.Balloon;
import TowerDefence.board.*;

import java.util.*;

public class BalloonRfor extends Balloon {

     /**
      * the crete  the Ballon witch speed specifique if i need and also 
      * the resistence specifique
      * @param speed  the vitesse of the balloon
      * @param resistance the resistence 
      * @param id the identifiant of balloon
      */
    public BalloonRfor(float speed, int resistance,String id){
        super(speed, resistance,id);
    }
    
    /**
     * this methode he progresse the or the move the balloon
     * 
     * @param path list of the position
     */
    public void move(List<Position> path) {
    updateFrozenState();

    if (frozen || currentPathIndex >= path.size()) return;
    // the ballon progesse the into number of speed 
    progress += speed;

    while (progress >= PROGRESS_MAX && currentPathIndex < path.size()) {
        progress -= PROGRESS_MAX;
        currentPathIndex++;
    }

    if (currentPathIndex >= path.size()) {
        currentPathIndex = path.size();
        progress = PROGRESS_MAX;
    }
}




    }
    
