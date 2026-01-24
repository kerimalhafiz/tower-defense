package board;

import java.util.ArrayList;
import paths.PathTwo;

/**
 * Concrete implementation of a Board with multiple straight paths.
 * 
 * BoardTwo generates a board with a specified number of straight paths
 * (horizontal or vertical) using the PathTwo algorithm.
 * Each path is stored as a list of Positions and the cells in the path
 * are marked with "x".
 */
public class BoardTwo extends Board {

    /** Number of paths to generate on the board */
    private int nPaths;

    /**
     * Constructs a BoardTwo with the given dimensions and number of paths.
     * 
     * @param l number of rows of the board
     * @param c number of columns of the board
     * @param n number of straight paths to generate
     */
    public BoardTwo(int l, int c, int n) {
        super(l, c);
        this.nPaths = n;
    }

    /**
     * Generates multiple straight paths on the board.
     * 
     * For each path, a new straight path is generated using PathTwo
     * and added to the list of paths. Cells that belong to the paths
     * are marked with "x".
     * 
     * @return an ArrayList of ArrayLists of Positions, where each inner
     *         list represents a single path
     */
    public ArrayList<ArrayList<Position>> path() {
        ArrayList<ArrayList<Position>> chemins = new ArrayList<>();
        PathTwo p = new PathTwo();

        for (int i = 0; i < this.nPaths; i++) {
            ArrayList<Position> chemin = p.findPath(this.board);
            while(chemins.contains(chemin)){
                chemin = p.findPath(this.board);}
            {chemins.add(chemin);} 
        }

        return chemins;
    }

       /** 
/**
 * Adds a balloon to the board.
 * 
 * Implementations should track the balloon on the board
 * (for example, by storing it in a list of balloons or updating the cell it occupies).
 *
 * @param b the Balloon to add
 */

//public abstract void addBalloon(Balloon b);

/**
 * Removes a balloon from the board.
 * 
 * Implementations should remove the balloon from the board
 * (for example, by removing it from a list of balloons or clearing the cell it occupies).
 *
 * @param b the Balloon to remove
 */

//public abstract void removeBalloon(Balloon b);


}


