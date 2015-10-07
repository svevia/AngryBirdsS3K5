 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({entites.bird.skin.SkinSuite.class, entites.bird.FondTest.class, entites.bird.BirdTest.class, entites.bird.FootstepTest.class})
public class BirdSuite {

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
