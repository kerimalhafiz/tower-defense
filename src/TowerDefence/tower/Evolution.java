package TowerDefence.tower;

/**
 * Abstract class representing a tower evolution (upgrade).
 *
 * An evolution can be applied to or removed from a tower.
 * Each evolution has:
 * - a name,
 * - a cost,
 * - a purchase state (whether it has been bought or not).
 */
public abstract class Evolution {

    /** Name of the evolution. */
    protected String nom;

    /** Cost of the evolution. */
    protected double cout;

    /** Indicates whether the evolution has been purchased. */
    protected boolean acheter;

    /**
     * Creates a new evolution.
     *
     * @param n name of the evolution
     * @param c cost of the evolution
     */
    public Evolution(String n,double c){
        this.nom=n;
        this.acheter=false; // Evolution is not purchased by default
        this.cout=c;
    }
    public double getCout(){
        return this.cout;
    }

    /**
     * Applies the evolution effect to a tower.
     *
     * @param t the tower to upgrade
     */
    public abstract void appliquer(Tour t);

    /**
     * Removes the evolution effect from a tower.
     *
     * @param t the tower to downgrade
     */
    public abstract void retirer(Tour t);

}