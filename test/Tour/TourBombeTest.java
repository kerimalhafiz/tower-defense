package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;


public class TourBombeTest {
    private Balloon b1;
    private Balloon b2;
    private Board board1;
    
    private Tour tour;
    


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,2,"b1");
        this.b2= new BasicBalloon(3,1,"b2");
        this.board1= new BoardOne(10,10);
        this.tour=new TourBombe();
        

    }

    @Test
    public void TourBombe_attributs_correct(){
        assertEquals("TourBombe", tour.getprojectile().getName());
        assertEquals(2, tour.getprojectile().getDamage());
        assertEquals(150, tour.getPortee());
        assertEquals(1800, tour.getCadence());
        assertEquals(600, tour.getCout());
        assertEquals(4, tour.getEvolutions().size());
    }


    

    
    
}
