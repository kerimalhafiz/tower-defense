package mains;
import java.util.ArrayList;
import board.*;
import paths.*;

/**
 * Main class for Livrable 1a.
 * 
 * This program creates a board with a single random path
 * starting from the left side and ending on the right side.
 */
public class Livrable1a {
    /**
     * Default constructor.
     */
    public Livrable1a() {
        // nothing to initialize
    }

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments:
     *             args[0] = board height
     *             args[1] = board width
     */
    public static void main(String[] args) {
        if (args.length !=2) {
          System.out.println("error please write or give 2 entier as argument ");
          return;       
        }
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        Board board = new Board(height, width);
        Path path = new PathOne();
        ArrayList<Cell> chemin = path.findPath(board);

        board.printWithPath(chemin); 
        System.out.println("Path cells:");
        for (Cell c : chemin) {
            System.out.println(c);
        }
    }
}
