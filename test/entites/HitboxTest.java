 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites;

import java.awt.Dimension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites;

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


public class HitboxTest {
    
    public HitboxTest() {
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
     * Test of compareTo method, of class Hitbox.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Hitbox o = null;
        Hitbox instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Hitbox.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Hitbox instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Hitbox.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Hitbox instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Hitbox.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Hitbox instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Hitbox.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Hitbox instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getD method, of class Hitbox.
     */
    @Test
    public void testGetD() {
        System.out.println("getD");
        Hitbox instance = null;
        Dimension expResult = null;
        Dimension result = instance.getD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setD method, of class Hitbox.
     */
    @Test
    public void testSetD() {
        System.out.println("setD");
        Dimension d = null;
        Hitbox instance = null;
        instance.setD(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Hitbox.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Hitbox instance = null;
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
