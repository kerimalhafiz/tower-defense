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
    //choix de la colonne de changement de direction
    int milieu=rand.nextInt(p.getnbColonne());
    //avancer en ligne droite jusqu a la case choisie
    for (int i=0;i<=milieu;i++){
    Cell c=p.getCell(lEnter, i);
    listePath.add(c);
    }

    //le balon monte vers la ligne de sortie
    if (lEnter < lExit){
    for(int j=lEnter+1;j<=lExit;j++){
        System.out.println("Apres");
   
        System.out.println(j + " "+ milieu);
        Cell c=p.getCell(j, milieu);
        listePath.add(c);
      
    } }





    }
}