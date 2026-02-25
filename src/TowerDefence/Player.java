package TowerDefence;

import TowerDefence.tower.Evolution;
import TowerDefence.tower.Tour;
import java.util.ArrayList;

public class Player {

protected double credit;
protected int vies;
ArrayList<Tour>towers;
public Player(){
    this.credit=2500;
    this.vies=20;
    this.towers=new ArrayList<>();
}

public void setCredit(int n){
    this.credit=n;
}
public double  getCredit(){
    return this.credit;
}
public void diminueVieDe(double  n){
    this.vies-=n;
    if (this.vies<0){
        this.vies=0;
    }
}
public int getVie(){
    return this.vies;
}

public boolean  acheter(Tour t){
    if(this.credit>=t.getCout()){
        this.credit-=t.getCout();
        this.towers.add(t);
        return true;
    }
    return false;
}
public void acheterEvolution(Tour t){
    ArrayList<Evolution>evo=t.getEvolutions();
    int i=0;
    while(i<evo.size()&&(!evo.get(i).Isbuy())&&evo.get(i).getCout()<=this.credit){
        i++;
    }
    if(i<evo.size()){
    evo.get(i).appliquer(t);
    evo.get(i).buy();
    this.credit-=evo.get(i).getCout();
    System.out.println("Evolution de la tour nom de l evolution: "+evo.get(i).getNom());
}

}





}
