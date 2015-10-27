package entites.obstacle.skin;

import java.awt.Color;
import java.awt.Graphics;
import entites.obstacle.Obstacle;

/**
 * Objet permettant de faire des obstacles en forme de rond
 */
public class Rond extends Obstacle {

    /**
     * Dessine un rond
     * @param hight
     * @param widht
     * @param x
     * @param y
     * @param c 
     */
    public Rond(int x, int y, int hight, int widht, Color c) {
        super(x, y, hight, widht, c);
    }

    @Override
    public Graphics draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, widht, hight);
        return g;
    }
}
