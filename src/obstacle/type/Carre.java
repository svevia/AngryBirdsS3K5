package obstacle.type;

import java.awt.Color;
import java.awt.Graphics;
import obstacle.Obstacle;

/**
 * Dessine un obstacle en forme de carre
 */
public class Carre extends Obstacle {

    /**
     * Cree un obstacle en forme de carre
     * @param hight
     * @param widht
     * @param x
     * @param y
     * @param c 
     */
    public Carre(int hight, int widht, int x, int y, Color c) {
        super(hight, widht, x, y, c);
    }

    @Override
    public Graphics drawMe(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, widht, hight);
        return g;
    }

    @Override
    public Graphics drawMe(int x, int y, Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graphics drawMe(int x, int y, Color c, Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
