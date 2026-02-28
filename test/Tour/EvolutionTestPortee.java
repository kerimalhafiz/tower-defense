package Tour;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;
public class EvolutionTestPortee{
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new TourBombe();
        this.tour1= new TourBombe();
        this.evo= new EvolutionPortee(1.2,150);
    }
    
}