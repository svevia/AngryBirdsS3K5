package entites.obstacle.skin;

import java.awt.Color;
import java.awt.Graphics;
import entites.obstacle.Obstacle;

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
    public Carre(int x, int y, int hight, int widht, Color c) {
        super(x, y, hight, widht, c);
    }

    @Override
    public Graphics draw(Graphics g) {
        g.setColor(c);
        g.fillRect(x, y, widht, hight);
        return g;
    }
}
