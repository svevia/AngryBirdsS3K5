package angrybirds;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wissam
 */


public class CourbeTest {

    Courbe c1 = new Courbe(20, 40, 0);
    Courbe c2 = new Courbe(-20, -40, 0);

    /**
     * Test of getYenX method, of class Courbe.
     */
    @Test
    public void testGetYenX() {
        System.out.println("Test la fonction du second degré");
        int x = 5;
        assertTrue(c1.getYenX(x) == (20 * Math.pow(x, 2) + 40 * x + 0));
        assertTrue(c2.getYenX(x) == (-20 * Math.pow(x, 2) + -40 * x + 0));
    }

    /**
     * Test of angleNextD method, of class Courbe.
     */
    @Test
    public void testAngleNextD() {
        System.out.println("Test l'obtention de l'angle");
        int x = 0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.angleNextD(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distanceEntreDeuxPoints method, of class Courbe.
     */
    @Test
    public void testDistanceEntreDeuxPoints() {
        System.out.println("distanceEntreDeuxPoints");
        double x1 = 0.0;
        double x2 = 0.0;
        double y1 = 0.0;
        double y2 = 0.0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.distanceEntreDeuxPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getA method, of class Courbe.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.getA();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getB method, of class Courbe.
     */
    @Test
    public void testGetB() {
        System.out.println("getB");
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.getB();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
