/**
 * Represents a single cell on the game board.
 * 
 * A cell is identified by its (x, y) coordinates.
 * It can be used as a basic element for paths, towers,
 * or balloon positions on the plateau.
 */
public class Cell{
     // attribut 
    private int x;
    private int y;
    /**
     * Creates a new cell with given coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Cell(int x,int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Returns the x coordinate of the cell.
     *
     * @return x coordinate
     */
   public int getX(){
     return  this.x;
   }

    /**
     * Returns the y coordinate of the cell.
     *
     * @return y coordinate
     */
   public int getY(){
    return this.y;
   }
   /**
     * Updates the x coordinate of the cell.
     *
     * @param newX the new x coordinate
     */
   public  void setvalueX(int new_x){
      this.x=new_x;
    
   }
   /**
     * Updates the x coordinate of the cell.
     *
     * @param new_y the new x coordinate
     */
   public void setvalueY(int new_y){
       this.y=new_y;
   }
   /**
     * Returns a string representation of the cell.
     *
     * @return string in the form "(x=?, y=?)"
     */
    @Override
   public String toString(){
    return "(x="+ x + ","+ y + ")";
   }

  /**
     * Compares this cell with another object.
     * Two cells are equal if they have the same coordinates.
     *
     * @param o the object to compare
     * @return true if both cells have identical coordinates
     */
  @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell))
             {return false;}
        Cell c = (Cell) o;
        return x == c.x && y == c.y;
    }


}