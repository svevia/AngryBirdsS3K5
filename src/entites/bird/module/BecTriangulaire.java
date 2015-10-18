package entites.bird.module;

import entites.bird.Bird;
import entites.bird.ModuleBird;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Rajoute un bec triangulaire (en trois points) a l'oiseau
 */
public class BecTriangulaire extends ModuleBird {

    private int nbPoint;

    private int hauteur;
    private double largeur;

    public BecTriangulaire(int hauteur, double largeur, double distanceCentre, Bird b) {
        super(distanceCentre, b, false);
        nbPoint = 3;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    @Override
    public Graphics draw(Graphics g) {
        g.setColor(Color.orange);
        int[] pointX = new int[nbPoint];
        int[] pointY = new int[nbPoint];
        double angle = (Math.sin(b.getA()));
        pointX[0] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle - largeur));
        pointX[1] = (int) (b.getBirdCenterX() + hauteur * b.getR() * Math.cos(angle));
        pointX[2] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle + largeur));
        pointY[0] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle - largeur));
        pointY[1] = (int) (b.getBirdCenterY() + ((hauteur * b.getR()) * Math.sin(angle)));
        pointY[2] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle + largeur));
        g.fillPolygon(pointX, pointY, nbPoint);
        return g;
    }
}
