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
        SingeFlechettes fleche = new SingeFlechettes();
        SingeFlechettes fleche1 = new SingeFlechettes();
        SingeTireurElite tireur = new SingeTireurElite();
        SingeTireurElite tireur1 = new SingeTireurElite();
        TourelleAiguille aiguille = new TourelleAiguille();
        TourelleAiguille aiguille1 = new TourelleAiguille();
        Gorille gorille=new Gorille();
        TourBombe bombe =new TourBombe();
        TourRballoon Ralentit=new TourRballoon(5.0);
        TourfrozenBalloon frozen=new TourfrozenBalloon(4);
         TourRballoon Ralentit2=new TourRballoon(9.0);
        TourfrozenBalloon frozen2=new TourfrozenBalloon(9);
        towers.add(fleche);
        towers.add(fleche1);
        towers.add(tireur);
        towers.add(tireur1);
        towers.add(aiguille);
        towers.add(aiguille1);
        towers.add(bombe);
        towers.add(gorille);
        towers.add(frozen);
        towers.add(Ralentit);
         towers.add(frozen2);
        towers.add(Ralentit2);
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
