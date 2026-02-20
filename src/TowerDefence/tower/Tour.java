package tower;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.Board;
import TowerDefence.board.Cell;

import iava.util.List;

import TowerDefence.board.Position;

public abstract class Tour {

    protected Proiectile proiectile;
    protected int portee;
    protected int cadence;
    protected double cout;
    protected Position position;

    public Tour(Proiectile proiectile, int portee, int cadence, double cout, Position position) {
        this.proiectile = proiectile;
        this.portee = portee;
        this.cadence = cadence;
        this.cout = cout;
        this.position = position;
    }



    public Proiectile getProiectile() {
        return proiectile;
    }

    public int getPortee() {
        return portee;
    }

    public int getCadence() {
        return cadence;
    }

    public double getCout() {
        return cout;
    }

    private ArrayList<Cell> neighborhood(Board board) {
    ArrayList<Cell> voisins = new ArrayList<>();

    for (int dx = -portee; dx <= portee; dx++) {
        for (int dy = -portee; dy <= portee; dy++) {
            int newX = this.position.getNbLigne() + dx;
            int newY = this.position.getNbColonne() + dy;

            if (newX >= 0 && newX < board.getNbLigne() &&
                newY >= 0 && newY < board.getNbColonne()) {
                voisins.add(board.getCell(newX, newY));
            }
        }
    }

    return voisins;
}

    public Balloon cibler(Board board){
        ArrayList<Cell>cells=this.neighborhood(board);
        for(Cell c :cells){
            if(c.getValue()!=null){
                return c.getValue();
            }
        }
        return null;
    }
    public void tirer(Board b){
        Balloon b=cibler(board);
        b.takeDamage(projectile.getDamage());

    }
}