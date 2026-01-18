package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Cell;
public class CellTest {

    @Test
    public void testCellCreation() {
        Cell c = new Cell(2, 3);

        assertEquals(2, c.getX());
        assertEquals(3, c.getY());
        assertFalse(c.estChemin());
    }

    @Test
    public void testEquals() {
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(1, 1);
        Cell c3 = new Cell(2, 1);

        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
}
