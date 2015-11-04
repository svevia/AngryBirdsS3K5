 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

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


public class ModuleBirdTest {
    
    public ModuleBirdTest() {
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
     * Test of getDistanceCentre method, of class ModuleBird.
     */
    @Test
    public void testGetDistanceCentre() {
        System.out.println("getDistanceCentre");
        ModuleBird instance = null;
        double expResult = 0.0;
        double result = instance.getDistanceCentre();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDistanceCentre method, of class ModuleBird.
     */
    @Test
    public void testSetDistanceCentre() {
        System.out.println("setDistanceCentre");
        double distanceCentre = 0.0;
        ModuleBird instance = null;
        instance.setDistanceCentre(distanceCentre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class ModuleBird.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        ModuleBird instance = null;
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOver method, of class ModuleBird.
     */
    @Test
    public void testSetOver() {
        System.out.println("setOver");
        boolean over = false;
        ModuleBird instance = null;
        instance.setOver(over);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class ModuleBird.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        ModuleBird instance = null;
        Graphics expResult = null;
        Graphics result = instance.draw(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ModuleBird.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModuleBird instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ModuleBirdImpl extends ModuleBird {

        public ModuleBirdImpl() {
            super(0.0, null, false);
        }

        public Graphics draw(Graphics g) {
            return null;
        }

        public int getSize() {
            return 0;
        }
    }
    
}
