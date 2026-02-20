package TowerDefence;
import TowerDefence.board.BoardOne;

public class Livrable3aMain {

      public static void main(String[] args) {

 // 1️ Vérification des arguments
    if (args.length != 3) {
        System.out.println(
            "Usage : java Livrable2a <largeur> <hauteur> <nbBallons>"
        );
        return;
    }

    // 2️ Lecture des arguments
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int nbBallons = Integer.parseInt(args[2]);
        // 3️ Création du plateau et du chemin
        BoardOne board = new BoardOne(height, width);
       Game game1=new Game(board, nbBallons);
       game1.play();
     

    
    }
}
