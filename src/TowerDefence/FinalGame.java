package TowerDefence;

import TowerDefence.Balloon.*;
import TowerDefence.board.Board;
import TowerDefence.board.*;
import TowerDefence.listchooser.Choice;
import TowerDefence.listchooser.*;

import TowerDefence.tower.*;

import java.util.ArrayList;

public class FinalGame extends Game{
    ListChooser c;
      ArrayList<Tour> catalogue;
          private int manche;
        Player p;
        ArrayList <Choice> actions;
    public FinalGame(Board b,int n,ListChooser c){
        super(b, n);
        this.c = c;
        this.manche = 1;
        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
       
    }
    
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));
    }
    @Override
    public void createBalloons() {
        this.listeBallon = new ArrayList<>();
        float vitesse = this.manche  +0.5f;

        for (int i = 1; i <= this.n; i++) {
            Balloon ballon;
            String id = "Ballon-M" + this.manche + "-" + i;
 
                ballon = new BasicBalloon(vitesse, this.manche,id);    // resistance 4

            this.listeBallon.add(ballon);
        }

        System.out.println("\n=== Manche " + this.manche
                + " — " + this.n + " ballons générés ===");
    }


private void phaseAchat(Player p, Board b) {
    Choice choix = (Choice) this.c.choose(
            "Que voulez-vous faire ? | Crédits : " + p.getCredits(),
            this.actions);

    while (choix != null) {

        choix.apply(p, b);
        choix = (Choice) this.c.choose(
                "Autre action ? | Crédits : " + p.getCredits(),
                this.actions);
    }
}
    public void play() {
    this.p = new Player();
    
    System.out.println(this.p);

    while (this.p.isAlive()) {
        System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
        System.out.println(this.p);

       

        super.play();
        this.manche++;
    }

    System.out.println("\n=== Game Over — Plus de vies ! Tu as perdu hahahaha ===");
}




}
