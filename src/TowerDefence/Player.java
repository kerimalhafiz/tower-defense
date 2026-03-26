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
protected double credits;
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
    this.credits=2500;
    this.vies=20;
    this.towers=new ArrayList<>();
}
/** 
* Adds credits to the player's balance (e.g. after destroying a balloon).
*
* @param amount amount to add
*/
public void ajouterCredits(double amount) {
    this.credits += amount;
    System.out.println("Credits +" + amount + " → total : " + this.credits);
}

/**
 * Returns the current credits of the player.
 *
 * @return credits
 */
public double getCredits() {
    return this.credits;
}
/**
 * Decrements the player's lives by the given amount.
 * Lives cannot go below 0.
 *
 * @param amount number of lives to lose
 */
public void diminueVieDe(int amount) {
    this.vies -= amount;
    if (this.vies < 0) {
        this.vies = 0;
    }
    System.out.println("Vie perdue ! Vies restantes : " + this.vies);
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
public void acheterEvolution(Tour t,Evolution e){
    if (e.getCout()>this.credit|e.isbuy()){
        return;
    }
    else{
        this.credit-=e.getCout();
        e.appliquer(t);
        e.buy();
    }
   
}
public void revendreTour(Tour t){
    this.credit+=t.getCout();
    this.towers.remove(t);
}
public void RevendreEvolution(Tour T,Evolution e){
    e.retirer(T);
    this.credit+=e.getCout();
}


}






