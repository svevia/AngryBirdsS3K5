package entites.bird.module;

import entites.Skin;
import entites.bird.Bird;
import java.awt.Color;

/**
 * Rajoute un bec triangulaire (en trois points) a l'oiseau
 */
public class BecTriangulaire extends ModuleBird {

    private int nbPoint;
    private Color couleur;
    private int hauteur;
    private double largeur;
    int[] pointX, pointY;

    /**
     *
     * @param hauteur
     * @param largeur
     * @param distanceCentre
     * @param b
     * @param couleur
     */
    public BecTriangulaire(int hauteur, double largeur, double distanceCentre, Bird b, Color couleur) {
        super(distanceCentre, b, false);
        nbPoint = 3;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.couleur = couleur;
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(couleur);
        this.pointX = new int[nbPoint];
        this.pointY = new int[nbPoint];
        double angle = (b.getA());
        pointX[0] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle - largeur));
        pointX[1] = (int) (b.getBirdCenterX() + hauteur * b.getR() * Math.cos(angle));
        pointX[2] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle + largeur));
        pointY[0] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle - largeur));
        pointY[1] = (int) (b.getBirdCenterY() + ((hauteur * b.getR()) * Math.sin(angle)));
        pointY[2] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle + largeur));
        s.getG().fillPolygon(pointX, pointY, nbPoint);
        return s;
    }

    @Override
    public int getSize() {
        return hauteur * 3;
    }
}
