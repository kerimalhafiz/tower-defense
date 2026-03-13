package TowerDefence;

import TowerDefence.board.BoardOne;
import TowerDefence.tower.Tour;

public class Livrable4aMain {
     /**
      * constructor
      */
    public Livrable4aMain(){};

 public static void main(String[] args) {
    if (args.length!=3) {
        System.out.println(  "Usage : java Livrable4a <height> <width> <number_of_ballons>");
        return;
        
    }

    int width=Integer.parseInt(args[0]);
    int height=Integer.parseInt(args[1]);
    int nbBallons=Integer.parseInt(args[2]);

    BoardOne board=new BoardOne(height, width);
    Game1 game=new Game1(board, nbBallons);
    for(int manche=1;manche<=10;manche++){
        System.out.println("\n===Manche"+manche+"===");
        if (manche>=1 && manche<=5) {
            for(Tour t:game.getTours()){
                t.towersApplication();
            }
            
        }
        else{
            if(manche >=6 && manche<=10){
                for(Tour t:game.getTours()){
                    t.towers_revome();
                }
            }
        }
        game.play();

    }
 }
}