 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package angrybirds;

import entites.Entity;
import java.awt.Color;
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
import static org.junit.Assert.*;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
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


public class VisualisateurTest {
    
    public VisualisateurTest() {
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
     * Test of drawOiseau method, of class Visualisateur.
     */
    @Test
    public void testDrawOiseau() {
        System.out.println("drawOiseau");
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawOiseau(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFootstep method, of class Visualisateur.
     */
    @Test
    public void testDrawFootstep() {
        System.out.println("drawFootstep");
        boolean full = false;
        int part = 0;
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawFootstep(full, part, g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawObstacle method, of class Visualisateur.
     */
    @Test
    public void testDrawObstacle() {
        System.out.println("drawObstacle");
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawObstacle(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawFond method, of class Visualisateur.
     */
    @Test
    public void testDrawFond() {
        System.out.println("drawFond");
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawFond(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawAllNeed method, of class Visualisateur.
     */
    @Test
    public void testDrawAllNeed() {
        System.out.println("drawAllNeed");
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawAllNeed(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawHitBox method, of class Visualisateur.
     */
    @Test
    public void testDrawHitBox() {
        System.out.println("drawHitBox");
        Entity e = null;
        Graphics g = null;
        Color c = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawHitBox(e, g, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawAllHitBox method, of class Visualisateur.
     */
    @Test
    public void testDrawAllHitBox() {
        System.out.println("drawAllHitBox");
        Graphics g = null;
        Visualisateur instance = new Visualisateur();
        Graphics expResult = null;
        Graphics result = instance.drawAllHitBox(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
