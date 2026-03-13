package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * Abstract class representing a Tower in the Tower Defense game.
 *
 * A Tour is placed on the board and is responsible for targeting
 * and attacking balloons within its range.
 *
 * Each tower has:
 * - a projectile (may be null for special towers like freeze/slow),
 * - a shooting range (portee),
 * - a shooting cadence (time between shots, in milliseconds),
 * - a cost,
 * - a position on the board.
 *
 * Subclasses must implement the shooting behavior and evolution logic.
 */
public abstract class Tour {
   
        /** The projectile used by the tower (null for special towers). */
    protected Projectile projectile;
    /** Range of the tower (in board cells). */
    protected int portee;
        /** Time between two shots in milliseconds. */
    protected int cadence;
        /** Cost of the tower. */
    protected double cout;
    /** Position of the tower on the board. */
    protected Position position;
    protected int ancienneCadence;
    
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    protected ArrayList<Evolution> evolutions;

      /**
     * Constructs a Tower with its main characteristics. 
     * @param projectile the projectile used by the tower
     * @param portee shooting range
     * @param cadence time between shots (ms)
     * @param cout cost of the tower
     */
    public Tour(Projectile projectile, int portee, int cadence, double cout) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.ancienneCadence=cadence;
        this.cout = cout;
        this.evolutions=new ArrayList<>();
        
        
        
    }

    public ArrayList<Evolution>getEvolutions(){
        return this.evolutions;
    }
 
    /**
     * Sets the position of the tower on the board.
     *
     * @param p position of the tower
     */
    public void setPosition(Position p){
        this.position=p;
    }

    /**
     * Returns the projectile used by the tower.
     *
     * @return the projectile
     */
    public Projectile getprojectile() {
        return this.projectile;
    }

     /**
     * Returns the shooting range of the tower.
     *
     * @return range in cells
     */
    public int getPortee() {
        return portee;
    }

     /**
     * Returns the shooting cadence of the tower.
     *
     * @return cadence in milliseconds
     */
    public int getCadence() {
        return cadence;
    }

    /**
     * Returns the cost of the tower.
     *
     * @return cost value
     */
    public double getCout() {
        return this.cout;
    }

     /**
     * Returns the list of balloons located within the tower's range.
     *
     * The method checks all cells within the square defined by the range
     * around the tower position.
     *
     * @param board the game board
     * @return list of balloons in range
     */
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
/**
 * it's to string to affiche
 */
public String toString(){
    return "T";
}


    /**
     * Defines the shooting behavior of the tower.
     *
     * This method must be implemented by subclasses.
     *
     * @param b the game board
  */
public  void tirer(Board b){
    if(this.ancienneCadence!=this.cadence){
        this.stopTir();
        this.startTir(b);
        this.ancienneCadence=this.cadence;
    }
}




/**
 * Starts the automatic shooting process of the tower.
 *
 * This method schedules the {@code tirer(Board)} method to be executed
 * periodically using a ScheduledExecutorService.
 *
 * The shooting begins immediately (no initial delay) and repeats every
 * {@code cadence} milliseconds.
 *
 * @param b the game board on which the tower operates
 */
    public void startTir(Board b) {
    scheduler.scheduleAtFixedRate(() -> tirer(b),
            0,                 // délai initial
            cadence,           // période
            TimeUnit.MILLISECONDS);
    }

    /**
 * Stops the automatic shooting process of the tower.
 *
 * This method immediately shuts down the scheduler and cancels
 * all future shooting tasks.
 *
 * After calling this method, the tower will no longer fire unless
 * a new scheduler is created.
 */
    public void stopTir() {
    scheduler.shutdownNow();
    }
    
    public Balloon cibler(Board b){
        ArrayList<Balloon> candidate = neighborhood(b);
        Balloon target = null;
        int bestevolu = Integer.MAX_VALUE;
        if (!candidate.isEmpty()) {
        for (Balloon bl : candidate) {
            if (bl == null || bl.isDestroyed() || bl.isOut() || bl.getPath() == null)
                continue;

            // Remaining distance to the end of the path
            int m = (bl.getPath().size() - 1) - bl.getPosition();

            if (m < bestevolu) {
                bestevolu = m;
                target = bl;
            }
            // Tie-break: choose the balloon more advanced in its current cell
            else if (m == bestevolu && target != null) {
                if (bl.getprogress() > target.getprogress()) {
                    target = bl;
                }
            }
        }
       

    }
     return target;
}
public void generate(Board b){
     Balloon b_proche=this.cibler(b);
      if (b_proche != null){
            b_proche.takeDamage(this.projectile.getDamage());
        }
}
public void towersApplication(){
    for(Evolution e:this.evolutions){
        if (!e.isbuy()) {
            e.appliquer(this);
            e.buy();
            System.out.println(this.getClass().getSimpleName() +
            "-> evolutioon apliquée : "+e.getNom() );

            
        }
    }
    System.out.println(this.getClass().getSimpleName()+"-> aucune évolution ");
}
}