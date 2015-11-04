package entites.bird.module;

import entites.bird.Bird;
import entites.bird.ModuleBird;
import java.awt.Color;
import java.awt.Graphics;

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
    public Graphics draw(Graphics g) {
        g.setColor(couleur);
        this.angle = (Math.sin(b.getA()));
        g.fillOval((int) (b.getBirdCenterX() + (distanceCentre * Math.cos(angle - Math.PI / 4))), (int) (b.getBirdCenterY() + (distanceCentre * Math.sin(angle - Math.PI / 4))), diametre, diametre);
        return g;
    }

//    @Override
//    public void createHitbox() {
//        hb = new Hitbox((int) (b.getBirdCenterX() + (distanceCentre * Math.cos(angle - Math.PI / 4))),
//                (int) (b.getBirdCenterY() + (distanceCentre * Math.sin(angle - Math.PI / 4))), new Dimension(diametre, diametre));
//    }

    /**
     *
     * @return
     */
        @Override
    public int getSize() {
        return 0;
    }
}
