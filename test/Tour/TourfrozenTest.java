package Tour;

import org.junit.jupiter.api.BeforeEach;

import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.Board;
import TowerDefence.board.BoardOne;
import TowerDefence.board.BoardTwo;

public class TourfrozenTest {

    private Balloon b1;
    private Balloon b2;
    private  Board board1;
    private  Board board2;


    @BeforeEach
    public void  before(){
        this.b1=new BasicBalloon(2, 1, "basic1");
        this.b2=new BasicBalloon(3, 4, "basic2");
        this.board1=new BoardOne(10, 12);
        this.board2=new BoardTwo(12, 12, 5);
    }
    




    
}
