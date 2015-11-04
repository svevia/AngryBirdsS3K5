package entites;

import java.awt.Dimension;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        System.out.println("Test de la Classe Entity");
        System.out.println("+=======================================+");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("+=======================================+");
        System.out.println("Fin du Test de la Classe Entity");
    }
    
    @Before
    public void setUp() {
        System.out.println("+-------------------+");
    }
    
    @After
    public void tearDown() {
        System.out.println();
    }

    /**
     * Test of getX method, of class Entity.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Entity instance = new EntityImpl();
        int expResult = 10;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Entity.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        Entity instance = new EntityImpl();
        instance.setX(42);
        assertEquals(42, instance.getX());
        instance.setX(-42);
        assertTrue(instance.getX() > 0);
    }

    /**
     * Test of getY method, of class Entity.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Entity instance = new EntityImpl();
        int expResult = 20;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class Entity.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        Entity instance = new EntityImpl();
        instance.setY(42);
        assertEquals(42, instance.getY());
        instance.setY(-42);
        assertTrue(instance.getY() > 0);
    }

    /**
     * Test of getHight method, of class Entity.
     */
    @Test
    public void testGetHight() {
        System.out.println("getHight");
        Entity instance = new EntityImpl();
        int expResult = 100;
        int result = instance.getHight();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setHight method, of class Entity.
     */
    @Test
    public void testSetHight() {
        System.out.println("setHight");
        Entity instance = new EntityImpl();
        instance.setHight(42);
        assertEquals(42, instance.getY());
        instance.setHight(-42);
        assertTrue(instance.getY() > 0);
    }

    /**
     * Test of getWidht method, of class Entity.
     */
    @Test
    public void testGetWidht() {
        System.out.println("getWidht");
        Entity instance = new EntityImpl();
        int expResult = 200;
        int result = instance.getWidht();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWidht method, of class Entity.
     */
    @Test
    public void testSetWidht() {
        System.out.println("setWidht");
        Entity instance = new EntityImpl();
        instance.setWidht(42);
        assertEquals(42, instance.getWidht());
        instance.setWidht(-42);
        assertTrue(instance.getWidht() > 0);
    }

    /**
     * Test of getHb method, of class Entity.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        Entity instance = new EntityImpl();
        Hitbox expResult = new Hitbox(10, 20, new Dimension(100, 200));
        Hitbox result = instance.getHb();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setHb method, of class Entity.
     */
    @Test
    public void testSetHb() {
        System.out.println("setHb");
        Hitbox hb = new Hitbox(10, 20, new Dimension(42, 42));;
        Entity instance = new EntityImpl();
        instance.setHb(hb);
        assertEquals(hb, instance.getHb());
    }

    /**
     * Test of draw method, of class Entity.
     */
    @Test
    public void testDraw() {
        assertTrue(true);
    }

    public class EntityImpl extends Entity {

        public EntityImpl() {
            super(10, 20, 100, 200);
        }

        public Graphics draw(Graphics g) {
            g.fillOval(x, y, widht, hight);
            return g;
        }
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
