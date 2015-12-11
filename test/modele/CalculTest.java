package modele;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test de la classe Calcul
 */
public class CalculTest {

    /**
     * Test of force method, of class Calcul, if you pass this test, you can
     * become a true jedi.
     */
    @Test
    public void testForce() {
        /**
         * Test le drag'n'drop pour une longeur de tir de 50 px sur une cibe de
         * 100px Le resultat doit être de 100 pour 100% de force dans la tir
         */
        Calcul.xFocus = 100;
        Calcul.yFocus = 100;
        Calcul.xFocusActual = 150;
        Calcul.yFocusActual = 100;
        Calcul.diametreCercleDeForce = 100;
        assertEquals(Calcul.force(), 100);
        /**
         * Test pour une longueur dépassant la moitié du diamétre de la force
         */
        Calcul.xFocusActual = 6000; // On abuse un peu, mais au moins on est sur
        assertEquals(Calcul.force(), 100); // Le résultat est de 100%
        /**
         * Test pour une longueur juste sous la limite des 100%
         */
        Calcul.xFocusActual = 149;
        assertEquals(Calcul.force(), 98);
        assertTrue(Calcul.force() != 100);
        /**
         * Test la force pour une longueur nulle
         */
        Calcul.xFocusActual = 100;
        assertEquals(Calcul.force(), 0);

        /**
         * Nous avons donc testé un drag de 0 par rapport au centre, 50 pixels
         * par rapport au centre sur un cercle de force de 50 pixels de rayon,
         * et dépassant ces 50 pixels
         */
    }

    /**
     * Test of angle method, of class Calcul.
     */
    @Test
    public void testAngle() {
        /**
         * La drag forme un trait horizontale par rapport au centre, donc
         * l'angle est null
         */
        Calcul.xFocus = 100;
        Calcul.yFocus = 100;
        Calcul.xFocusActual = 150;
        Calcul.yFocusActual = 100;
        Calcul.diametreCercleDeForce = 100;
        assertEquals(0, (double) Calcul.angle(), 5);
        /**
         * L'angle fait un demi angle droit cette fois
         */
        Calcul.yFocusActual = 150;
        assertEquals(Math.PI/4, (double) Calcul.angle(), 5);
        /**
         * L'angle fait un demi angle droit vers le bas
         */
        Calcul.xFocusActual = 50;
        Calcul.yFocusActual = 50;
        assertEquals(-Math.PI/4, (double) Calcul.angle(), 5);
        /**
         * L'angle tire vers la gauche a l'horizontale
         */
        Calcul.xFocusActual = 0;
        Calcul.yFocusActual = 100;
        assertEquals(-Math.PI, (double) Calcul.angle(), 5);
    }
}
