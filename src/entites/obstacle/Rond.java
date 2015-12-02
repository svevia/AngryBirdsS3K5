package entites.obstacle;

import modele.Courbe;
import entites.Hitbox;
import entites.Skin;
import java.awt.Color;

/**
 * Dessine un obstacle en forme de carre
 */
public class Rond extends Obstacle {

    /**
     * Cree un obstacle en forme de carre
     *
     * @param hight La hauteur de l'obstacle
     * @param widht La largeur de l'obstacle
     * @param x La position en x de l'obstacle
     * @param y La position en y de l'obstacle
     * @param c La couleur de l'obstacle
     */
    public Rond(int x, int y, int hight, int widht, Courbe crb, Color c) {
        super(x, y, hight, widht, crb, c);
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(c);
        s.getG().fillOval(x, y, widht, hight);
        return s;
    }
}
