package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * version final du jeu 
 */
public class FinalGame extends Game {

    ListChooser c;
    ArrayList<Tour> catalogue;
    private int manche;
    ArrayList<Choice> actions;
    /**
     * cree une partie finale du jeu 
     * @param b le plateau de jeu
     * @param n le nombre de manche du jeu
     * @param c le listchooser utilisé pour realiser  un choix du joueur
     */
    public FinalGame(Board b, int n, ListChooser c) {
        super(b, n);
        this.c = c;
        this.manche = 1;

        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));
        this.catalogue.add(new TourRballoon(3));

        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer());
    }

    private void phaseAchat(Player p, Board b) {
        Choice choix = (Choice) this.c.choose(
                "Que voulez-vous faire ? | Crédits : " + p.getCredits(),
                this.actions);

        while (!(choix instanceof Jouer)) {
            choix.apply(p, b);
            choix = (Choice) this.c.choose(
                    "Autre action ? | Crédits : " + p.getCredits(),
                    this.actions);
        }
    }

    private void achatManche1(int n) {
        if (n == 1) {
            Random rand = new Random();
            for (Tour t : this.catalogue) {
                this.p.acheter(t);
                int x = rand.nextInt(this.b.getNbLigne());
                int y = rand.nextInt(this.b.getNbColonne());
                this.b.putTower(t, new Position(x, y));
                System.out.println("Tour achetée : " + t.getClass().getSimpleName());
            }
        }
    }

    private void mancheUnCinq(int n) {
        if (n >= 1 && n <= 5) {
            ArrayList<Tour> liste = this.p.towers;
            ArrayList<Tour> listeEvo = new ArrayList<>();
            for (Tour t : liste) {
                if (!t.getEvolutions().isEmpty()) {
                    listeEvo.add(t);
                }
            }

            // garde : aucune tour ne peut évoluer
            if (listeEvo.isEmpty()) {
                System.out.println("Aucune évolution disponible à la manche " + n);
                return;
            }

            Random rand = new Random();
            Tour t = listeEvo.get(rand.nextInt(listeEvo.size()));
            ArrayList<Evolution> evolutions = t.getEvolutions();
            Evolution e = evolutions.get(rand.nextInt(evolutions.size()));
            this.p.acheterEvolution(t, e);
            System.out.println("Evolution achetée : " + e.toString()
                    + " pour la tour " + t.toString()
                    + " à la manche " + n);
        }
    }

    private void mancheSixDix(int n) {
        if (n >= 6 && n <= 10) {
            ArrayList<Tour> liste = this.p.towers;
            ArrayList<Tour> listeEvo = new ArrayList<>();
            for (Tour t : liste) {
                ArrayList<Evolution> evolutions = t.getEvolutions();
                for (Evolution e : evolutions) {
                    if (e.isbuy()) {
                        listeEvo.add(t);
                        break; // évite d'ajouter la même tour plusieurs fois
                    }
                }
            }

            // garde : aucune évolution achetée à vendre
            if (listeEvo.isEmpty()) {
                System.out.println("Aucune évolution à vendre à la manche " + n);
                return;
            }

            Random rand = new Random();
            Tour t = listeEvo.get(rand.nextInt(listeEvo.size()));
            ArrayList<Evolution> disponibles = new ArrayList<>();
            for (Evolution e : t.getEvolutions()) {
                if (e.isbuy()) disponibles.add(e);
            }

            // garde supplémentaire
            if (disponibles.isEmpty()) return;

            Evolution e = disponibles.get(rand.nextInt(disponibles.size()));
            this.p.vendreEvolution(t, e);
            System.out.println("Evolution vendue : " + e.toString()
                    + " pour la tour " + t.toString()
                    + " à la manche " + n);
        }
    }

    public void play() {
        System.out.println(this.p);

        while (this.p.isAlive() && this.manche <= 10) {
            System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
            this.achatManche1(this.manche);
            this.mancheUnCinq(this.manche);
            this.mancheSixDix(this.manche);
            super.play();
            this.manche++;
        }

        System.out.println("\n=== Game Over — Plus de vies ! Tu as perdu hahahaha ===");
    }
}
