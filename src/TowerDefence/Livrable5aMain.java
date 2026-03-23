package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;

public class Livrable5aMain {
    /**
     * le constructeur par defaut de la classe 
     */
    public Livrable5aMain(){

    }

/**
 * le main pour le livrable 4a
 * @param args les arguments en ligne de commande 
 */
 public static void main(String[] args) {

    int width=10;
    int height=10;
    int nbBallons=10;

    BoardOne board=new BoardOne(height, width);
    ListChooser c=new InteractiveListChooser<>();
        // Create the game with the given board and number of balloons
    FinalGame game1 = new FinalGame(board, nbBallons,c);

    game1.Playerer();
}}
