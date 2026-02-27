package Tour;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.tower.*;

public class EvoPuissanceTest {
    private Tour tour;
    private Tour tour1;
    private Evolution evo;

    @BeforeEach
    public void before(){
        this.tour=new SingeFlechettes();
        this.tour1= new SingeFlechettes();
        this.evo= new EvolutionPuissance(1,250);
    }

    
    
}
