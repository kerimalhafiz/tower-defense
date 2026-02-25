package Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;
import TowerDefence.Balloon.*;
import java.util.*;
public class TourRalentitBalloonTest {
    private Balloon balloon1;
    private Balloon balloon2;
    private Board boardOne;
    private Board boardTwo;
    private Tour tower1;
    private Tour towe2;
    @BeforeEach
    public  void before(){
     this.balloon1=new BasicBalloon(2,2,"basic");
    }

    
}
