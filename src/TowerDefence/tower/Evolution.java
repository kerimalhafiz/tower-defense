package TowerDefence.tower;

public abstract class Evolution {
    protected String nom;
    protected double cout;
    protected boolean acheter;
    public Evolution(String n,double c){
        this.nom=n;
        this.acheter=false;
        this.cout=c;
    }
public abstract void appliquer(Tour t);
public abstract void retirer(Tour t);

}
