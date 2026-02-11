package TowerDefence;


import TowerDefence.board.*;
/**
 * Classe principale permettant d'exécuter le livrable 1b.
 */
public class Livrable2bMain {
 

    public static void main(String[] args) {

   if (args.length != 3) {
            System.out.println(
                "Usage : java Livrable2b <height> <width> <number_of_paths>"
            );
            return;
        }

        //  Lecture des arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);

        //  Création du plateau avec nPaths chemins
        BoardTwo board = new BoardTwo(height, width, nPaths);
        Game game=new Game(board, nPaths);
        game.play();
     
        
 
    }
}