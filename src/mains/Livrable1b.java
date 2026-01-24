package mains;

import board.BoardTwo;
import board.Position;
import java.util.ArrayList;
/**
 * Classe principale permettant d'exécuter le livrable 1b.
 */
public class Livrable1b {
    
    /**
     * Default constructor (no initialization needed).
     */
    public Livrable1b() {
        // nothing to initialize
    }

    /**
     * Entry point of the program.
     * 
     * Usage: java mains.Livrable1b height width number_of_paths
     * 
     * @param args command-line arguments:
     *             args[0] = board height (number of rows)
     *             args[1] = board width (number of columns)
     *             args[2] = number of straight paths to generate
     */
    public static void main(String[] args) {
        // Check for correct number of arguments
        if (args.length != 3) {
            System.out.println("Error: please provide 3 integers as arguments (height, width, number_of_paths).");
            return;
        }

        // Parse arguments
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int nPaths = Integer.parseInt(args[2]);
    

    // Create the board with multiple paths
        BoardTwo board = new BoardTwo(height, width, nPaths);
        ArrayList<ArrayList<Position>> paths = board.path();

        // Display each path
        System.out.println("Chemins trouvés :");
        int index = 0;
        for (ArrayList<Position> chemin : paths) {
            System.out.println("Chemin " + index + " :");
            for (Position pos : chemin) {
                System.out.println(pos);
            }
            index++;
            System.out.println();
        }

        // Display the board with all paths marked
        System.out.println("Grille du plateau :");
        board.affiche();

    }
}
