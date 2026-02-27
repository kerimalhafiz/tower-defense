package Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TowerDefence.board.*;
import TowerDefence.tower.*;
import TowerDefence.Balloon.*;

import java.beans.Transient;
import java.util.*;
public class EvolutionTest {
    @Test
    public void testConstructeur(){
        Evolution e = new EvolutionCadence(0.25,150);
        //assertEquals("portee",e.getNom());
        assertEquals(150,e.getCout());
        assertFalse(e.isbuy());

    }
    @Test
    public void testAcheter(){
        Evolution e1 = new EvolutionCadence(0.25,200);
        assertFalse(e1.isbuy());
        e1.buy();
        assertTrue(e1.isbuy());
    }
    @Test
    public void testGetCout(){
        Evolution e2 = new EvolutionPuissance(2,300);
        //assertEquals(300,e2.getCout());
    }
    @Test
    public void testGetNom(){
        Evolution e3 = new EvolutionProjectile(new Projectile("projectile", 3),100);
        //assertEquals("projectile",e3.getNom());
    }

}
