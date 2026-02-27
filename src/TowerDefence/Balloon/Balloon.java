package TowerDefence.Balloon;

import TowerDefence.board.Cell;
import TowerDefence.board.Position;
import java.util.ArrayList;

/**
 * Abstract class representing a balloon.
 * 
 * A Balloon has:
 * - a speed (movement per tick),
 * - a resistance (number of damages it can take),
 * - a progress value inside the current cell,
 * - a frozen state,
 * 
 * - a path it follows,
 * - and a position index inside that path.
 * 
 * This class provides the base logic for movement, damage handling,
 * freezing behavior, and path tracking.
 */
public abstract class Balloon {

    /** Current cell occupied by the balloon */
    protected Cell cell;

    /** Speed of the balloon (distance progressed per tick) */
    protected float speed;

    /** Resistance of the balloon (health points) */
    protected int resistance;

    /** Progress inside the current cell (between 0 and 1) */
    protected float progress;

    /** Indicates whether the balloon is frozen */
    protected boolean frozen;

    /** Remaining ticks while the balloon is frozen */
    protected int frozenTicks;

    /** Current index of the balloon on the path */
    protected int currentPathIndex = 0;

    /** Unique identifier of the balloon */
    protected String id;

    /** Static points shared by all balloons (global score counter) */
    protected static int points = 0;

    /** Time elapsed since the balloon started moving */
    protected float time;

    /** Position index representing advancement along the path */
    public int position = 0;

    /** The path followed by the balloon */
    protected ArrayList<Position> path;

    /**
     * Constructs a Balloon with the given speed, resistance and identifier.
     *
     * @param speed movement speed per tick
     * @param resistance health value of the balloon
     * @param id unique identifier of the balloon
     */
    public Balloon(float speed, int resistance, String id) {
        this.speed = speed;
        this.resistance = resistance;
        this.progress = 0;
        this.frozen = false;
        this.frozenTicks = 0;
        this.id = id;
        this.time = 0;
        this.cell = null;
        this.path = null;
    }

    /**
     * Assigns a path to the balloon.
     *
     * @param p list of positions representing the path
     */
    public void putPath(ArrayList<Position> p) {
        this.path = p;
    }

    /**
     * Returns the current path of the balloon.
     *
     * @return the path followed by the balloon
     */
    public ArrayList<Position> getPath() {
        return this.path;
    }

    /**
     * Returns the balloon identifier.
     *
     * @return balloon id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the speed of the balloon.
     *
     * @return speed value
     */
    public float getSpeed() {
        return this.speed;
    }


    /**
     * Returns the resistance of the balloon.
     * @return resistance balloon
     */
    public int getResistance(){
        return this.resistance;
    }

    /**
     * Checks if the balloon is currently frozen.
     *
     * @return true if frozen, false otherwise
     */
    public boolean isFrozen() {
        return this.frozen;
    }

    /**
     * Increases the progress of the balloon according to its speed.
     */
    public void AjoutProgress() {
        this.progress += this.speed;
    }

    /**
     * Decreases the progress by one full cell (used when passing to next cell).
     */
    public void enleveProgress() {
        this.progress -= 1;
    }

    /**
     * Increments the internal time counter by one tick.
     */
    public void setTime() {
        this.time++;
    }

    /**
     * Returns the elapsed time of the balloon.
     *
     * @return time value
     */
    public float getTime() {
        return this.time;
    }

    /**
     * Returns the current cell occupied by the balloon.
     *
     * @return current cell
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * Sets the current cell of the balloon.
     *
     * @param c new cell
     */
    public void SetCell(Cell c) {
        this.cell = c;
    }

    /**
     * Applies damage to the balloon.
     * If resistance becomes zero, global points are increased.
     *
     * @param damage amount of damage to apply
     */
    public void takeDamage(int damage) {
    resistance -= damage;
    if (resistance < 0) {
        resistance = 0;
    }

    System.out.println(this.time + " : " + this.id + " touché (" + damage + " dmg)");

    if (resistance == 0) {
        points += 10;
        System.out.println(this.time + " : " + this.id + " détruit");
    }
}


    /**
     * Freezes the balloon for a given number of ticks.
     *
     * @param ticks number of ticks to freeze
     */
   public void freeze(int ticks) {
    frozen = true;
    frozenTicks = ticks;
    System.out.println(this.time + " : " + this.id + " gelé pendant " + ticks + " ticks");
}


    /**
     * Updates the frozen state at each tick.
     * When frozenTicks reaches zero, the balloon becomes active again.
     */
    public void updateFrozenState() {
    if (frozen) {
        frozenTicks--;
        if (frozenTicks <= 0) {
            frozen = false;
            System.out.println(this.time + " : " + this.id + " redémarre");
        }
    }
}


    /**
     * Checks if the balloon has been destroyed.
     *
     * @return true if resistance is zero or below
     */
    public boolean isDestroyed() {
        return resistance <= 0;
    }

    /**
     * Returns the current index of the balloon on the path.
     *
     * @return current path index
     */
    public int getcurrentPathIndex() {
        return this.currentPathIndex;
    }

    /**
     * Returns the current progress value inside the cell.
     *
     * @return progress value
     */
    public float getprogress() {
        return this.progress;
    }

    /**
     * String representation of the balloon (displayed on the board).
     *
     * @return "X" symbol
     */
    public String toString() {
        return "X";
    }

    /**
     * Returns the current position index of the balloon.
     *
     * @return position index
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Increments the position index of the balloon.
     */
    public void setPosition() {
        this.position += 1;
    }

    /**
     * Checks whether the balloon has reached the end of its path.
     *
     * @return true if balloon reached or exceeded last position
     */
    public Boolean isOut() {
        return this.position >= (this.path.size() - 1);
    }
    /***
     * which subtracts the speed
     * @param Speed  soustaire   
     */
    public void Subtractspeed(double Speed){
    this.speed -= Speed;
    System.out.println(this.time + " : " + this.id + " ralenti");
}

}
