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

       if (args.length != 4) {
            System.out.println(
                "Usage : java Livrable5a <mode> <height> <width> <number_of_ballons>"
            );
            return;
        }
        String mode      = args[0];
        int hauteur   = Integer.parseInt(args[1]);
        int  largeur   = Integer.parseInt(args[2]);
        int  nbBallons = Integer.parseInt(args[3]);

        System.out.println("=== Informations ===");
        System.out.println("  Mode      : " + mode);
        System.out.println("  Plateau   : " + hauteur + " x " + largeur);
        System.out.println("  Ballons/m : " + nbBallons);
        System.out.println("=====================");


    }}
