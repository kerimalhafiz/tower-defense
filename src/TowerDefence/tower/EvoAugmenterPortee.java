package TowerDefence.tower;

public class EvoAugmenterPortee extends Evolution{
    private double pourcentage;

    public EvoAugmenterPortee(double pourcentage,double cout){
        super("Cadence", cout);
        this.pourcentage=pourcentage;
    }
}
