package TowerDefence.tower;

public class EvoAugmenterPuissance extends Evolution {

    private int  ajout;

    public EvoAugmenterPuissance(int  ajout,double cout ){
        super("Puissance", cout);
        this.ajout= ajout ;

    }

    public void appliquer( Tour t ){
        t.projectile.setDamage(t.projectile.getDamage()+ ajout );
    }


    public  void retirer(Tour t) {
        t.projectile.setDamage(t.projectile.getDamage() - ajout );
    }
    
}
