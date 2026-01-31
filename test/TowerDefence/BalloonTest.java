package test;
import board.*;
import java.util.*;
import Balloons.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BalloonTest {
    
  @Test
    public void testInitialState() {
        BalloonRfor b = new BalloonRfor(0.5f, 4);

        assertEquals(0, b.getcurrentPathIndex());
        assertEquals(0.0f, b.getprogress(), 0.0001);
    }

    @Test
    public void testMoveInsideCell() {
        BalloonRfor b = new BalloonRfor(0.25f, 4);

        ArrayList<Position> path = new ArrayList<>();
        path.add(new Position(0, 0));
        path.add(new Position(0, 1));

        b.move(path);

        assertEquals(0, b.getcurrentPathIndex());
        assertTrue(b.getprogress() > 0);
        assertTrue(b.getprogress() < 1);
    }

    @Test
    public void testMoveToNextCell() {
        BalloonRfor b = new BalloonRfor(1.0f, 4);

        ArrayList<Position> path = new ArrayList<>();
        path.add(new Position(0, 0));
        path.add(new Position(0, 1));

        b.move(path);

        assertEquals(1, b.getcurrentPathIndex());
        assertTrue(b.getprogress() < 1);
    }

    @Test
    public void testMultipleMoves() {
        BalloonRfor b = new BalloonRfor(0.5f, 4);

        ArrayList<Position> path = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            path.add(new Position(0, i));
        }

        for (int i = 0; i < 10; i++) {
            b.move(path);
        }

        assertTrue(b.getcurrentPathIndex() > 0);
        assertTrue(b.getcurrentPathIndex() <= path.size());
    }

    @Test
    public void testEndOfPath() {
        BalloonRfor b = new BalloonRfor(2.0f, 4);

        ArrayList<Position> path = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            path.add(new Position(0, i));
        }

        for (int i = 0; i < 10; i++) {
            b.move(path);
        }

        assertEquals(path.size(), b.getcurrentPathIndex());
        assertEquals(1.0f, b.getprogress(), 0.0001);
    }
}