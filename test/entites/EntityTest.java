package entites;

import modele.Courbe;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {

    class Cobay extends Entity {

        public Cobay(int x, int y, int hight, int widht, Courbe crb) {
            super(x, y, hight, widht, crb);
        }

        @Override
        public Skin draw(Skin s) {
            return null;
        }

    }

    public EntityTest() {
    }

    /**
     * Test of getX method, of class Entity.
     */
    @Test
    public void testGetX() {
        Cobay sourisDeLabo = new Cobay(52, 50, 100, 20, null);
        assertEquals(sourisDeLabo.getX(), 52);
    }

    /**
     * Test of setX method, of class Entity.
     */
    @Test
    public void testSetX() {
        Cobay le = new Cobay(50, 50, 50, 50, null);
        assertEquals(le.getX(), 50);
        le.setX(500);
        assertEquals(le.getX(), 500);
    }

    /**
     * Test of getY method, of class Entity.
     */
    @Test
    public void testGetY() {
        Cobay java = new Cobay(50, 52, 50, 50, null);
        assertEquals(java.getY(), 52);
    }

    /**
     * Test of setY method, of class Entity.
     */
    @Test
    public void testSetY() {
        Cobay c = new Cobay(50, 50, 50, 50, null);
        assertEquals(c.getY(), 50);
        c.setY(500);
        assertEquals(c.getY(), 500);
    }

    /**
     * Test of getHight method, of class Entity.
     */
    @Test
    public void testGetHight() {
        Cobay trop = new Cobay(50, 50, 52, 50, null);
        assertEquals(trop.getHight(), 52);
    }

    /**
     * Test of setHight method, of class Entity.
     */
    @Test
    public void testSetHight() {
        Cobay cool = new Cobay(50, 50, 50, 50, null);
        assertEquals(cool.getHight(), 50);
        cool.setHight(500);
        assertEquals(cool.getHight(), 500);
    }

    /**
     * Test of getWidht method, of class Entity.
     */
    @Test
    public void testGetWidht() {
        Cobay rat = new Cobay(50, 50, 50, 52, null);
        assertEquals(rat.getWidht(), 52);
    }

    /**
     * Test of setWidht method, of class Entity.
     */
    @Test
    public void testSetWidht() {
        Cobay pinguin = new Cobay(50, 50, 50, 50, null);
        assertEquals(pinguin.getWidht(), 50);
        pinguin.setWidht(500);
        assertEquals(pinguin.getWidht(), 500);
    }

    // Ca deviens enfin interessant
    /**
     * Test of getHb method, of class Entity.
     */
    @Test
    public void testGetHb() {
        int x = 50, y = 100, h = 40, w = 20;
        Cobay vraiRat = new Cobay(x, y, h, w, null);
        // Le compareTo de hitbox pourrait faire un peu bugué les choses
        Hitbox fauxRat = vraiRat.getHb();
        assertEquals(fauxRat.getX(), x);
        assertEquals(fauxRat.getY(), y);
        assertEquals(fauxRat.h, h);
        assertEquals(fauxRat.w, w);
    }

    /**
     * Test of setHb method, of class Entity.
     */
    @Test
    public void testSetHb() {
        Cobay cobe = new Cobay(50, 50, 100, 100, null);
        assertEquals(cobe.getHb().getX(), 50);
        assertEquals(cobe.getHb().getY(), 50);
        assertEquals(cobe.getHb().h, 100);
        assertEquals(cobe.getHb().w, 100);
        cobe.setHb(new Hitbox(100, 100, 200, 200));
        assertEquals(cobe.getHb().getX(), 100);
        assertEquals(cobe.getHb().getY(), 100);
        assertEquals(cobe.getHb().h, 200);
        assertEquals(cobe.getHb().w, 200);
    }

    /**
     * Test of getCourbe method, of class Entity.
     */
    @Test
    public void testGetCourbe() {
        Courbe c = new Courbe(5, 5, 5, 5, 5, 5);
        Cobay c2c = new Cobay(10, 10, 20, 20, c);
        assertEquals(c2c.getCourbe(), c);
    }

    /**
     * Test of setCourbe method, of class Entity.
     */
    @Test
    public void testSetCourbe() {
        Courbe c = new Courbe(5, 5, 5, 5, 5, 5);
        Courbe c2 = new Courbe(20, 20, 20, 20, 20, 20);
        Cobay c2c = new Cobay(10, 10, 20, 20, c);
        assertEquals(c2c.getCourbe(), c);
        c2c.setCourbe(c2);
        assertEquals(c2c.getCourbe(), c2);
    }

    /**
     * Test of isMove method, of class Entity.
     */
    @Test
    public void testIsMove() {
        Cobay clafin = new Cobay(10, 10, 10, 10, null);
        assertFalse(clafin.isMove());
        /**
         * La courbe n'avait pas de courbe avant, et je lui en met une
         * Le isMove change alors
         */
        Courbe c = new Courbe(5, 5, 5, 5, 5, 5);
        clafin.setCourbe(c);
        assertTrue(clafin.isMove());
    }
}
