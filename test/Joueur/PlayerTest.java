package Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TowerDefence.Player;
import TowerDefence.tower.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Tour tour1;
    private Tour tour2;
    private Evolution evol1;
    private Evolution evol2;

    @BeforeEach
    public void before() {
        this.player = new Player();
        this.tour1 = new SingeFlechettes(); // coût 200
        this.tour2 = new Gorille(); // coût 1200
        this.evol1 = new EvolutionPortee(0.25, 100);
        this.evol2 = new EvolutionPuissance(1, 250);
    }

     @Test
    public void player_creditsInitiaux() {
        assertEquals(999999999, player.getCredits(), 0.001);
        assertEquals(205_555, player.getVie());
        assertTrue(player.towers.isEmpty());
    }

    @Test
    public void isAlive_vraiAvecDesVies() {
        assertTrue(player.isAlive());
    }

    @Test
    public void isAlive_fauxQuandViesZero() {
        player.diminueVieDe(player.getVie());
        assertFalse(player.isAlive());
    }

    @Test
    public void ajouterCredits_augmenteLeSolde() {
        double before = player.getCredits();
        player.ajouterCredits(500);
        assertEquals(before + 500, player.getCredits(), 0.001);
    }
    @Test
    public void ajouterCredits_montantNulNeChangePasLeSolde() {
        double before = player.getCredits();
        player.ajouterCredits(0);
        assertEquals(before, player.getCredits(), 0.001);
    }

    @Test
    public void diminueVieDe_reduitLesVies() {
        int before = player.getVie();
        player.diminueVieDe(3);
        assertEquals(before - 3, player.getVie());
    }

    @Test
    public void diminueVieDe_viesNePasDescendreSousZero() {
        player.diminueVieDe(player.getVie() + 9999);
        assertEquals(0, player.getVie());
    }

    @Test
    public void diminueVieDe_exactementZero() {
        player.diminueVieDe(player.getVie());
        assertEquals(0, player.getVie());
    }

    public void acheter_succes_retourneTrue() {
        assertTrue(player.acheter(tour1));
    }

    @Test
    public void acheter_succes_deduitLesCouts() {
        double before = player.getCredits();
        player.acheter(tour1);
        assertEquals(before - tour1.getCout(), player.getCredits(), 0.001);
    }

    @Test
    public void acheter_succes_ajouteLaTourDansLaListe() {
        player.acheter(tour1);
        assertTrue(player.towers.contains(tour1));
    }

     @Test
    public void acheter_echecSiCreditsInsuffisants() {
        player.setCredits(50);
        assertFalse(player.acheter(tour2)); // tour2 coûte 1200
    }

    @Test
    public void acheter_echecNeModifiePasLesCredits() {
        player.setCredits(50);
        player.acheter(tour2);
        assertEquals(50, player.getCredits(), 0.001);
    }

    @Test
    public void acheter_echecNAjoutePasDansLaListe() {
        player.setCredits(50);
        player.acheter(tour2);
        assertFalse(player.towers.contains(tour2));
    }


    @Test
    public void vendre_retourneTrue() {
        player.acheter(tour1);
        assertTrue(player.vendre(tour1));
    }

    @Test
    public void vendre_rembourseLesCouts() {
        player.acheter(tour1);
        double after = player.getCredits();
        player.vendre(tour1);
        assertEquals(after + tour1.getCout(), player.getCredits(), 0.001);
    }

    @Test
    public void vendre_supprimeLaTourDeLaListe() {
        player.acheter(tour1);
        player.vendre(tour1);
        assertFalse(player.towers.contains(tour1));
    }

    @Test
    public void vendre_rembourseAussiLesEvolutionsAchetees() {
        player.acheter(tour1);
        player.acheterEvolution(tour1, evol1); // évol achetée
        double after = player.getCredits();

        player.vendre(tour1);
        assertEquals(after + tour1.getCout() + evol1.getCout(), player.getCredits(), 0.001);
    }

    @Test
    public void vendre_nRemboursesPasLesEvolutionsNonAchetees() {
        player.acheter(tour1);
        // evol1 jamais achetée
        double after = player.getCredits();
        player.vendre(tour1);
        assertEquals(after + tour1.getCout(), player.getCredits(), 0.001);
    }


     @Test
    public void acheterEvolution_succes_retourneTrue() {
        player.acheter(tour1);
        assertTrue(player.acheterEvolution(tour1, evol1));
    }

    @Test
    public void acheterEvolution_succes_deduitLesCout() {
        player.acheter(tour1);
        double before = player.getCredits();
        player.acheterEvolution(tour1, evol1);
        assertEquals(before - evol1.getCout(), player.getCredits(), 0.001);
    }

    @Test
    public void acheterEvolution_succes_marqueEvolCommeAchetee() {
        player.acheter(tour1);
        player.acheterEvolution(tour1, evol1);
        assertTrue(evol1.isbuy());
    }

    @Test
    public void acheterEvolution_echecSiCreditsInsuffisants() {
        player.setCredits(10);
        assertFalse(player.acheterEvolution(tour1, evol2)); // evol2 coûte 250
    }

    @Test
    public void acheterEvolution_echecNeMarquePasCommeAchetee() {
        player.setCredits(10);
        player.acheterEvolution(tour1, evol2);
        assertFalse(evol2.isbuy());
    }



}
