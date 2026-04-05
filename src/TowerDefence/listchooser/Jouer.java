package TowerDefence.listchooser;

import java.util.ArrayList;

import TowerDefence.FinalGame;
import TowerDefence.Player;
import TowerDefence.board.Board;

public class Jouer implements Choice {
    private final ListChooser c;
    private final Board b;
    private final Player p;
    public final FinalGame game;
    public Jouer( Board b, Player p) {
        this.b = b;
        this.p = p;
        this.game = new FinalGame(this.b, this.p);
        
    }

    @Override
    public void apply() {
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