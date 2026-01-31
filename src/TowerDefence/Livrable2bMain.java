package TowerDefence;


import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Classe principale permettant d'exécuter le livrable 1b.
 */
public class Livrable2bMain {
 

    public static void main(String[] args) {

   if (args.length != 3) {
            System.out.println(
                "Usage : java Livrable2b <height> <width> <number_of_paths>"
            );
            return;
        }

        //  Lecture des arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);

        //  Création du plateau avec nPaths chemins
        BoardTwo board = new BoardTwo(height, width, nPaths);
        ArrayList<ArrayList<Position>> paths = board.path(); // liste de chemins

        //  Affichage des chemins (optionnel)
        System.out.println("Chemins trouvés :");
        int idx = 0;
        for (ArrayList<Position> chemin : paths) {
            System.out.println("Chemin " + idx + " : " + chemin.size() + " cases");
            idx++;
        }

        //  Création des ballons (1 par chemin) avec vitesses aléatoires
        ArrayList<Balloon> balloons = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < paths.size(); i++) {
            float speed = 0.5f + rand.nextFloat() * 2.0f; // vitesse entre 0.5 et 2.5
            balloons.add(new BasicBalloon(speed, 1,"Ballon "+i)); // ID = i+1
        }

        //  Déplacement de chaque ballon sur son chemin
        for (int i = 0; i < paths.size(); i++) {
            Balloon b = balloons.get(i);
            ArrayList<Position> chemin = paths.get(i);

            System.out.println(
                "\nDéplacement du ballon " + b.getId() +
                " sur le chemin " + i +
                " (vitesse = " + b.getSpeed() + ")"
            );

            board.move(chemin, b); // met à jour b.setTime()

            System.out.println(
                "Ballon " + b.getId() +
                " sorti du chemin au temps t = " + b.getTime()
            );
            System.out.println("--------------------------");
        }

        System.out.println("Tous les ballons ont terminé leur parcours.");
    }
}