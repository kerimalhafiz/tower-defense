package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;

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

       
        String mode      = "interactif";
        int hauteur   = 5;
        int  largeur   =5;
        int  nbBallons = 2;

        System.out.println("=== Informations ===");
        System.out.println("  Mode      : " + mode);
        System.out.println("  Plateau   : " + hauteur + " x " + largeur);
        System.out.println("  Ballons/m : " + nbBallons);
        System.out.println("=====================");
        ListChooser c;
        if (mode.equalsIgnoreCase("automatique")) {
            c = new RandomListChooser<>();
        } else {
            if (!mode.equalsIgnoreCase("interactif")) {
                System.out.println("Mode inconnu \"" + mode
                        + "\" — mode interactif utilisé par défaut.");
            }
            c = new InteractiveListChooser<>();
        }

        BoardOne board = new BoardOne(hauteur, largeur);
        FinalGame game = new FinalGame(board, nbBallons, c);
        game.play();

    }}
