package Player;
import org.junit.jupiter.api.*;

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
        this.tour1 = new SingeFlechettes();    // coût 200   
        this.tour2 = new Gorille(); // coût 1200
        this.evol1 = new EvolutionPortee(0.25, 100);
        this.evol2 = new EvolutionPuissance(1, 250);
    }

    
}
