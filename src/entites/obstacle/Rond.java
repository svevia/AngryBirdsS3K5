package entites.obstacle;

import static angrybirds.jeu.core.CrashCore.entityHitBird;
import modele.Courbe;
import entites.Skin;
import static entites.obstacle.ImpactOrder.lastObstacleRebond;
import static entites.obstacle.ImpactOrder.rebondOiseau;
import java.awt.Color;

/**
 * Dessine un obstacle en forme de carre
 */
public class Rond extends Obstacle {

    /**
     * La couleur du rond
     */
    Color c;

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
        super(x, y, hight, widht, crb);
        this.c = c;
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(c);
        s.getG().fillOval(x, y, widht, hight);
        return s;
    }

    @Override
    public void impact() {
        if (lastObstacleRebond != this) {
            lastObstacleRebond = this;
            rebondOiseau(entityHitBird(false), 1);
        }
    }
}
