package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Abstract class representing a Tower in the Tower Defense game.
 */
public abstract class Tour {

    protected Projectile projectile;
    protected int portee;
    protected int cadence;
    protected double cout;
    protected Position position;
    protected int ancienneCadence;

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    protected ArrayList<Evolution> evolutions;

    public Tour(Projectile projectile, int portee, int cadence, double cout) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.ancienneCadence = cadence;
        this.cout = cout;
        this.evolutions = new ArrayList<>();
    }

    public ArrayList<Evolution> getEvolutions() { return this.evolutions; }

    public void setPosition(Position p) { this.position = p; }
    public Position getPosition() { return this.position; }

    public Projectile getprojectile() { return this.projectile; }
    public int getPortee() { return portee; }
    public int getCadence() { return cadence; }
    public double getCout() { return this.cout; }

    protected ArrayList<Balloon> neighborhood(Board board) {
        ArrayList<Balloon> voisins = new ArrayList<>();
        int distanceUtilise = (int)(this.portee * 0.002 + 1);
        for (int dx = -distanceUtilise; dx <= distanceUtilise; dx++) {
            for (int dy = -distanceUtilise; dy <= distanceUtilise; dy++) {
                int newX = this.position.getNbLigne() + dx;
                int newY = this.position.getNbColonne() + dy;
                if (newX >= 0 && newX < board.getNbLigne()
                        && newY >= 0 && newY < board.getNbColonne()) {
                    Balloon v = board.getCell(newX, newY).getValue();
                    if (v != null) voisins.add(v);
                }
            }
        }
        return voisins;
    }

    public String toString() { return this.getClass().getSimpleName(); }

    public void tirer(Board b) {
        if (this.ancienneCadence != this.cadence) {
            this.stopTir();
            this.startTir(b);
            this.ancienneCadence = this.cadence;
        }
    }

    public void startTir(Board b) {
        if (scheduler == null || scheduler.isShutdown() || scheduler.isTerminated()) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
        }
        scheduler.scheduleAtFixedRate(() -> tirer(b),
                0, cadence, TimeUnit.MILLISECONDS);
    }

    public void stopTir() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
    }

    public Balloon cibler(Board b) {
        ArrayList<Balloon> candidate = neighborhood(b);
        Balloon target = null;
        int bestevolu = Integer.MAX_VALUE;
        for (Balloon bl : candidate) {
            if (bl == null || bl.isDestroyed() || bl.isOut() || bl.getPath() == null)
                continue;
            int m = (bl.getPath().size() - 1) - bl.getPosition();
            if (m < bestevolu) {
                bestevolu = m;
                target = bl;
            } else if (m == bestevolu && target != null) {
                if (bl.getprogress() > target.getprogress()) {
                    target = bl;
                }
            }
        }
        return target;
    }

    /**
     * FIX Bug 3 : après takeDamage, si le ballon est détruit on le retire
     * immédiatement du board. Cela évite qu'il soit touché plusieurs fois
     * par d'autres tours dans le même tick.
     */
    public void generate(Board b) {
        Balloon cible = this.cibler(b);
        if (cible != null) {
            cible.takeDamage(this.projectile.getDamage());
            if (cible.isDestroyed()) {
                b.removeBalloon(cible);
            }
        }
    }

    public void towersApplication() {
        for (Evolution e : this.evolutions) {
            if (!e.isbuy()) {
                e.appliquer(this);
                e.buy();
                System.out.println(this.getClass().getSimpleName()
                        + " -> évolution appliquée : " + e.getNom());
                return;
            }
        }
        System.out.println(this.getClass().getSimpleName() + " -> aucune évolution");
    }

    public void towers_revome() {
        for (int i = this.evolutions.size() - 1; i >= 0; i--) {
            Evolution e = this.evolutions.get(i);
            if (e.isbuy()) {
                e.retirer(this);
                e.unbuy();
                System.out.println(this.getClass().getSimpleName()
                        + " -> évolution retirée : " + e.getNom());
                return;
            }
        }
        System.out.println(this.getClass().getSimpleName() + " -> aucune évolution");
    }
}