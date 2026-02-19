package tower;

import java.util.List;

public abstract class Tour {

    protected Projectile projectile;
    protected int portee;
    protected int cadence;
    protected double cout;
    protected int position;

    public Tour(Projectile projectile, int portee, int cadence, double cout, int position) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.cout = cout;
        this.position = position;
    }

    public Projectile getProjectile() {
        return projectile;
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