 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites;

import java.awt.Graphics;
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


public class EntityTest {
    
    public EntityTest() {
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
     * Test of getX method, of class Entity.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Entity instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Entity.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Entity instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Entity.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Entity instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Entity.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Entity instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHight method, of class Entity.
     */
    @Test
    public void testGetHight() {
        System.out.println("getHight");
        Entity instance = null;
        int expResult = 0;
        int result = instance.getHight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHight method, of class Entity.
     */
    @Test
    public void testSetHight() {
        System.out.println("setHight");
        int hight = 0;
        Entity instance = null;
        instance.setHight(hight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidht method, of class Entity.
     */
    @Test
    public void testGetWidht() {
        System.out.println("getWidht");
        Entity instance = null;
        int expResult = 0;
        int result = instance.getWidht();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidht method, of class Entity.
     */
    @Test
    public void testSetWidht() {
        System.out.println("setWidht");
        int widht = 0;
        Entity instance = null;
        instance.setWidht(widht);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHb method, of class Entity.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        Entity instance = null;
        Hitbox expResult = null;
        Hitbox result = instance.getHb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHb method, of class Entity.
     */
    @Test
    public void testSetHb() {
        System.out.println("setHb");
        Hitbox hb = null;
        Entity instance = null;
        instance.setHb(hb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Entity.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Entity instance = null;
        Graphics expResult = null;
        Graphics result = instance.draw(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EntityImpl extends Entity {

        public EntityImpl() {
            super(0, 0, 0, 0);
        }

        public Graphics draw(Graphics g) {
            return null;
        }
    }
    
}
