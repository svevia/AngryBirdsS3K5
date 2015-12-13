package entites;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wissam
 */
public class HitboxTest {

    public HitboxTest() {
    }

    /**
     * Test of compareTo method, of class Hitbox.
     */
    @Test
    public void testCompareTo() {
        /**
         * Test deux hitbox l'une dans l'autre
         */
        Hitbox hb1 = new Hitbox(50, 50, 50, 50);
        Hitbox hb2 = new Hitbox(50, 50, 50, 50);
        assertEquals(hb1.compareTo(hb2), 1);
        /**
         * Test deux hitbox éloignées
         */
        hb2 = new Hitbox(9999, 9999, 10, 10);
        assertEquals(hb1.compareTo(hb2), 0);
        /**
         * Test deux hitbox l'une à coté de l'autre
         */
        hb2 = new Hitbox(90, 90, 50, 50);
        assertEquals(hb1.compareTo(hb2), 1);
        hb2 = new Hitbox(50, 99, 50, 50);
        assertEquals(hb1.compareTo(hb2), 1);
    }

    /**
     * Test of setPosition method, of class Hitbox.
     */
    @Test
    public void testSetPosition() {
        /**
         * Change la position est vérifie si elle correspond aux getters
         */
        Hitbox hb = new Hitbox(50, 50, 50, 50);
        assertEquals(hb.getX(), 50);
        assertEquals(hb.getY(), 50);
        hb.setPosition(90, 120);
        assertEquals(hb.getX(), 90);
        assertEquals(hb.getY(), 120);
    }

    /**
     * Test of toString method, of class Hitbox.
     */
    @Test
    public void testToString() {
        /**
         * Test si le toString correspond bien au coordonnées rentrées
         */
        int x, y, w, h = 50;
        x = y = w = h;
        Hitbox hb = new Hitbox(x, y, w, h);
        assertEquals(hb.toString(), "Position : x : " + x + " ; y : " + y + " ; Taille : w " + w + " ; h : " + h);
        x = y = 90;
        hb.setPosition(x, y);
        assertEquals(hb.toString(), "Position : x : " + x + " ; y : " + y + " ; Taille : w " + w + " ; h : " + h);
    }

}
