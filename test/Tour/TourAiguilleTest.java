package Tour;
import org.junit.jupiter.api.*;

import TowerDefence.Balloon.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class TourAiguilleTest {
    private Balloon b1;
    private Balloon b2;
    private Board board1;
    
    private Tour tour;


    @BeforeEach
    public void before(){
        this.b1=new BasicBalloon(2,1,"b1");
        this.b2= new BasicBalloon(3,10,"b2");
        this.board1= new BoardOne(10,12);
        this.tour=new TourelleAiguille();

        

    }

    @Test
    public void TourelleAiguille_attributs_correct(){
        assertEquals("aiguille", tour.getprojectile().getName());
        assertEquals(1, tour.getprojectile().getDamage());
        assertEquals(80, tour.getPortee());
        assertEquals(1200, tour.getCadence());
        assertEquals(350, tour.getCout());
        assertEquals(2, tour.getEvolutions().size());
    }

    @Test
    public void tirer_un_seul_ballon(){
        ArrayList<Balloon> l= new ArrayList<>();
        l.add(b1);
        
        board1.addBalloon(l);
        tour.setPosition(new Position(0, 0));
        board1.getCell(0,0).setvalueX(b1);
        int resistance = b1.getResistance();
        tour.tirer(board1);
        assertTrue(b1.getResistance() < resistance );
    }

    

}
