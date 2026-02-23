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
   /*  public boolean acheter(Player p; Tour t){
        if(!this.acheter&&p.getMoney()>=this.cout){
            //retirer l argentdu solde du joueur
            this.appliquer(t);
            this.acheter=true;
            return true;
        }
        return false;
    }*/

   /*  public void vendre(Player p,Tour t){
        if(this.acheter){
            //on credite le solde du joueur
            this.retirer(t)//on enleve l effet de l'evolution
            this.acheter=false;
        }
    } */



}
