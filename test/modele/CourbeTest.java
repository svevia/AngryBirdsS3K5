package modele;

import org.junit.Test;
import static org.junit.Assert.*;

public class CourbeTest {

    /**
     * Tout les test s'effectueront avec cette courbe, plutot realiste pour le
     * jeu
     */
    Courbe c = new Courbe(0, 1, 20, 5, 0.00009, 20);

    public CourbeTest() {
    }

    /**
     * Test of getXenT method, of class Courbe.
     */
    @Test
    public void testGetXenT() {
        int t = 5;
        assertEquals(c.getXenT(t), (0 * Math.pow(t, 2) + 1 * t + 20), 5);
        t = 10;
        assertEquals(c.getXenT(t), (0 * Math.pow(t, 2) + 1 * t + 20), 5);
        t = 100;
        assertEquals(c.getXenT(t), (0 * Math.pow(t, 2) + 1 * t + 20), 5);
    }

    /**
     * Test of getYenT method, of class Courbe.
     */
    @Test
    public void testGetYenT() {
        int t = 5;
        assertEquals(c.getYenT(t), (5 * Math.pow(t, 2) + 0.00009 * t + 20), 5);
        t = 10;
        assertEquals(c.getYenT(t), (5 * Math.pow(t, 2) + 0.00009 * t + 20), 5);
        t = 100;
        assertEquals(c.getYenT(t), (5 * Math.pow(t, 2) + 0.00009 * t + 20), 5);
    }

    /**
     * Test of calculDistance method, of class Courbe.
     */
    @Test
    public void testCalculDistance() {
        double x1 = 0, x2 = 50, y1 = 0, y2 = 50;
        assertEquals(Courbe.calculDistance(x1, y1, x2, y2), Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5), 5);
    }

    /**
     * Test of calculAngle method, of class Courbe.
     */
    @Test
    public void testCalculAngle() {
    }

    /**
     * Test of angleAenT method, of class Courbe.
     */
    @Test
    public void testAngleAenT() {
    }

}
