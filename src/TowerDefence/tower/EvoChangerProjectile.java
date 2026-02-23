package TowerDefence.tower;

public class EvoChangerProjectile extends Evolution {

    private Projectile nouveau;
    private Projectile ancien;


    public EvoChangerProjectile(Projectile p, double cout) {
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
