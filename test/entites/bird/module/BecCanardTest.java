 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird.module;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird.module;

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


public class BecCanardTest {
    
    public BecCanardTest() {
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
     * Test of draw method, of class BecCanard.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        BecCanard instance = null;
        Graphics expResult = null;
        Graphics result = instance.draw(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLargeur method, of class BecCanard.
     */
    @Test
    public void testGetLargeur() {
        System.out.println("getLargeur");
        BecCanard instance = null;
        double expResult = 0.0;
        double result = instance.getLargeur();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class BecCanard.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        BecCanard instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
