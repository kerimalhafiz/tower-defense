package TowerDefence;

import java.util.ArrayList;

import TowerDefence.Balloon.Balloon;
import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.tower.Evolution;
import TowerDefence.tower.Gorille;
import TowerDefence.tower.SingeFlechettes;
import TowerDefence.tower.SingeTireurElite;
import TowerDefence.tower.Tour;
import TowerDefence.tower.TourBombe;
import TowerDefence.tower.TourRballoon;
import TowerDefence.tower.TourelleAiguille;
import TowerDefence.tower.TourfrozenBalloon;

public class FinalGame extends Game{
    ListChooser c;
      ArrayList<Tour> towers;
    public FinalGame(Board b,int n,ListChooser c){
        super(b, n);
        this.c=c;
        this.towers = new ArrayList<>();

        // Creation of this.towers (two instances for several types)
        SingeFlechettes fleche = new SingeFlechettes();
        SingeTireurElite tireur = new SingeTireurElite();
        TourelleAiguille aiguille = new TourelleAiguille();
        Gorille gorille = new Gorille();
        TourBombe bombe = new TourBombe();
        TourRballoon ralentit = new TourRballoon(3);
        TourfrozenBalloon frozen = new TourfrozenBalloon(4);

        // Add this.towers to the list
        this.towers.add(fleche);
        this.towers.add(tireur);
        this.towers.add(aiguille);
        this.towers.add(bombe);
        this.towers.add(gorille);
        this.towers.add(frozen);
        this.towers.add(ralentit);

    }
    private void achatTour(Player p){

        Tour t=(Tour) this.c.choose("choisir une tour à acheter l indice 0 veut dire que vous n acheter plus", this.towers);
        p.acheter(t);;
         while(t!=null){
        t=(Tour) this.c.choose("choisir une tour à acheter l indice 0 veut dire que vous n acheter plus", this.towers);
        p.acheter(t);
        p.towers.add(t);
         }
    }

    public void Playerer(){
        Player p=new Player();
        Tour t;
        Tour t1;

        do{
        t=(Tour) this.c.choose("choisir une tour à acheter l indice 0 veut dire que vous n acheter plus", this.towers);
        p.acheter(t);
        Position position=(Position) this.c.choose("choisir une position placement de la grille",this.b.getAllPositions());
        this.b.putTower(t, position);
        t1=(Tour) this.c.choose("choisir une tour à faire Evoluer", p.towers);
        p.acheter(t);
        Evolution e=(Evolution) this.c.choose("choisir une evolution", t1.getEvolutions());
        p.acheter(t);
    }while(t!=null);

      return;




    }





}
