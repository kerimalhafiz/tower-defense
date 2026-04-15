package TowerDefence;

import TowerDefence.Balloon.*;
import TowerDefence.board.Board;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;

public class FinalGame extends Game {

    private ListChooser c;
    private ArrayList<Tour> catalogue;
    private int manche;
    private ArrayList<Choice> actions;

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
    @Override
    public void createBalloons() {
        this.listeBallon = new ArrayList<>();

        float vitesse = 0.5f + (this.manche * 0.2f);

        for (int i = 1; i <= this.n; i++) {
            String id = "Ballon-M" + this.manche + "-" + i;

            Balloon ballon = new BasicBalloon(vitesse, this.manche, id);

            this.listeBallon.add(ballon);
        }

        System.out.println("\n=== Manche " + this.manche +
                " — " + this.n + " ballons générés ===");
    }

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
            super.play();

            this.manche++;
        }

        System.out.println("\n=== GAME OVER ===");
    }
}