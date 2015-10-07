 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import java.awt.Image;
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


public class FondTest {
    
    public FondTest() {
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
     * Test of values method, of class Fond.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Fond[] expResult = null;
        Fond[] result = Fond.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Fond.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Fond expResult = null;
        Fond result = Fond.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFond method, of class Fond.
     */
    @Test
    public void testGetFond() {
        System.out.println("getFond");
        Fond instance = null;
        Image expResult = null;
        Image result = instance.getFond();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
