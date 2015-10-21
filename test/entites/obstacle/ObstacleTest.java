package entites.obstacle;

import entites.Hitbox;
import java.awt.Color;
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


public class ObstacleTest {
    
    public ObstacleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Test de la Classe Obstable");
        System.out.println("+=======================================+");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("+=======================================+");
        System.out.println("Fin du Test de la Classe Obstacle");
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
     * Test of getHight method, of class Obstacle.
     */
    @Test
    public void testGetHight() {
        System.out.println("getHight");
        Obstacle instance = new ObstacleImpl();
        int expResult = 200;
        int result = instance.getHight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHight method, of class Obstacle.
     */
    @Test
    public void testSetHight() {
        System.out.println("setHight");
        Obstacle instance = new ObstacleImpl();
        instance.setHight(150);
        assertEquals(instance.getHight(), 150);
        instance.setHight(-100);
        assertTrue(instance.getHight()> 0);
        
    }

    /**
     * Test of getWeight method, of class Obstacle.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Obstacle instance = new ObstacleImpl();
        int expResult = 100;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeight method, of class Obstacle.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        Obstacle instance = new ObstacleImpl();
        instance.setWeight(15);
        assertEquals(instance.getWeight(), 15);
        instance.setWeight(-20);
        assertTrue(instance.getWeight() > 0);
        
    }

    /**
     * Test of getX method, of class Obstacle.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Obstacle instance = new ObstacleImpl();
        int expResult = 10;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Obstacle.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        Obstacle instance = new ObstacleImpl();
        instance.setX(42);
        assertEquals(instance, 42);
        instance.setX(-50);
        assertTrue(instance.getX() > 0);
    }

    /**
     * Test of getY method, of class Obstacle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Obstacle instance = new ObstacleImpl();
        int expResult = 20;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class Obstacle.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        Obstacle instance = new ObstacleImpl();
        instance.setY(42);
        assertEquals(instance.getY(), 42);
        instance.setY(-42);
        assertTrue(instance.getY() > 0);
    }

    /**
     * Test of getC method, of class Obstacle.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Obstacle instance = new ObstacleImpl();
        Color expResult = Color.red;
        Color result = instance.getC();
        assertEquals(expResult, result);    
    }

    /**
     * Test of setC method, of class Obstacle.
     */
    @Test
    public void testSetC() {
        System.out.println("setC");
        Color c = Color.BLUE;
        Obstacle instance = null;
        instance.setC(c);
        assertEquals(instance.getC(), c);
    }

    /**
     * Test of getWidht method, of class Obstacle.
     */
    @Test
    public void testGetWidht() {
        System.out.println("getWidht");
        Obstacle instance = new ObstacleImpl();
        int expResult = 100;
        int result = instance.getWidht();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHb method, of class Obstacle.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        Obstacle instance = new ObstacleImpl();
        Hitbox expResult = new Hitbox(10, 20, new Dimension(100, 200));
        Hitbox result = instance.getHb();
        assertEquals(expResult, result);
    }

    /**
     * Test of addObstacle method, of class Obstacle.
     */
    @Test
    public void testAddObstacle() {
        System.out.println("addObstacle");
        Obstacle o = new ObstacleImpl();
        Obstacle.addObstacle(o);
    }

    /**
     * Test of addListObstacle method, of class Obstacle.
     */
    @Test
    public void testAddListObstacle() {
        System.out.println("addListObstacle");
        Obstacle[] o = {new ObstacleImpl(), new ObstacleImpl()};
        Obstacle.addListObstacle(o);
    }

    /**
     * Test of removeObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveObstacle() {
        System.out.println("removeObstacle");
        int i = 0;
        Obstacle.addObstacle(new ObstacleImpl());
        Obstacle.removeObstacle(i);
    }

    /**
     * Test of removeAllObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveAllObstacle() {
        System.out.println("removeAllObstacle");
        Obstacle.addObstacle(new ObstacleImpl());
        Obstacle.removeAllObstacle();
    }

    /**
     * Test of removeAllSpecifiedKindObstacle method, of class Obstacle.
     */
    @Test
    public void testRemoveAllSpecifiedKindObstacle() {
        System.out.println("removeAllSpecifiedKindObstacle");
        Obstacle o = new ObstacleImpl();
        Obstacle.addObstacle(o);
        Obstacle.removeAllSpecifiedKindObstacle(o);
    }

    public class ObstacleImpl extends Obstacle {

        public ObstacleImpl() {
            super(10, 20, 100, 200, null);
        }
        
        @Override
        public Graphics draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, widht, hight);
        return g;
        }
    }
    
}
