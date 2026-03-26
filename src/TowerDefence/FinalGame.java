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


    private void achatTour(Player p, Board b) {
        int achatsEffectues = 0;
        Tour t = (Tour) this.c.choose(
                "Acheter une tour (0 = terminer) | Crédits : " + p.getCredits(),
                this.catalogue);

        while (t != null  ) {
            if (p.acheter(t)) {
                p.towers.add(t);
                this.placerTour(t, b);
                achatsEffectues++;
            }
            t = (Tour) this.c.choose(
                    "Acheter une tour (0 = terminer) | Crédits : " + p.getCredits(),
                    this.catalogue);
        }
    }
    private void placerTour(Tour t, Board b) {
        Position position = (Position) this.c.choose(
                "Choisir une case pour placer la tour", b.getAllPositions());

        while (position == null) {
            position = (Position) this.c.choose(
                    "Position invalide — choisir une case :", b.getAllPositions());
        }
        b.putTower(t, position);
    }

    private void faireEvoluer(Player p) {
        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour à faire évoluer.");
            return;
        }

        int evolutionsEffectuees = 0;
        
        Tour t = (Tour) this.c.choose(
                "Choisir une tour à faire évoluer (0 = terminer)", p.towers);

        while (t != null ) {

            ArrayList<Evolution> disponibles = new ArrayList<>();
            for (Evolution e : t.getEvolutions()) {
                if (!e.isbuy()) disponibles.add(e);
            }

            if (disponibles.isEmpty()) {
                System.out.println(t.getClass().getSimpleName()
                        + " : aucune évolution disponible.");
            } else {
                Evolution e = (Evolution) this.c.choose(
                        "Choisir une évolution (0 = annuler)", disponibles);

                while (e != null ) {
                    if (p.acheterEvolution(t, e)) {
                        evolutionsEffectuees++;
                        disponibles.remove(e);
                    }
                    if (disponibles.isEmpty()  ) break;
                    e = (Evolution) this.c.choose(
                            "Choisir une autre évolution (0 = terminer)", disponibles);
                }
            }

            t = (Tour) this.c.choose(
                    "Choisir une autre tour à faire évoluer (0 = terminer)", p.towers);
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
