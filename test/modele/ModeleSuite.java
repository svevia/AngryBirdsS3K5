 Error reading included file Templates/UnitTests/Templates/Licenses/license-default.txt
package modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Wissam
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({modele.CourbeTest.class, modele.ImageCustomzTest.class, modele.MatriceTest.class, modele.PFAGReaderTest.class, modele.CalculTest.class, modele.VisualisateurTest.class, modele.InfoPigeonTest.class})
public class ModeleSuite {
    
}
