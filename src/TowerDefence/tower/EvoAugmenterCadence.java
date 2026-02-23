package TowerDefence.tower;

public class EvoAugmenterCadence extends Evolution {

    private double pourcentage;

    public EvoAugmenterCadence(double pourcentage,double cout){
        super("Cadence", cout);
        this.pourcentage=pourcentage;
    }

    public  void appliquer(Tour t) {
        t.cadence *= pourcentage;
    }

    public void retirer(Tour t) {
        t.cadence /= pourcentage;
    }

    
}
    

