package TowerDefence;

import TowerDefence.board.BoardTwo;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;
/**
 * le livrable 5 du jeu 
 */
public class LivrableFinalMain {

    /**
     * le constructeur par defaut de la classe
     */
    public LivrableFinalMain() {
    }

    /**
     * le main pour le livrable 5
     * @param args les arguments en ligne de commande :
     *             hauteur largeur nbBallons typePlateau typeJoueur
     */
    public static void main(String[] args) {

      

        int hauteur      = 5;
        int largeur      = 5;
        int nbBallons    = 15;
        String typeJoueur = "humain";

        System.out.println("=== Informations ===");
        System.out.println("  typeJoueur : " + typeJoueur);
        System.out.println("  Plateau    : " + hauteur + " x " + largeur);
        System.out.println("  Ballons/m  : " + nbBallons);
        System.out.println("  Plateau    : " + "");
        System.out.println("=====================");

        ListChooser c;
        if (typeJoueur.equalsIgnoreCase("aleatoire")) {
            c = new RandomListChooser<>();
        } else {
            if (!typeJoueur.equalsIgnoreCase("humain")) {
                System.out.println("typeJoueur inconnu \"" + typeJoueur
                        + "\" — typeJoueur interactif utilisé par défaut.");
            }
            c = new InteractiveListChooser<>();
        }
        BoardTwo b=new BoardTwo(hauteur,largeur,10);
        FinalGame game=new FinalGame(b, nbBallons, c);
        game.play();


    }
}
