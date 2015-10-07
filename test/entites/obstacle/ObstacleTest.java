 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.obstacle;

import entites.Hitbox;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.obstacle;

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


public class ObstacleTest {
    
    public ObstacleTest() {
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
     * Test of getHight method, of class Obstacle.
     */
    @Test
    public void testGetHight() {
        System.out.println("getHight");
        Obstacle instance = null;
        int expResult = 0;
        int result = instance.getHight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHight method, of class Obstacle.
     */
    @Test
    public void testSetHight() {
        System.out.println("setHight");
        int hight = 0;
        Obstacle instance = null;
        instance.setHight(hight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Obstacle.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Obstacle instance = null;
        int expResult = 0;
        int result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class Obstacle.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 0;
        Obstacle instance = null;
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Obstacle.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Obstacle instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Obstacle.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Obstacle instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Obstacle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Obstacle instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Obstacle.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Obstacle instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class Obstacle.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Obstacle instance = null;
        Color expResult = null;
        Color result = instance.getC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setC method, of class Obstacle.
     */
    @Test
    public void testSetC() {
        System.out.println("setC");
        Color c = null;
        Obstacle instance = null;
        instance.setC(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidht method, of class Obstacle.
     */
    @Test
    public void testGetWidht() {
        System.out.println("getWidht");
        Obstacle instance = null;
        int expResult = 0;
        int result = instance.getWidht();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHb method, of class Obstacle.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        Obstacle instance = null;
        Hitbox expResult = null;
        Hitbox result = instance.getHb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addObstacle method, of class Obstacle.
     */
    @Test
    public void testAddObstacle() {
        System.out.println("addObstacle");
        Obstacle o = null;
        Obstacle.addObstacle(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListObstacle method, of class Obstacle.
     */
    @Test
    public void testAddListObstacle() {
        System.out.println("addListObstacle");
        Obstacle[] o = null;
        Obstacle.addListObstacle(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveObstacle() {
        System.out.println("removeObstacle");
        int i = 0;
        Obstacle.removeObstacle(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveAllObstacle() {
        System.out.println("removeAllObstacle");
        Obstacle.removeAllObstacle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllSpecifiedKindObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveAllSpecifiedKindObstacle() {
        System.out.println("removeAllSpecifiedKindObstacle");
        Obstacle o = null;
        Obstacle.removeAllSpecifiedKindObstacle(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ObstacleImpl extends Obstacle {

        public ObstacleImpl() {
            super(0, 0, 0, 0, null);
        }
    }
    
}
