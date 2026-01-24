package test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import board.*;
public class BoardTest {
    @Test
    public void testBoardCreation(){
        Board board = new Board(10,10);
        assertEquals(10,board.getNbLigne());
        assertEquals(10,board.getNbColonne());
        Cell c = board.getCell(1,2);
        assertEquals(1,c.getX());
        assertEquals(2,c.getY());
        Cell c1 = board.getCell(3,0);
        assertEquals(3,c1.getX());
        assertEquals(0,c1.getY());
    }
    
}
