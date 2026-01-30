package Balloon;
import java.util.List;
import board.*;

/**
 * Abstract class representing a balloon moving on the board.
 */
public abstract class Balloon {

    protected float speed; // ca aussi vous connaissez 
    protected int resistance;// vous connaissez deja ca 
    protected float progress; // position inside the current cell
    protected boolean frozen; // si mon ballon est gele ou pas 
    protected int frozenTicks;// durée restant pour l ecoulement du tic 

    protected static int points = 0; //  quand on creer le ballon il sont tous a 0 point c'est apres avoir detruit on augement
      // les autres sont facile a comprendre debruoiller vous 
    public Balloon(float speed, int resistance) {
        this.speed = speed;
        this.resistance = resistance;
        this.progress = 0;
        this.frozen = false; // au debut aucun ballon n'est gele ou glacer 
        this.frozenTicks = 0;
    }

    /**
     * Moves the balloon along the given path.
     */
    public abstract void move(List<Cell> path); // ici chaque devrav suivre le chemin que nous on donne 

    /**
     * Applies damage to the balloon.
     */
    public void takeDamage(int damage) {
        resistance -= damage;
        if (resistance <0) {
            resistance=0;
        }
        if (resistance == 0) {
            points += 10;
        }
    }

    /**
     * Freezes the balloon for a given number of ticks.
     */
    public void freeze(int ticks) {
        frozen = true;
        frozenTicks = ticks;  // gele le ballon 
    }

    /**
     * Updates the frozen state.
     */
    protected void updateFrozenState() {
        if (frozen) {
            frozenTicks--;
            if (frozenTicks <= 0) {
                frozen = false;
            }
        }
    }

    public boolean isDestroyed() {
        return resistance <= 0;
    }
}
