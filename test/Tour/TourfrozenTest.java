package Tour;

import org.junit.jupiter.api.BeforeEach;

import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.*;

import TowerDefence.tower.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class TourfrozenTest {

    private Balloon b1;
    private Balloon b2;
    private  Board board1;
    private  Board board2;
    private Tour T1;
    private Tour T2;


    @BeforeEach
    public void  before(){
        this.b1=new BasicBalloon(2, 1, "basic1");
        this.b2=new BasicBalloon(3, 4, "basic2");
        this.board1=new BoardOne(10, 12);
        this.board2=new BoardTwo(12, 12, 5);
        this.T1=new TourfrozenBalloon(3);
    }
    

    /**
     * 
     */
    public void  frozenBalloontest_board(){
     
        ArrayList<Balloon> list=new  ArrayList<>();
        list.add(b1);
        list.add(b2);
        board1.addBalloon(list);
        T1.setPosition(new Position(0, 0) );
    
        board1.getCell(0, 0).setvalueX(b1);
        assertFalse(b1.isFrozen());
        T1.tirer(board1);
        //le ballon doit etre ggele 
        assertTrue(b1.isFrozen());


    }
 

    
}
