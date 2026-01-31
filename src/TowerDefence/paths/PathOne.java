package TowerDefence.paths;

import TowerDefence.board.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class generates a simple random path on a grid.
 * 
 * The path starts from a random entry row, moves horizontally until a
 * turning column, then moves vertically towards a random exit row, 
 * and finally continues horizontally to the end of the board.
 * Each cell in the path is marked with an "x".
 */
public class PathOne implements Path {

    /**
     * Constructs a PathOne instance.
     */
    public PathOne() {
        super();
    }

    /**
     * Generates a random path on the given grid of cells.
     * 
     * Algorithm:
     * 1. Choose a random entry row (lEnter) and a random exit row (lExit) that is different.
     * 2. Choose a random column (turning) where the path changes vertical direction.
     * 3. Move horizontally from the entry row to the turning column.
     * 4. Move vertically toward the exit row.
     * 5. Move horizontally from the turning column to the end of the board.
     * 6. Each cell in the path is marked with "x" using Cell.setvalueX("x").
     * 
     * @param cells a 2D array of cells representing the board/grid
     * @return an ArrayList of Positions representing the generated path
     */
    @Override
    public ArrayList<Position> findPath(Cell[][] cells) {

        Random rand = new Random();
        int nbLigne = cells.length;
        int nbColonne = cells[0].length;

        // Random entry and exit rows
        int lEnter = rand.nextInt(nbLigne);
        int lExit;
        do {
            lExit = rand.nextInt(nbLigne);
        } while (lExit == lEnter);

        ArrayList<Position> listePath = new ArrayList<>();

}
