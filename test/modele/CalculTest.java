package modele;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import static modele.Calcul.*;

/**
 *
 * @author Wissam
 */


public class CalculTest {
    
    public CalculTest() {
    }

    /**
     * Test of force method, of class Calcul.
     */
    @Test
    public void testForce() {
        Random r = new Random();
        int f, d;

        // 1er test normal, rayon 100, distance centre-souris > 100
        f = force(0, 0, 200, 200, 100);
        assertEquals(f, 100);
        // 2e test avec un rayon de 0, il doit renvoyer 100 dans tout les cas
        f = force(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt(), 0);
        assertEquals(f, 100);
        // 3e test avec un grand rayon, le rayon doit être la valeur obtenue  
        // divisé par la distance centre-souris
        d = (int)Courbe.calculDistance(0, 0, 500, 500);
        f = force(0, 0, 500, 500, 10000);
        assertEquals(10000/d, f);
    }

    /**
     * Test of angle method, of class Calcul.
     */
    @Test
    public void testAngle() {
        // L'angle doit sortir un angle en radian a partir de deux points
        double a;
        
        
        // 1er test avec un angle null
        a = angle(0, 0, 0, 0);
        assertEquals(0, a, 4);
        
        // 2e test avec un angle a 90°
        a = angle(0, 0, 2, 2);
        assertEquals(Math.PI, a, 3);   
    }

    /**
     * Test of addition method, of class Calcul.
     */
    @Test
    public void testAddition() {
        int[] tab = {1, 2, 3, 4, 5};
        int[] tabplusdeux = {3, 4, 5, 6, 7};
        
        // Test une simple addition
        for (int i = 0; i < tab.length; i++) {
            assertEquals(addition(tab, 2)[i], tabplusdeux[i]);
        }
    }

    /**
     * Test of calculCourbe method, of class Calcul.
     */
    @Test
    public void testCalculCourbe() {
    }
    
}
