 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package angrybirds;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wissam
 */


public class CourbeTest {
    
    public CourbeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getYenX method, of class Courbe.
     */
    @Test
    public void testGetYenX() {
        System.out.println("getYenX");
        int x = 0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.getYenX(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoefficientDirecteur method, of class Courbe.
     */
    @Test
    public void testGetCoefficientDirecteur() {
        System.out.println("getCoefficientDirecteur");
        int x = 0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.getCoefficientDirecteur(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoefficientDirecteurY method, of class Courbe.
     */
    @Test
    public void testGetCoefficientDirecteurY() {
        System.out.println("getCoefficientDirecteurY");
        int x = 0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.getCoefficientDirecteurY(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of angleNext method, of class Courbe.
     */
    @Test
    public void testAngleNext() {
        System.out.println("angleNext");
        int x = 0;
        Courbe instance = null;
        double expResult = 0.0;
        double result = instance.angleNext(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
