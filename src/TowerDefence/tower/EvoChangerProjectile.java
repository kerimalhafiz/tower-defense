package TowerDefence.tower;

public class EvoChangerProjectile extends Evolution {

    private Projectile nouveau;
    private Projectile ancien;


    public EvoChangerProjectile(Projectile p, double cout) {
        super("Nouveau projectile", cout);
        this.nouveau = p;
    }
    
}
