package TowerDefence;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import board.*;
public class CellTest {

    @Test
    public void testGetters() {
        Cell c = new Cell(2, 3);
        assertEquals(2, c.getX());
        assertEquals(3, c.getY());
    }

    @Test
    public void testEquals() {
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(1, 1);
        Cell c3 = new Cell(2, 2);

        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
}
