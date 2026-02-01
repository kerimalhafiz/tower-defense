package TowerDefence;
import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import java.util.*;

public class Livrable2aMain{
    public static void main(String[] args) {

 // 1️ Vérification des arguments


    // 2️ Lecture des arguments
    int width = 7;
    int height = 7;
    int nbBallons = 3;
        // 3️ Création du plateau et du chemin
        BoardOne board = new BoardOne(height, width);
        ArrayList<Position> path = board.path();

        // 4️ Création des ballons en ordre
        ArrayList<Balloon> ballons = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= nbBallons; i++) {
            float speed = 0.5f + rand.nextFloat() * 2.0f; // vitesse aléatoire
            ballons.add(new BasicBalloon(speed, 1,"Ballon "+i+":"));
        }

        // 5️ Déplacement des ballons
        for (Balloon b : ballons) {

            System.out.println(
                "\nDéplacement du ballon " + b.getId() +
                " (speed = " + b.getSpeed() + ")"
            );

            board.move(path, b);

            System.out.println(
                "Ballon " + b.getId() +
                " sorti au temps t = " + b.getTime()
            );
            System.out.println("--------------------------");
        }

        System.out.println("Tous les ballons ont terminé leur parcours.");
    }
}
