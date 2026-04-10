package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;

public class FinalGame extends Game{
    ListChooser c;
      ArrayList<Tour> catalogue;
          private int manche;
        ArrayList <Choice> actions;
    public FinalGame(Board b,int n,ListChooser c){
        super(b, n);
        this.c = c;
        this.manche = 1;
        
       
    
    
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));

        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer());
    }



private void phaseAchat(Player p, Board b) {
    Choice choix = (Choice) this.c.choose(
            "Que voulez-vous faire ? | Crédits : " + p.getCredits(),
            this.actions);

    while (!(choix instanceof Jouer)) {

        choix.apply(p, b);
        choix = (Choice) this.c.choose(
                "Autre action ? | Crédits : " + p.getCredits(),
                this.actions);
    }
}
    

private void achatManche1(int n){
    if (n==1){
    for (Tour t : this.catalogue) {
        for(int i=1;i<2;i++){
            this.p.acheter(t);
        }
        
    }}
    return ;
}


public void play() {
    
    
    System.out.println(this.p);

    while (this.p.isAlive() && this.manche<=10) {

        System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
        this.achatManche1(this.manche);
        this.phaseAchat(this.p, this.b);
        super.play();
        this.manche++;
    }

    System.out.println("\n=== Game Over — Plus de vies ! Tu as perdu hahahaha ===");
}




}
