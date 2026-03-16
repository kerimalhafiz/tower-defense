package TowerDefence;

import TowerDefence.tower.Evolution;
import TowerDefence.tower.Tour;
import java.util.ArrayList;
import java.util.Random;
/**
 * la classe player 
 */
public class Player {
/**
les credits du joueur pour acheter des tours 
 */
protected double credit;
/**
le nombre de vie qu'un joueur peut avoir 
*/
protected int vies;
/**
la liste des tours  
*/
ArrayList<Tour>towers;
/**
 * le constructeur de la classe player  
 * */
public Player(){
    this.credit=2500;
    this.vies=20;
    this.towers=new ArrayList<>();
}
/**
 * les credits qu'un joueur detient pour pour acheter une tour
 * @param n le nombre de credit 
 */
public void setCredit(int n){
    this.credit=n;
}
/**
 * obtient le nombre qu'a un joueur
 * @return les credits du joueur
 */
public double  getCredit(){
    return this.credit;
}
/**
 * diminue le nombre de vie 
 * @param n le nombre de vie qu'a un joueur
 */
public void diminueVieDe(double  n){
    this.vies-=n;
    if (this.vies<0){
        this.vies=0;
    }
}
/**
 * renvoie le nombre de vie que detient un joueur
 * @return le nombre de vie d'un joueur 
 */
public int getVie(){
    return this.vies;
}
/**
 * renvoie true si on a pu acheter la tour et false sinon 
 * @param t la tour qu'on veut acheter 
 * @return true si on a pu acheter la tour et false sinon 
 */
public boolean  acheter(Tour t){
    if(this.credit>=t.getCout()){
        this.credit-=t.getCout();
        this.towers.add(t);
        return true;
    }
    return false;
}
/**
 * la methode qui permet d'acheter une evolution
 * @param t le tour au quel on doit acheter l'evoluton
 */
private void acheterEvolution(Tour t){
    ArrayList<Evolution>evo=t.getEvolutions();
    int i=0;
    while(i<evo.size()&&((evo.get(i).isbuy())||evo.get(i).getCout()>this.credit)){
        i++;
    }
    if(i<evo.size()){
    evo.get(i).appliquer(t);
    evo.get(i).buy();
    this.credit-=evo.get(i).getCout();
    System.out.println("Evolution de la tour nom de l evolution: "+evo.get(i).getNom());
}}
/**
 * achete une tour choisie au hasard parmis les tours 
 */
public void evoluer(){
    Random r = new Random();
    int i=r.nextInt(this.towers.size());
    Tour t=this.towers.get(i);
    this.acheterEvolution(t);   
}

}






