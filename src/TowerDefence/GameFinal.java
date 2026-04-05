package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.listchooser.*;
import java.util.ArrayList;

public class GameFinal extends FinalGame {

    private final ArrayList<Choice> actions;

    public GameFinal(Board b, int n, ListChooser c) {
        super(b, n, c);

        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer(n));
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

    @Override
    public void play() {
        System.out.println(p);

        while (p.isAlive()) {

            this.phaseAchat(p, this.b);


        }

        System.out.println("\n=== Game Over ===");
    }
}