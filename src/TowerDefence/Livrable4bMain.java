package TowerDefence;

import TowerDefence.board.BoardTwo;

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
        
        
    }
    
}
