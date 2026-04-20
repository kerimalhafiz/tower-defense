package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;

public class FinalGame extends Game {

    private ListChooser c;
    private ArrayList<Tour> catalogue;
    private int manche;
    private ArrayList<Choice> actions;
    /**
     * le jeu final 
     * @param b le board du jeu 
     * @param n le nombre de manche du jeu 
     * @param c le code listeChooser qui permet de faire le choix daction  
     */
    public FinalGame(Board b, int n, ListChooser c){
        super(b, n);

        this.c = c;
        this.manche = 1;

        // catalogue de tours
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));

        // actions joueur
        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer());
    }

    /**
     * Override wave generation per round
     */



    /**
     * Phase d'achat
     */
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
   

    /**
     * Main game loop
     */
    @Override
    public void play() {
    
        while (this.p.isAlive()) {
            System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
            this.phaseAchat(this.p, this.b);
        
            System.out.println("\n--- Combat ---");
            for (Tour t : this.p.towers) {
            t.startTir(this.b);
        }
            super.play();

            
             for (Tour t : this.p.towers) {
            t.stopTir();
        }
        this.manche++;
        }

        System.out.println("\n=== GAME OVER ===");
    }
}