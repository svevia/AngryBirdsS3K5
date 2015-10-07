 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package angrybirds;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package angrybirds;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({angrybirds.AngryBirdsTest.class, angrybirds.GamePanelTest.class, angrybirds.LivrableUnTest.class, angrybirds.VisualisateurTest.class, angrybirds.CourbeTest.class, angrybirds.HeartCoreTest.class, angrybirds.AnimationOiseauTest.class, angrybirds.ConstanteTest.class})
public class AngrybirdsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
