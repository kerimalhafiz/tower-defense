package TowerDefence;
import TowerDefence.board.BoardTwo;

public class Livrable3bMain {
  public static void main(String[] args) {

   if (args.length != 3) {
            System.out.println(
                "Usage : java Livrable3b <height> <width> <number_of_paths>"
            );
            return;
        }

        //  Lecture des arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);

        //  Création du plateau avec nPaths chemins
        BoardTwo board = new BoardTwo(height, width, nPaths);
        Game game1=new Game1(board, nPaths);
        game1.play();
     
        
 
    }
}
