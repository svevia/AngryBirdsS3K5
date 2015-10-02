package skin;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Wissam
 */
public enum Fond {

    
    PAYSAGE("src/ressource/fond.png");
    
    String source;

    Fond(String src) {
        source = src;
    }
    
    public Image getFond() {
        return Toolkit.getDefaultToolkit().getImage(source);
    }
}
