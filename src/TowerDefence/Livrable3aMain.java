package TowerDefence;
import TowerDefence.board.BoardOne;

public class Livrable3aMain {

      public static void main(String[] args) {



    // 2️ Lecture des arguments
        int width = 10;
        int height = 5;
        int nbBallons = 5;
        // 3️ Création du plateau et du chemin
        BoardOne board = new BoardOne(height, width);
       Game game1=new Game1(board, nbBallons);
       game1.play();
     

    
    }
}
