package TowerDefence.board;
import TowerDefence.Balloon.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the board of the game
 */
public abstract  class Board {

    /** the number of rows of the board */
    private int nbLigne;

    /** the number of columns of the board */
    private int nbColonne;

    /**the list of ballon */

    private ArrayList<Balloon> listeBallon;
    /** The array of cells composing the board. */
    protected Cell[][] board;


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
                 this.board[i][j] = new Cell(new Position(i, j));
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
     * Prints the board to the console using each cell's toString method.
     * Each row is printed on a separate line.
     */
    public void affiche() {
        for (int i = 0; i < this.nbLigne; i++) {
            for (int j = 0; j < this.nbColonne; j++) {
                System.out.print(this.board[i][j] + " "); // Cell.toString()
            }
            System.out.println();
        }
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

/**
 * Prints the board with a given path.
 * Cells belonging to the path are displayed with 'X',
 * while empty cells are displayed with '.'.
 * Row and column indices are shown to help visualization.
 *
 * @param path the list of cells representing the path
 */
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
/**
     * Adds a balloon to the board.
     * <p>
     * This is an abstract method and must be implemented by subclasses
     * to define how a Balloon is added to the board.
     * </p>
     *
     * @param b the Balloon to add
     */
    //public abstract void addBalloon(Balloon b);

    /**
     * Removes a balloon from the board.
     * <p>
     * This is an abstract method and must be implemented by subclasses
     * to define how a Balloon is removed from the board.
     * </p>
     *
     * @param b the Balloon to remove
     */
    //public abstract void removeBalloon(Balloon b);


   /* public void afficheWithBalloons(ArrayList<BalloonRfor> balloons, ArrayList<ArrayList<Position>> paths) {
    String[][] display = new String[nbLigne][nbColonne];
    
    for (int i = 0; i < nbLigne; i++) {
        for (int j = 0; j < nbColonne; j++) {
            display[i][j] = board[i][j].toString();
        }
    }   
        // on ajoute les ballon 
    for (int i = 0; i < balloons.size(); i++) {
        BalloonRfor b = balloons.get(i);
        ArrayList<Position> path = paths.get(i);
        int index = b.getcurrentPathIndex();
        if (index < path.size()) {
            Position p = path.get(index);
            display[p.getNbLigne()][p.getNbColonne()] = "B"; // B for the  balloon
        }
    }
    for (int i = 0; i < nbLigne; i++) {
        for (int j = 0; j < nbColonne; j++) {
            System.out.print(display[i][j] + " ");
        }
        System.out.println();
    }
} */
    public void move(List<Position> path, Balloon b) {

    int i = 0;
    float time = 0;

    int cmp = 0;                 // compteur d’itérations (temps)
    Cell previousCell = null;

    while (i < path.size()) {

        cmp++;                   //  une itération = 1 unité de temps

        // Si le ballon est gelé
        if (b.isFrozen()) {
            b.updateFrozenState();
            continue;
        }

        // Accumulation du temps selon la vitesse
        time += b.getSpeed();

        // Avancée cellule par cellule
        while (time >= 1 && i < path.size()) {


            Position current = path.get(i);
            Cell currentCell = this.getCell(
                current.getNbLigne(),
                current.getNbColonne()
            );

            // Quitte l’ancienne cellule
            if (previousCell != null) {
                previousCell.setvalueX(null);
            }

            // Entre dans la nouvelle cellule
            currentCell.setvalueX(b);

            previousCell = currentCell;
            time -= 1;
            i++;
        }
    }

    // Nettoyage final : le ballon sort du plateau
    if (previousCell != null) {
        previousCell.setvalueX(null);
    }

    // On stocke le temps dans le ballon
    b.setTime(cmp);

    
}

    
}
