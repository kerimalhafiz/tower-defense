package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.listchooser.ListChooser;
import TowerDefence.listchooser.RandomListChooser;
import TowerDefence.tower.Evolution;
import TowerDefence.tower.Gorille;
import TowerDefence.tower.SingeFlechettes;
import TowerDefence.tower.SingeTireurElite;
import TowerDefence.tower.Tour;
import TowerDefence.tower.TourBombe;
import TowerDefence.tower.TourRballoon;
import TowerDefence.tower.TourelleAiguille;
import TowerDefence.tower.TourfrozenBalloon;
import java.util.ArrayList;

public class FinalGame extends Game{
    ListChooser c;
      ArrayList<Tour> catalogue;
          private int manche;
    public FinalGame(Board b,int n,ListChooser c){
        super(b, n);
        this.c = c;
        this.manche = 1;
    
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));
    }

    private void achatTour(Player p,Board b){

        Tour t=(Tour) this.c.choose("choisir une tour à acheter l indice 0 veut dire que vous n acheter plus", this.towers);
         while(t!=null){
        if (p.acheter(t)){
        p.towers.add(t);

        this.placerTour(t, b);}
        t=(Tour) this.c.choose("choisir une tour à acheter l indice 0 veut dire que vous n acheter plus", this.towers);
        
         }
    }

    private void placerTour(Tour t,Board b){
    
        Position position=(Position) this.c.choose("choisir une position placement de la grille",b.getAllPositions());
        while (position==null){
            b.putTower(t, position);
            position=(Position) this.c.choose("choisir une position placement de la grille",b.getAllPositions());
        }
    }

private void  FaireEvoluer(Player p){
Evolution e = null;
Tour t=(Tour) this.c.choose("choisir une tour a faire evoluer", p.towers);
while(t!=null){
    t=(Tour) this.c.choose("choisir une tour a faire evoluer", p.towers);
    if(t!=null){
    e=(Evolution) this.c.choose("choisir une evolution", t.getEvolutions());
     } while (e!=null){
        p.acheterEvolution(t, e);
        e=(Evolution) this.c.choose("choisir une evolution", t.getEvolutions());
    }
}






}
    public void Playerer(){
        Player p=new Player();
        this.achatTour(p, this.b);
        this.FaireEvoluer(p);
        super.play();
      return;

    }





}
