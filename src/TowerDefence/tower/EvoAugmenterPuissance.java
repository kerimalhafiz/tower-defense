package TowerDefence.tower;

public class EvoAugmenterPuissance extends Evolution {

    private double ajout;
    
    public EvoAugmenterPuissance(double ajout,double cout ){
        super("Puissance", cout);
        this.ajout= ajout ;

    }
}
