 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import entites.Hitbox;
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


public class BirdTest {
    
    public BirdTest() {
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
     * Test of MinimalBirdFactory method, of class Bird.
     */
    @Test
    public void testGetGraphic() {
        System.out.println("getGraphic");
        Graphics g = null;
        Bird instance = null;
        Graphics expResult = null;
        Graphics result = instance.MinimalBirdFactory(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getA method, of class Bird.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        Bird instance = null;
        double expResult = 0.0;
        double result = instance.getA();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setA method, of class Bird.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        double a = 0.0;
        Bird instance = null;
        instance.setA(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getR method, of class Bird.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        Bird instance = null;
        int expResult = 0;
        int result = instance.getR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHb method, of class Bird.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        Bird instance = null;
        Hitbox expResult = null;
        Hitbox result = instance.getHb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCorps method, of class Bird.
     */
    @Test
    public void testSetCorps() {
        System.out.println("setCorps");
        Color corps = null;
        Bird instance = null;
        instance.setCorps(corps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosX method, of class Bird.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Bird instance = null;
        int expResult = 0;
        int result = instance.getPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosX method, of class Bird.
     */
    @Test
    public void testSetPosX() {
        System.out.println("setPosX");
        int posX = 0;
        Bird instance = null;
        instance.setPosX(posX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosY method, of class Bird.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Bird instance = null;
        int expResult = 0;
        int result = instance.getPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosY method, of class Bird.
     */
    @Test
    public void testSetPosY() {
        System.out.println("setPosY");
        int posY = 0;
        Bird instance = null;
        instance.setPosY(posY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirdCenterX method, of class Bird.
     */
    @Test
    public void testGetBirdCenterX() {
        System.out.println("getBirdCenterX");
        Bird instance = null;
        int expResult = 0;
        int result = instance.getBirdCenterX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirdCenterX method, of class Bird.
     */
    @Test
    public void testSetBirdCenterX() {
        System.out.println("setBirdCenterX");
        int birdCenterX = 0;
        Bird instance = null;
        instance.setBirdCenterX(birdCenterX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirdCenterY method, of class Bird.
     */
    @Test
    public void testGetBirdCenterY() {
        System.out.println("getBirdCenterY");
        Bird instance = null;
        int expResult = 0;
        int result = instance.getBirdCenterY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirdCenterY method, of class Bird.
     */
    @Test
    public void testSetBirdCenterY() {
        System.out.println("setBirdCenterY");
        int birdCenterY = 0;
        Bird instance = null;
        instance.setBirdCenterY(birdCenterY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BirdImpl extends Bird {

        public BirdImpl() {
            super(0, 0, 0, 0, 0, 0, 0.0, 0.0, null, null, null);
        }
    }

    /**
     * Test of MinimalBirdFactory method, of class Bird.
     */
    @Test
    public void testMinimalBirdFactory() {
        System.out.println("MinimalBirdFactory");
        Graphics g = null;
        Bird instance = null;
        Graphics expResult = null;
        Graphics result = instance.MinimalBirdFactory(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawAllModule method, of class Bird.
     */
    @Test
    public void testDrawAllModule() {
        System.out.println("drawAllModule");
        Graphics g = null;
        boolean over = false;
        Bird instance = null;
        Graphics expResult = null;
        Graphics result = instance.drawAllModule(g, over);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addModule method, of class Bird.
     */
    @Test
    public void testAddModule() {
        System.out.println("addModule");
        ModuleBird mb = null;
        Bird instance = null;
        instance.addModule(mb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BirdImpl extends Bird {

        public BirdImpl() {
            super(0, 0, 0, 0, null);
        }
    }
    
}
