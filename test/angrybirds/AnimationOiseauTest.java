 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package angrybirds;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
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


public class AnimationOiseauTest {
    
    public AnimationOiseauTest() {
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
     * Test of start method, of class AnimationOiseau.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        AnimationOiseau instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arret method, of class AnimationOiseau.
     */
    @Test
    public void testArret() {
        System.out.println("arret");
        AnimationOiseau instance = null;
        instance.arret();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class AnimationOiseau.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        AnimationOiseau instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourbe method, of class AnimationOiseau.
     */
    @Test
    public void testGetCourbe() {
        System.out.println("getCourbe");
        AnimationOiseau instance = null;
        Courbe expResult = null;
        Courbe result = instance.getCourbe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCore method, of class AnimationOiseau.
     */
    @Test
    public void testGetCore() {
        System.out.println("getCore");
        AnimationOiseau instance = null;
        Thread expResult = null;
        Thread result = instance.getCore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
