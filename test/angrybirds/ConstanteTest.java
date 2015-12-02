package angrybirds;

import modele.Courbe;
import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;
import entites.obstacle.Carre;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstanteTest {

    public ConstanteTest() {
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
     * Test of iniz method, of class Constante.
     */
    @Test
    public void testIniz() {
        /**
         * Rappel :
         *
         * allModul = new ArrayList<>(); bird = new RougeGorge(); footstep =
         * Footstep.GAY; fond = Fond.PLAINE; obstacle = new ArrayList<>();
         * footstepX = new ArrayList<>(); footstepY = new ArrayList<>();
         * footstepA = new ArrayList<>(); last = false;
         */
        Constante.iniz();
        assertTrue(obstacle.isEmpty());
        assertTrue(footstepA.isEmpty());
        assertTrue(footstepX.isEmpty());
        assertTrue(footstepY.isEmpty());
        assertTrue(!last);
    }

    /**
     * Test of generateCourbe method, of class Constante.
     */
    @Test
    public void testGenerateCourbe() {
        double aMin = 0.0007, aMax = 0.0008;
        double bMin = -2, bMax = 0;
        Courbe result = Constante.generateCourbe();
        assertTrue(aMin < result.getA());
        assertTrue(aMax > result.getA());
        assertTrue(bMin < result.getB());
        assertTrue(bMax > result.getB());
    }

    /**
     * Test of generateListObstacle method, of class Constante.
     */
    @Test
    public void testGenerateListObstacle() {
        int combien = 0;
        ArrayList<Obstacle> result = Constante.generateListObstacle(combien);
        assertTrue(result.isEmpty());

        combien = 5;
        result = Constante.generateListObstacle(combien);
        assertTrue(result.size() == 5);

        // Verifie que tout les objets contenue dans la liste sont bien des obstacles
        for (int i = 0; i < result.size(); i++) {
            assertTrue(result.get(i) instanceof Obstacle);
        }
    }

    /**
     * Test of genereObstacle method, of class Constante.
     */
    @Test
    public void testGenereObstacle() {
        int borneXMin = 500, borneXMax = fenetre.width;
        int borneYMin = 0, borneYMax = fenetre.height;
        int tailleHMin = 0, tailleHMax = 100;
        int tailleWMin = 0, tailleWMax = 100;
        assertTrue((borneXMin < genereObstacle().getX()));
        assertTrue(borneXMax > genereObstacle().getX());
        assertTrue(borneYMin < genereObstacle().getY());
        assertTrue(borneYMax > genereObstacle().getY());
        assertTrue(tailleHMin < genereObstacle().getHight());
        assertTrue(tailleHMax > genereObstacle().getHight());
        assertTrue(tailleWMin < genereObstacle().getWeight());
        assertTrue(tailleWMax > genereObstacle().getWeight());
    }
}
