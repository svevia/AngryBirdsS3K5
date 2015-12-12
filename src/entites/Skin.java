package entites;

import java.awt.Graphics;

/**
 *  Transporte un grpahics qui represente une entite reellement 
 */
public class Skin {

    /**
     * Le grpahics du skin
     */
    private Graphics g;

    /**
     * Construit un skin a partir d'un graphics existant
     * @param g Le graphics de base
     */
    public Skin(Graphics g) {
        this.g = g;
    }

    /**
     * Change le graphics
     * @param g Le nouveau graphics
     */
    public void setG(Graphics g) {
        this.g = g;
    }

    /**
     * @return Le graphics 
     */
    public Graphics getG() {
        return g;
    }

}
