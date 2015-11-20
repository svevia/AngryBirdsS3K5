package entites;

import java.awt.Graphics;

/**
 *
 * @author Wissam
 */
public class Skin {

    
    Graphics g;

    public Skin(Graphics g) {
        this.g = g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public Graphics getG() {
        return g;
    }
    
    
}
