package TowerDefence.listchooser;

import java.util.ArrayList;

import TowerDefence.FinalGame;
import TowerDefence.Player;
import TowerDefence.board.Board;

public class Jouer implements Choice {
    private final Board b;
    private final Player p;
    public final FinalGame game;
    public Jouer( Board b, Player p) {
        this.b = b;
        this.p = p;
        this.game = new FinalGame(this.b, this.p);
        
    }

    @Override
    public void apply(Player p, Board b){
  
    }

    @Override
    public String toString() { return "Jouer"; }
}