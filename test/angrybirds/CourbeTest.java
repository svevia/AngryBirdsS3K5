package angrybirds;

import org.junit.Test;
import static org.junit.Assert.*;

public class CourbeTest {

    Courbe c1 = new Courbe(20, 40, 0);
    Courbe c2 = new Courbe(-20, -40, 0);

    /**
     * Test of getYenX method, of class Courbe.
     */
    @Test
    public void testGetYenX() {
        int x = 5;
        assertTrue(c1.getYenX(x) == (20 * Math.pow(x, 2) + 40 * x + 0));
        assertTrue(c2.getYenX(x) == (-20 * Math.pow(x, 2) + -40 * x + 0));
    }



    /**
     * Test of distanceEntreDeuxPoints method, of class Courbe.
     */
    @Test
    public void testDistanceEntreDeuxPoints() {
        double x1 = 2;
        double x2 = 3;
        double y1 = 1;
        double y2 = 1;
        double expResult = 1;
        double result = c1.distanceEntreDeuxPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getA method, of class Courbe.
     */
    @Test
    public void testGetA() {
        double expResult = 20;
        double result = c1.getA();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getB method, of class Courbe.
     */
    @Test
    public void testGetB() {
        double expResult = 40;
        double result = c1.getB();
        assertEquals(expResult, result, 0.0);
    }

}
