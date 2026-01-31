package TowerDefence;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import TowerDefence.board.*;
public class CellTest {

    @Test
    public void testGetters() {
        Cell c = new Cell(new Position(2, 3));
        assertEquals(2, c.getPosition().getNbLigne());
        assertEquals(3, c.getPosition().getNbColonne());
    }

    @Test
    public void testEquals() {
        Cell c1 = new Cell(new Position(1, 1));
        Cell c2 = new Cell(new Position(1, 1));
        Cell c3 = new Cell(new Position(1, 2));

        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
}
