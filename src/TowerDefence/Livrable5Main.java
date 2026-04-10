package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;

public class Livrable5Main {
    /**
     * le constructeur par defaut de la classe 
     */
    public Livrable5Main(){

    }

/**
 * le main pour le livrable 5a 
 * @param args les arguments en ligne de commande 
 */
    public static void main(String[] args) {

       if (args.length < 5) {
            System.out.println(
                "Usage : java Livrable5  <height> <width> <number_of_ballons> <type Plateau> <type joueur>"
            );
            return;
        }
         String mode      = args[4];
        int hauteur   = Integer.parseInt(args[0]);
        int  largeur   = Integer.parseInt(args[1]);
        int  nbBallons = Integer.parseInt(args[2]);
        String typeboard=args[3];
    


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
        if(typeboard.equals("BoardOne")){
        BoardOne board = new BoardOne(hauteur, largeur);
        FinalGame game = new FinalGame(board, nbBallons, c);
        game.play();

        }
        else if(typeboard.equals("BoardTwo")){

             if (args.length < 6) {
         System.out.println("Manque nbPath pour BoardTwo");
          return;
    }
        System.out.println("which number of path do you need ");
          int nbpath=Integer.parseInt(args[5]);

        BoardTwo board = new BoardTwo(hauteur, largeur, nbpath);
        FinalGame game = new FinalGame(board, nbBallons, c);
        game.play();
        }
    }}
