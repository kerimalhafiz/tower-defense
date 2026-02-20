package tower;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.Board;
import TowerDefence.board.Cell;


import TowerDefence.board.Position;

public abstract class Tour {

    protected Projectile projectile;
    protected int portee;
    protected int cadence;
    protected double cout;
    protected Position position;

    public Tour(Projectile projectile, int portee, int cadence, double cout, Position position) {
        this.projectile = projectile;
        this.portee = portee;
        this.cadence = cadence;
        this.cout = cout;
        this.position = position;
    }



    public Projectile getprojectile() {
        return this.projectile;
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

    protected ArrayList<Balloon> neighborhood(Board board) {
    ArrayList<Balloon> voisins = new ArrayList<>();

    for (int dx = -portee; dx <= portee; dx++) {
        for (int dy = -portee; dy <= portee; dy++) {
            int newX = this.position.getNbLigne() + dx;
            int newY = this.position.getNbColonne() + dy;

            if (newX >= 0 && newX < board.getNbLigne() &&
                newY >= 0 && newY < board.getNbColonne()) {
                if(board.getCell(newX, newY).getValue()!=null){
                    voisins.add(board.getCell(newX, newY).getValue());
            }
        }
    }

    return voisins;
}
}public abstract cibler(Board board){}
public abstract void tirer(Board b){}

    }
    public abstract void augmenterPortee();
    public abstract void augmenterCadence();
    public abstract void augmenterPuissance();

