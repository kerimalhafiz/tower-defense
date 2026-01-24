package board;

/**
 * Represents a single cell on the game board.
 * 
 * A cell is identified by its (x, y) coordinates.
 * It can be used as a basic element for paths, towers,
 * or balloon positions on the plateau.
 */
public class Cell{
      /** Position of the cell on the board */
    private Position position;

    /** Display value of the cell (default is ".") */
    private String value;

    /**
     * Constructs a Cell with the given position.
     * Initializes the value to "." (empty cell).
     * 
     * @param p the Position of the cell
     */
    public Cell(Position p) {
        this.position = p;
        this.value = ".";
    }


}