package board;

public class Position {
    private int ligne;
    private int colonne;
    public Position(int x,int y){
        this.colonne=y;
        this.ligne=x;

    }
    public int getNbLigne(){return this.ligne;}
    public int getNbColonne(){return this.colonne;}

    @Override
    public String toString() {
    return "Position(" + this.ligne + "," + this.colonne + ")";
}


}
