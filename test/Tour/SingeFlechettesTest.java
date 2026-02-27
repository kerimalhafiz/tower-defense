package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;


public class SingeFlechettesTest {private Balloon b1;
    private Balloon b2;
    private Board board1;
    
    private Tour tour;
    


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,1,"b1");
        this.b2= new BasicBalloon(3,2,"b2");
        this.board1= new BoardOne(10,12);
        this.tour=new SingeFlechettes();
        

    }
    @Test
    public void SingeFlechettes_attributs_correct(){
        assertEquals("flechettes", tour.getprojectile().getName());
        assertEquals(1, tour.getprojectile().getDamage());
        assertEquals(100, tour.getPortee());
        assertEquals(1000, tour.getCadence());
        assertEquals(200, tour.getCout());
        assertEquals(3, tour.getEvolutions().size());
    }

    


    
}
