package entites;

import java.awt.Graphics;

/**
 * Proxy servant a remplacer le Graphics
 */
public class Skin {

    /**
     * Graphics du skin
     */
    private Graphics g;

    /**
     * Constructeur
     * @param g Le skin de base
     */
    public Skin(Graphics g) {
        this.g = g;
    }

    /**
     * Remplace le graphics par un autre
     * @param g Nouveau graphics
     */
    public void setG(Graphics g) {
        this.g = g;
    }

    /**
     * @return Le graphics du skin 
     */
    public Graphics getG() {
        return g;
    }

}
