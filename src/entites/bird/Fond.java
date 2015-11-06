package entites.bird;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *  Enumeration contenant tout les fonds
 */
public enum Fond {

    /**
     *
     */
    PLAINE("/ressource/plaine.png"),

    /**
     *
     */
    ENFER("/ressource/enfer.png");
    
    String source;

    Fond(String src) {
        source = src;
    }
    
    /**
     *
     * @return
     */
    public Image getFond() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource(source));
    }
}
