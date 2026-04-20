package TowerDefence.tower;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Classe abstraite représentant une tour dans le jeu Tower Defense.
 */
public abstract class Tour {

    /** projectile utilisé par la tour */
    protected Projectile projectile;

    /** portée de la tour */
    protected int portee;

    /** cadence de tir (en millisecondes) */
    protected int cadence;

    /** coût de la tour */
    protected double cout;

    /** position de la tour sur le plateau */
    protected Position position;

    /** ancienne cadence (pour détecter les changements) */
    protected int ancienneCadence;

    /** gestion du tir automatique */
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    /** liste des évolutions possibles */
    protected ArrayList<Evolution> evolutions;

    /**
     * Crée une tour avec ses caractéristiques.
     *
     * @param projectile type de projectile
     * @param portee portée de la tour
     * @param cadence vitesse de tir
     * @param cout prix de la tour
     */
    public Tour(Projectile projectile, int portee, int cadence, double cout) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.ancienneCadence = cadence;
        this.cout = cout;
        this.evolutions = new ArrayList<>();
    }

    /** retourne les évolutions possibles */
    public ArrayList<Evolution> getEvolutions() {
        return this.evolutions;
    }

    /** définit la position de la tour */
    public void setPosition(Position p) {
        this.position = p;
    }

    /** retourne la position de la tour */
    public Position getPosition() {
        return this.position;
    }

    /** retourne le projectile utilisé */
    public Projectile getprojectile() {
        return this.projectile;
    }

    /** retourne la portée */
    public int getPortee() {
        return portee;
    }

    /** retourne la cadence */
    public int getCadence() {
        return cadence;
    }

    /** retourne le coût */
    public double getCout() {
        return this.cout;
    }

    /**
     * cherche les ballons dans la zone de portée
     */
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
                    if (v != null) {
                        voisins.add(v);
                    }
                }
            }
        }
        return voisins;
    }

    /** retourne le nom de la tour */
    public String toString() {
        return this.getClass().getSimpleName();
    }

    /**
     * déclenche le tir si la cadence change
     */
    public void tirer(Board b) {
        if (this.ancienneCadence != this.cadence) {
            this.stopTir();
            this.startTir(b);
            this.ancienneCadence = this.cadence;
        }
    }

    /**
     * démarre le tir automatique
     */
    public void startTir(Board b) {
        if (scheduler == null || scheduler.isShutdown() || scheduler.isTerminated()) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
        }

        scheduler.scheduleAtFixedRate(() -> tirer(b),
                0, cadence, TimeUnit.MILLISECONDS);
    }

    /**
     * arrête le tir automatique
     */
    public void stopTir() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
    }

    /**
     * choisit la meilleure cible à attaquer
     */
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
     * attaque la cible et applique les dégâts
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

    /**
     * applique une évolution à la tour
     */
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

    /**
     * retire une évolution de la tour
     */
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