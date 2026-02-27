package Tour;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;
public class EvolutionTestCadence {
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new TourelleAiguille();
        this.tour1= new TourelleAiguille();
        this.evo= new EvolutionCadence(0.75,200);
    }
    @Test
    public void appliquer_Evo_reduire_cadence(){
        int res= tour.getCadence();
        int res1= tour1.getCadence();
        evo.appliquer(tour);
        //verifie que la cadence est reduite
        assertEquals((int)(res*0.75), tour.getCadence());
        // verfie que tour1 reste inchanger car pas d'evo appliquer
        assertEquals(res1, tour1.getCadence());
    }
}
