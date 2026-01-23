import java.util.ArrayList;
import java.util.Random;
/**
 * This class generates a simple path for the board.
 * The path starts from a random entry row, changes direction once,
 * and ends on a different exit row.
 */
public class PathOne implements Path{

    /**
     * Creates a PathOne instance.
     */
    public PathOne(){
        super();
    
    }
    public ArrayList<Cell> findPath(Board p) {
    //choix au hasard d'une ligne d'entrée et de sortie    
    Random rand = new Random();
    int lEnter= rand.nextInt(p.getNbLigne());
    int lExit;
     do {
        lExit = rand.nextInt(p.getNbLigne());
    } while (lExit == lEnter);
    System.out.println(lEnter +" , "+lExit);
    ArrayList<Cell> listePath = new ArrayList<>();
    //choix de la colonne de changement de direction
    int turning=rand.nextInt(p.getNbColonne());
    //avancer en ligne droite jusqu a la case choisie
    for (int i=0;i<=turning;i++){
    Cell c=p.getCell(lEnter, i);
    listePath.add(c);
    }

    //le balon monte vers la ligne de sortie
    if (lEnter < lExit){
    for(int j=lEnter+1;j<=lExit;j++){
        System.out.println("Apres");
   
        System.out.println(j + " "+ turning);
        Cell c=p.getCell(j, turning);
        listePath.add(c);
      
    } }
    //trajet pour descendre
    else{ 
        for(int j=lEnter-1;j>=lExit;j--){
        System.out.println("Apres");
       
        System.out.println(j + " "+ turning);
        Cell c=p.getCell(j, turning);
        listePath.add(c);
        
    }
    }

    //derniere ligne droite
    for (int k=turning+1;k<p.getNbColonne();k++){
        Cell c=p.getCell(lExit, k);
        listePath.add(c);
     
    }
    return listePath;

    }
}