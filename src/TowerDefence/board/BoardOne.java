package TowerDefence.board;

import java.util.ArrayList;
import TowerDefence.paths.*;

/**
 * Concrete implementation of a Board.
 * <p>
 * BoardOne represents a simple game board with a single random path.
 * It extends the abstract Board class and provides a method to generate
 * a random path using the PathOne algorithm.
 * </p>
 */
public class BoardOne extends Board {

    /**
     * Constructs a BoardOne with the specified number of rows and columns.
     * <p>
     * The board is initialized with empty cells, each having its Position.
     * </p>
     *
     * @param nbLigne  number of rows of the board
     * @param nbColonne number of columns of the board
     */
    public BoardOne(int nbLigne, int nbColonne) {
        super(nbLigne, nbColonne);
    }

    /**
     * Generates a random path on this board.
     * <p>
     * This method uses the PathOne class to create a random path starting
     * from a random entry row and ending at a different exit row. The path
     * is returned as a list of Positions representing the cells in the path.
     * </p>
     *
     * @return an ArrayList of Positions representing the generated path
     */
    public ArrayList<Position> path() {
        PathOne p = new PathOne();
        return p.findPath(this.board);
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


 