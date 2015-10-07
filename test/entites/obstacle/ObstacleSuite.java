 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.obstacle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.obstacle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({entites.obstacle.ObstacleTest.class, entites.obstacle.skin.SkinSuite.class})
public class ObstacleSuite {

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
