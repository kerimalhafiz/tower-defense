package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;



public class GorilleTest {

    private Balloon b1;
    private Balloon b2;
    private Board board1;
    private Board board2;
    private Tour tour1;
    private Tour tour2;


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,2,"b1");
        this.b2= new BasicBalloon(3,1,"b2");
        this.board1= new BoardOne(10,10);
        this.board2= new BoardTwo(10,10,3);
        this.tour1=new Gorille();
        this.tour2= new Gorille();

    }

    @Test
    public void gorille_attributs_correct(){
        assertEquals("Gorille", tour1.getprojectile().getName());
        assertEquals(2, tour1.getprojectile().getDamage());
        assertEquals(200, tour1.getPortee());
        assertEquals(300, tour1.getCadence());
        assertEquals(1200, tour1.getCout());
        assertEquals(3, tour1.getEvolutions().size());
    }

   
    
}
