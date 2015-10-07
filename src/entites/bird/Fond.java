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
    PAYSAGE("src/ressource/fond.png");
    
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
