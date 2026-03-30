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
                        
                        disponibles.remove(e);
                    }
                    if (disponibles.isEmpty()  ){
                        e=null;
                    }else{
                    e = (Evolution) this.c.choose(
                            "Choisir une autre évolution (0 = terminer)", disponibles);}
                }
            }

            t = (Tour) this.c.choose(
                    "Choisir une autre tour à faire évoluer (0 = terminer)", p.towers);
        }
    }

    
    private void vendreEvolution(Player p) {

        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour.");
            return;
        }

        Tour t = (Tour) this.c.choose(
                "Choisir une tour dont vendre une évolution (0 = terminer)", p.towers);

        while (t != null) {
            ArrayList<Evolution> achetees = new ArrayList<>();
            for (Evolution e : t.getEvolutions()) {
                if (e.isbuy()) achetees.add(e);
            }
		
            if (achetees.isEmpty()) {
                System.out.println("Aucune évolution achetée sur cette tour.");
            } else {
                Evolution e = (Evolution) this.c.choose(
                        "Choisir une évolution à vendre (0 = annuler)", achetees);
                while (e != null) {
                    p.vendreEvolution(t, e);
                    achetees.remove(e);
                    if (!achetees.isEmpty()) {
                    e = (Evolution) this.c.choose(
                            "Autre évolution à vendre (0 = terminer)", achetees);}
                    else{
                    e=null;}
                }
            }

            t = (Tour) this.c.choose(
                    "Choisir une autre tour (0 = terminer)", p.towers);
        }
    }

   private void vendreTour(Player p, Board b) {

        if (p.towers.isEmpty()) {
            System.out.println("Vous n'avez aucune tour à vendre.");
            return;
        }

        Tour t = (Tour) this.c.choose(
                "Vendre une tour (0 = annuler) | Crédits : " + p.getCredits(),
                p.towers);

        while (t != null) {
            t.stopTir();
            p.vendre(t);  
            if (p.towers.isEmpty()){t=null;}
            else{t = (Tour) this.c.choose(
                    "Vendre une autre tour (0 = terminer) | Crédits : " + p.getCredits(),
                    p.towers);}
        }
    }






    public void play() {
    this.p = new Player();
    
    System.out.println(this.p);

    while (this.p.isAlive()) {
        System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
        System.out.println(this.p);

        this.achatTour(this.p, this.b);
        this.faireEvoluer(this.p);
        this.vendreTour(this.p, this.b);
        this.vendreEvolution(this.p);

        super.play();
        this.manche++;
    }

    System.out.println("\n=== Game Over — Plus de vies ! Tu as perdu hahahaha ===");
}




}
