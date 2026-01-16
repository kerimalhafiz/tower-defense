import java.util.ArrayList;
import java.util.Random;

public class PathOne implements Path{

    
    public PathOne(){
        super();
    
    }
    public ArrayList<Cell> findPath(Board p) {
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