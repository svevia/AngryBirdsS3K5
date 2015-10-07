 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import java.awt.Color;
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


public class FootstepTest {
    
    public FootstepTest() {
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
     * Test of values method, of class Footstep.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Footstep[] expResult = null;
        Footstep[] result = Footstep.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Footstep.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Footstep expResult = null;
        Footstep result = Footstep.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class Footstep.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Footstep instance = null;
        Color[] expResult = null;
        Color[] result = instance.getC();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFootstep method, of class Footstep.
     */
    @Test
    public void testDrawFootstep() {
        System.out.println("drawFootstep");
        int part = 0;
        Graphics g = null;
        Footstep instance = null;
        Graphics expResult = null;
        Graphics result = instance.drawFootstep(part, g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawAllFootstep method, of class Footstep.
     */
    @Test
    public void testDrawAllFootstep() {
        System.out.println("drawAllFootstep");
        Graphics g = null;
        Footstep instance = null;
        Graphics expResult = null;
        Graphics result = instance.drawAllFootstep(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
