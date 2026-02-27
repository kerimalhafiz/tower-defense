package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;


public class SingeTireurEliteTest {
    private Balloon b1;
    private Balloon b2;
    private Board board1;
    
    private Tour tour;


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,1,"b1");
        this.b2= new BasicBalloon(3,10,"b2");
        this.board1= new BoardOne(10,12);
        this.tour=new SingeTireurElite();
        

    }

    @Test
    public void SingeTireurElite_attributs_correct(){
        assertEquals("flechette tres pointue", tour.getprojectile().getName());
        assertEquals(4, tour.getprojectile().getDamage());
        assertEquals(10000, tour.getPortee());
        assertEquals(2000, tour.getCadence());
        assertEquals(500, tour.getCout());
        assertEquals(2, tour.getEvolutions().size());
    }


    





}
