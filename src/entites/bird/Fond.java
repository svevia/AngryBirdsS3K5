package entites.bird;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *  Enumeration contenant tout les fonds
 */
public enum Fond {

    /**
     *
     */
    PLAINE("src/ressource/plaine.png"),
    ENFER("src/ressource/enfer.png");
    
    String source;

    Fond(String src) {
        source = src;
    }
    
    /**
     *
     * @return
     */
    public Image getFond() {
        return Toolkit.getDefaultToolkit().getImage(source);
    }
}
