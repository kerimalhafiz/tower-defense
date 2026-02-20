package TowerDefence;
import TowerDefence.board.Board;
import TowerDefence.tower.*;

import java.util.ArrayList;
import java.util.Random;


public class Game1 extends Game {
    ArrayList<Tour> towers;
    public Game1(Board b,int n){
        super(b, n);
        
        //Que chacun de vous creer deux tours de ces tours et les ajoute a la liste towers s'il vous plait
        Random r=new Random();
        int x;
        int y;
        towers=new ArrayList<>();
        Gorille gorille=new Gorille();
        TourBombe bombe =new TourBombe();
        TourRballoon Ralentit=new TourRballoon(5.0);
        TourfrozenBalloon frozen=new TourfrozenBalloon(4);
        towers.add(bombe);
        towers.add(gorille);
        towers.add(frozen);
        towers.add(Ralentit);
        for(Tour t:this.towers){
       
            x=r.nextInt(this.b.getNbLigne());
            y=r.nextInt(this.b.getNbColonne());
            
            while(!(this.b.putTower(t,x,y))){
                x=r.nextInt(this.b.getNbLigne());
                y=r.nextInt(this.b.getNbColonne());
            }
        }
    }

    public void play(){

        for(Tour t:this.towers){
            t.startTir(this.b);

        }
        super.play();

        for(Tour t:this.towers){
            t.stopTir();

        }

        

    }}
