import java.util.ArrayList;
import java.util.Random;
/**
 * a class implementing a straight path on the board.
 */
public class PathTwo implements Path {
    /**
     * build a pathtwo object
     */
    public PathTwo(){
        super();
    
    }
    
    /**
     * return a list of cells forming a correct straight path on the board
     * @param p the board  on which the path is computed
     * @return a list of cells representing the path
     */
    public ArrayList<Cell> findPath(Board p) {

        ArrayList<Cell> listPath = new ArrayList<>();
        //choix au hasard de la rentrée (0 pour la rentree horizontale(horizontalement) et 1 pour la rentree verticale(verticalement))
        Random rand = new Random();
        int choice= rand.nextInt(2);
        if (choice==0){
            //choix au hasard de la ligne 
            int ligne =rand.nextInt(p.getNbLigne());
            // choix au hasard de rentrer soit par la gauche ou par la droite (0 pour la gauche et 1 pour la droite )
            int alea=rand.nextInt(2);
            if (alea==0){
                for (int col=0;col<p.getNbColonne();col++){
                    listPath.add(p.getCell(ligne,col));
                }
            }
            else {
                
                    for (int col = p.getNbColonne() - 1; col >= 0; col--) {
                        Cell c = p.getCell(ligne, col);
                        
                        listPath.add(c);
                    }
                }
        }else {
                //choix au hasard de la colonne d'entree
                int colonne = rand.nextInt(p.getNbColonne());
                // choix au hasard de rentrer soit par le haut  ou par le bas  (0 pour le haut et 1 pour le bas )
                int alea=rand.nextInt(2);
                if (alea==0){
                    
                    for (int lig = 0; lig < p.getNbLigne(); lig++) {
                        Cell c = p.getCell(lig, colonne);
                        
                        listPath.add(c);
                    }
                } 
                else {
                    
                    for (int lig = p.getNbLigne() - 1; lig >= 0; lig--) {
                        Cell c = p.getCell(lig, colonne);
                    
                        listPath.add(c);
                    }
                }
            }

        return listPath;
    }
}





    
        

        
    

    
    



   

