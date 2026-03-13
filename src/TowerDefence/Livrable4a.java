package TowerDefence;

import TowerDefence.board.BoardOne;

public class Livrable4a {

 public static void main(String[] args) {
    if (args.length!=3) {
        System.out.println(  "Usage : java Livrable4a <height> <width> <number_of_ballons>");
        return;
        
    }

    int width=Integer.parseInt(args[0]);
    int height=Integer.parseInt(args[1]);
    int nbBallons=Integer.parseInt(args[2]);

    BoardOne board=new BoardOne(height, width);
    Game game=new Game(board, nbBallons);
 }
}