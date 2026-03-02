package pathsT;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TowerDefence.board.*;
import TowerDefence.paths.*;

import java.util.ArrayList;

public class PathTwoTest {
    PathTwo path;
    BoardTwo board ;
    @BeforeEach
    public void before(){

    board = new BoardTwo(8, 6, 1);
     path = new PathTwo();


    }

    @Test
    public void testPathTwoCreatesStraightPath() {
       
        // Generate the path
        ArrayList<Position> result = path.findPath(board.getBoard());

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // 2. Check if path is straight (same row OR same column)
        int x0 = result.get(0).getNbLigne();
        int y0 = result.get(0).getNbColonne();

        boolean sameRow = true;
        boolean sameColumn = true;

        for (Position p : result) {
            if (p.getNbLigne() != x0) sameRow = false;
            if (p.getNbColonne() != y0) sameColumn = false;
        }

        assertTrue(sameRow || sameColumn, "Path must be horizontal or vertical");

        for (Position p : result) {
            Cell c = board.getCell(p.getNbLigne(), p.getNbColonne());
            assertEquals(".", c.toString());
        }
    }
}
