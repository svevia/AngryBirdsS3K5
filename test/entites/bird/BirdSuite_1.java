 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites.bird;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({entites.bird.FondTest.class, entites.bird.ModuleBirdTest.class, entites.bird.BirdTest.class, entites.bird.FootstepTest.class, entites.bird.module.ModuleSuite.class})
public class BirdSuite {
    
}
