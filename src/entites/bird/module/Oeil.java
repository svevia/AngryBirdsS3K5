package entites.bird.module;

import entites.Skin;
import entites.bird.Bird;
import java.awt.Color;

/**
 * Rajoute un oeil oval a l'oiseau
 */
public class Oeil extends ModuleBird {

    int diametre;
    Color couleur;
    double angle;

    /**
     *
     * @param distanceCentre
     * @param b
     * @param over
     * @param diametre
     * @param couleur
     */
    public Oeil(double distanceCentre, Bird b, boolean over, int diametre, Color couleur) {
        super(distanceCentre, b, over);
        this.diametre = diametre;
        this.couleur = couleur;
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(couleur);
        this.angle = (Math.sin(b.getA()));
        s.getG().fillOval((int) (b.getBirdCenterX() + (distanceCentre * Math.cos(angle - Math.PI / 4))), (int) (b.getBirdCenterY() + (distanceCentre * Math.sin(angle - Math.PI / 4))), diametre, diametre);
        return s;
    }

    /**
     *
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }
}
