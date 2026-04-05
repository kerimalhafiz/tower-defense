package TowerDefence;

import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
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
        Player p;
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
    } ; 
    @Override
    public void createBalloons() {
        this.listeBallon = new ArrayList<>();
        float vitesse = this.manche  +0.5f;

        for (int i = 1; i <= this.n; i++) {
            Balloon ballon;
            String id = "Ballon-M" + this.manche + "-" + i;
 
                ballon = new BasicBalloon(vitesse, this.manche,id);    // resistance 4

            this.listeBallon.add(ballon);
        }

        System.out.println("\n=== Manche " + this.manche
                + " — " + this.n + " ballons générés ===");
    }









    public void play() {


        System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
        System.out.println(this.p);

     

        super.play();
        this.manche++;
    


}




}
