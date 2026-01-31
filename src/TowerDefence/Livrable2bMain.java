package TowerDefence;
import TowerDefence.board.*;
import java.util.*;
import TowerDefence.Balloon.*;

public class Livrable2bMain { 
    public static void main(String[] args) {
        if (args.length!=4) {
            System.out.println("erreur c'est  une erreur veuillez entrer  nombre de colone ,ligne, le nombre de chemin et le nombre de balloon");
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);
        int nbBalloon = Integer.parseInt(args[3]);

        BoardTwo board = new BoardTwo(height, width, nPaths);
        ArrayList<ArrayList<Position>> paths = board.path();

        // Création des ballons, un par chemin
        Random rand = new Random();
        ArrayList<BalloonRfor> balloons = new ArrayList<>();
        for (int i = 0; i < Math.min(nbBalloon, paths.size()); i++) {
            float speed = 0.1f + rand.nextFloat() * 0.4f; 
            balloons.add(new BalloonRfor(speed, 4,"Ballon1"));
        }

int tick = 0;
boolean finished;
do {
    tick++;
    finished = true;

    // Déplacer tous les ballons
    for (int i = 0; i < balloons.size(); i++) {
        BalloonRfor b = balloons.get(i);
        ArrayList<Position> chemin = paths.get(i);
        b.move(chemin);
        if (b.getcurrentPathIndex() < chemin.size()) 
            finished = false;
        System.out.println(
        "Ballon " + i +
        " -> case " + b.getcurrentPathIndex()+
        " progress=" + b.getprogress()
);

    }

    //display 
    board.afficheWithBalloons(balloons, paths);

    System.out.println("Tick: " + tick);

    // it the small delay for see the tic of horloge 
    try { Thread.sleep(200); } catch (InterruptedException e) {}

} while (!finished);

System.out.println("Tous les ballons ont terminé leur parcours après " + tick + " ticks !");

}
}

