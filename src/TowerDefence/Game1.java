package TowerDefence;
import TowerDefence.*;
import java.util.ArrayList;
import java.util.Random;

import TowerDefence.board.Board;
import TowerDefence.tower.Tour;

public class Game1 extends Game {
    public Game1(Board b,int n){
        super(b, n);
    }

    public void play(){
        super.play();
        ArrayList<Tour> towers;
        //Que chacun de vous creer deux tours de ces tours et les ajoute a la liste towers s'il vous plait
        Random r=new Random();
        int x;
        int y;
        for(Tower t:towers){
            x=r.nextInt(this.b.getNbLigne());
            y=r.nextInt(this.b.getNbColonne());
            
            while(!(this.b.putTower(t,x,y))){
                x=r.nextInt(this.b.getNbLigne());
                y=r.nextInt(this.b.getNbColonne());
            }
        }

    }}
