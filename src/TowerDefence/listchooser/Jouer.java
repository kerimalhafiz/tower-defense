package TowerDefence.listchooser;

import java.util.ArrayList;

import src.TowerDefence.FinalGame;
import src.TowerDefence.Player;
import src.TowerDefence.board.Board;

public class Jouer implements Choice {
    private final ListChooser c;
    private final Board b;
    private final int n;
    public final FinalGame game;
    public Jouer(ListChooser c, Board b, int n) {
        this.c = c;
        this.b = b;
        this.n = n;
        this.game = new FinalGame(this.b, this.n);
        
    }

    @Override
    public void apply(Player p, Board b) {
        ArrayList<String> modes = new ArrayList<>();
        modes.add("Interactif");
        modes.add("Automatique");

        String mode = (String) c.choose("Choisissez un mode de jeu :", modes);
        if (mode == null) return;

        ListChooser chooser;
        if (mode.equals("Interactif")) {
            chooser = new InteractiveListChooser<>();
        } else {
            chooser = new RandomListChooser<>();
        }
        
        this.game.play();
    }

    @Override
    public String toString() { return "Jouer"; }
}