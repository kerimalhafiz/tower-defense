package TowerDefence;

import TowerDefence.board.BoardTwo;
import TowerDefence.tower.Tour;

public class Livrable4bMain {
    public static void main(String[] args) {
        if (args.length!=3) {
        System.out.println(  "Veuillez entrer trois nombres :hauteur , largeur et nombre de chemins");
        return;
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nbChemins =(Integer.parseInt(args[2]));

        BoardTwo board= new BoardTwo(height, width, nbChemins);
        Game1 game= new Game1(board, nbChemins);

        for(int manche =1 ;manche<=10;manche++){
            System.out.println("\n===Manche"+ manche+ "===");

            if(manche<=5){
                for(Tour tower:game.getTours()){
                    tower.towersApplication();
                }
            }
            else{
                for (Tour tower :game.getTours()){
                    tower.towers_revome();
                }
            }
            game.play();
        }
        
    }
    
}
