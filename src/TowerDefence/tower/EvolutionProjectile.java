package TowerDefence.tower;

public class EvolutionProjectile extends Evolution {

    private Projectile nouveau;
    private Projectile ancien;


    public EvolutionProjectile(Projectile p, double cout) {
        super("Nouveau projectile", cout);
        this.nouveau = p;
    }

    public void appliquer(Tour t) {
        ancien = t.projectile;
        t.projectile = nouveau;
    }

    public  void retirer(Tour t) {
        t.projectile = ancien;
    }
    
}
