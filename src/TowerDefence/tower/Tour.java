package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public abstract class Tour {

    protected Projectile projectile;
    protected int portee;
    protected int cadence;
    protected double cout;
    protected Position position;
    protected ArrayList<Evolution> evolutions;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
  

    public Tour(Projectile projectile, int portee, int cadence, double cout) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.cout = cout;
        this.evolutions=new ArrayList<>();
        
        
    }

    public void setPosition(Position p){
        this.position=p;
    }

    public Projectile getprojectile() {
        return this.projectile;
    }

    public int getPortee() {
        return portee;
    }

    public int getCadence() {
        return cadence;
    }

    public double getCout() {
        return cout;
    }

    protected ArrayList<Balloon> neighborhood(Board board) {
    ArrayList<Balloon> voisins = new ArrayList<>();

    for (int dx = -portee; dx <= portee; dx++) {
        for (int dy = -portee; dy <= portee; dy++) {
            int newX = this.position.getNbLigne() + dx;
            int newY = this.position.getNbColonne() + dy;

            if (newX >= 0 && newX < board.getNbLigne() &&
                newY >= 0 && newY < board.getNbColonne()) {
                if(board.getCell(newX, newY).getValue()!=null){
                    voisins.add(board.getCell(newX, newY).getValue());
            }
        }
    }
}
    return voisins;
}
public String toString(){
    return "T";
}


public abstract void tirer(Board b);

    
    



    public void startTir(Board b) {
    scheduler.scheduleAtFixedRate(() -> tirer(b),
            0,                 // délai initial
            cadence,           // période
            TimeUnit.MILLISECONDS);
    }

    public void stopTir() {
    scheduler.shutdownNow();
    }

}