package entites.bird.skin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import entites.bird.Bird;
import entites.bird.module.BecCanard;
import entites.bird.module.Oeil;

/**
 * Class permettante de dessiner un canard
 */
public class Canard extends Bird {

    private BecCanard bec = new BecCanard(Math.PI / 4, 1, this, Color.yellow);
    private Oeil oeil = new Oeil(15, this, true, 5, Color.blue);

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public Canard() {
        super(0, 0, 40, 40, Color.white);
        super.hb.setD(new Dimension(20, 20));
        addModule(bec);
        addModule(oeil);
    }

    /**
     * Dessine le canard sur une position x et y en un certain getA sur le
     * Graphic g, et renvoie ce dernier
     *
     * @param getPosX()
     * @param posY
     * @param angle
     * @param g
     * @return
     */
    @Override
    public Graphics draw(Graphics g) {
        super.birdCenterX = getX() + getWidht() / 2;
        super.birdCenterY = getY() + getHight() / 2;

        super.hb.setPosition(getX(), getY());
        g = drawAllModule(g, false);
        g = MinimalBirdFactory(g);
        g = drawAllModule(g, true);
        return g;
    }
}
