package entites.obstacle;

import angrybirds.Courbe;
import entites.Skin;
import java.awt.Color;

/**
 * Dessine un obstacle en forme de carre
 */
public class Carre extends Obstacle {

    /**
     * Cree un obstacle en forme de carre
     *
     * @param hight
     * @param widht
     * @param x
     * @param y
     * @param c
     */
    public Carre(int x, int y, int hight, int widht, Courbe crb, Color c) {
        super(x, y, hight, widht, crb, c);
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(c);
        s.getG().fillRect(x, y, widht, hight);
        return s;
    }
}
