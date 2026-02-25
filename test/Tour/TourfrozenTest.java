package Tour;

import org.junit.jupiter.api.BeforeEach;

import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.Board;
import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;
import TowerDefence.tower.*;
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
    

    public void  frozenBalloontest_board(){
     
        ArrayList<Balloon> list=new  ArrayList<>();
        list.add(b1);
        list.add(b2);
        board1.addBalloon(list);
    

    }
 

    
}
