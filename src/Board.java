import java.util.ArrayList;

/**
 * the board of the game
 */
public class Board {

    /* the number of rows of the board */
    private int nbLigne;

    /* the number of columns of the board */
    private int nbColonne;

    /* the array of cells */
    private Cell[][] board;

    /**
     * the board class
     * @param nbLigne the number of rows of the board
     * @param nbColonne the number of columns of the board
     */
    public Board(int nbLigne,int nbColonne){
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        this.board=new Cell [nbLigne][nbColonne];

        /* I fill the array with empty cells */
        for (int i=0 ; i<nbLigne ; i++){
            for (int j=0 ; j<nbColonne ; j++){
                 this.board[i][j] = new Cell(i,j);
            }
        }
    }

    /**
     * get the number of rows of this board 
     * @return the number of rows of this board
     */
    public int getNbLigne(){
        return this.nbLigne;
    }

    /**
     * get the number of columns of this board
     * @return the number of columns of this board
     */ 
    public int getNbColonne(){
        return this.nbColonne;
    }

    /**
     * get a cell of the board
     * @param i the row index
     * @param j the column index
     * @return the cell corresponding to this position
     */
    public Cell getCell(int i,int j){
        return this.board[i][j];
    }

    /**
     * the toString method for the board *
     * @return res it the point for display
    */
    public String tostring(){
        String res = "";
        for (int i = 0 ; i<this.nbLigne ; i++){
            for (int j = 0 ;j<this.nbColonne;j++){
                res += "+---";
            }
            res += "+\n";
            for (int j = 0 ; j<this.nbColonne ; j++){
                res += "|   ";
            }
            res += "|\n";
        }
        for (int j = 0 ;j<this.nbColonne ; j++){
            res += "+---";
        }
        res += "+\n";
        return res;
    }
public void printWithPath(ArrayList<Cell> path) {
    
    System.out.print("    ");
    for (int j = 0; j < nbColonne; j++) {
        System.out.print(j + "   ");
    }
    System.out.println();

    for (int i = 0; i < nbLigne; i++) {
        System.out.print(i + " | "); 
        for (int j = 0; j < nbColonne; j++) {
            if (path.contains(board[i][j])) {
                System.out.print("X | ");
            } else {
                System.out.print(". | ");
            }
        }
        System.out.println();
    }
}

    
}
