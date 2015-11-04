 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package entites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({entites.HitboxTest.class, entites.CollisionTest.class, entites.MatriceTest.class, entites.EntityTest.class})
public class EntitesSuite {
    
}
