 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
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


public class MatriceTest {
    
    public MatriceTest() {
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
     * Test of setValueAtIdx method, of class Matrice.
     */
    @Test
    public void testSetValueAtIdx() {
        System.out.println("setValueAtIdx");
        int ligne = 0;
        int colonne = 0;
        int value = 0;
        Matrice instance = new Matrice();
        instance.setValueAtIdx(ligne, colonne, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAtIdx method, of class Matrice.
     */
    @Test
    public void testGetValueAtIdx() {
        System.out.println("getValueAtIdx");
        int ligne = 0;
        int colonne = 0;
        Matrice instance = new Matrice();
        int expResult = 0;
        int result = instance.getValueAtIdx(ligne, colonne);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haveTheSameDimensions method, of class Matrice.
     */
    @Test
    public void testHaveTheSameDimensions() {
        System.out.println("haveTheSameDimensions");
        Matrice m = null;
        Matrice instance = new Matrice();
        boolean expResult = false;
        boolean result = instance.haveTheSameDimensions(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of additionMatrice method, of class Matrice.
     */
    @Test
    public void testAdditionMatrice() {
        System.out.println("additionMatrice");
        Matrice m = null;
        Matrice instance = new Matrice();
        instance.additionMatrice(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAdditionMatrice method, of class Matrice.
     */
    @Test
    public void testNewAdditionMatrice() {
        System.out.println("newAdditionMatrice");
        Matrice m = null;
        Matrice instance = new Matrice();
        Matrice expResult = null;
        Matrice result = instance.newAdditionMatrice(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of soustractionMatrice method, of class Matrice.
     */
    @Test
    public void testSoustractionMatrice() {
        System.out.println("soustractionMatrice");
        Matrice m = null;
        Matrice instance = new Matrice();
        instance.soustractionMatrice(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSoustractionMatrice method, of class Matrice.
     */
    @Test
    public void testNewSoustractionMatrice() {
        System.out.println("newSoustractionMatrice");
        Matrice m = null;
        Matrice instance = new Matrice();
        Matrice expResult = null;
        Matrice result = instance.newSoustractionMatrice(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transposition method, of class Matrice.
     */
    @Test
    public void testTransposition() {
        System.out.println("transposition");
        Matrice instance = new Matrice();
        instance.transposition();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multipliable method, of class Matrice.
     */
    @Test
    public void testMultipliable() {
        System.out.println("multipliable");
        Matrice m = null;
        Matrice instance = new Matrice();
        boolean expResult = false;
        boolean result = instance.multipliable(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MultipliMatrice method, of class Matrice.
     */
    @Test
    public void testMultipliMatrice() {
        System.out.println("MultipliMatrice");
        Matrice m = null;
        Matrice instance = new Matrice();
        Matrice expResult = null;
        Matrice result = instance.MultipliMatrice(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertLigne method, of class Matrice.
     */
    @Test
    public void testInsertLigne() {
        System.out.println("insertLigne");
        int idx = 0;
        int[] nouvelLigne = null;
        Matrice instance = new Matrice();
        instance.insertLigne(idx, nouvelLigne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertColonne method, of class Matrice.
     */
    @Test
    public void testInsertColonne() {
        System.out.println("insertColonne");
        int idx = 0;
        int[] nouvelColonne = null;
        Matrice instance = new Matrice();
        instance.insertColonne(idx, nouvelColonne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreColonne method, of class Matrice.
     */
    @Test
    public void testGetNombreColonne() {
        System.out.println("getNombreColonne");
        Matrice instance = new Matrice();
        int expResult = 0;
        int result = instance.getNombreColonne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreColonne method, of class Matrice.
     */
    @Test
    public void testSetNombreColonne() {
        System.out.println("setNombreColonne");
        int nombreColonne = 0;
        Matrice instance = new Matrice();
        instance.setNombreColonne(nombreColonne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreLigne method, of class Matrice.
     */
    @Test
    public void testGetNombreLigne() {
        System.out.println("getNombreLigne");
        Matrice instance = new Matrice();
        int expResult = 0;
        int result = instance.getNombreLigne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreLigne method, of class Matrice.
     */
    @Test
    public void testSetNombreLigne() {
        System.out.println("setNombreLigne");
        int nombreLigne = 0;
        Matrice instance = new Matrice();
        instance.setNombreLigne(nombreLigne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrice method, of class Matrice.
     */
    @Test
    public void testGetMatrice() {
        System.out.println("getMatrice");
        Matrice instance = new Matrice();
        int[][] expResult = null;
        int[][] result = instance.getMatrice();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMatrice method, of class Matrice.
     */
    @Test
    public void testSetMatrice_intArrArr() {
        System.out.println("setMatrice");
        int[][] matrice = null;
        Matrice instance = new Matrice();
        instance.setMatrice(matrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMatrice method, of class Matrice.
     */
    @Test
    public void testSetMatrice_int_int() {
        System.out.println("setMatrice");
        int ligne = 0;
        int colonne = 0;
        Matrice instance = new Matrice();
        instance.setMatrice(ligne, colonne);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Matrice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Matrice instance = new Matrice();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
