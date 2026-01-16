import java.util.ArrayList;
import java.util.Random;

public class PathOne implements Path{

    
    public PathOne(){
        super();
    
    }
    public ArrayList<Cell> findPath(Board p) {
    //choix au hasard d'une ligne d'entrée et de sortie    
    Random rand = new Random();
    int lEnter= rand.nextInt(p.getnbLigne());
    int lExit;
     do {
        lExit = rand.nextInt(p.getnbLigne());
    } while (lExit == lEnter);
    System.out.println(lEnter +" , "+lExit);
    ArrayList<Cell> listePath = new ArrayList<>();






    }
}