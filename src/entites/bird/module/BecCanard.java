package entites.bird.module;

import entites.Skin;
import entites.bird.Bird;
import java.awt.Color;

public class BecCanard extends ModuleBird {

    private int nbPoint;
    private Color couleur;
    private double largeur;
    int[] pointX, pointY;

    /**
     *
     * @param largeur
     * @param distanceCentre
     * @param b
     * @param couleur
     */
    public BecCanard(double largeur, double distanceCentre, Bird b, Color couleur) {
        super(distanceCentre, b, false);
        nbPoint = 4;
        this.largeur = largeur;
        this.couleur = couleur;
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(couleur);
        this.pointX = new int[nbPoint];
        this.pointY = new int[nbPoint];
        double angle = (Math.sin(b.getA()));
        pointX[0] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle - largeur));
        pointX[1] = (int) (b.getBirdCenterX() + 2 * b.getR() * Math.cos(angle));
        pointX[2] = (int) (b.getBirdCenterX() + 1.5 * b.getR() * Math.cos(angle + largeur));
        pointX[3] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle + largeur));
        pointY[0] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle - largeur));
        pointY[1] = (int) (b.getBirdCenterY() + 2 * b.getR() * Math.sin(angle));
        pointY[2] = (int) (b.getBirdCenterY() + 1.5 * b.getR() * Math.sin(angle + largeur));
        pointY[3] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle + largeur));
        s.getG().fillPolygon(pointX, pointY, nbPoint);
        return s;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return 20;
    }
}
