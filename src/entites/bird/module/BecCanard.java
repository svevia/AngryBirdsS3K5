package entites.bird.module;

import entites.bird.Bird;
import entites.bird.ModuleBird;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Wissam
 */
public class BecCanard extends ModuleBird {

    private int nbPoint;
    private Color couleur;
    private double largeur;

    public BecCanard(double largeur, double distanceCentre, Bird b, Color couleur) {
        super(distanceCentre, b, false);
        nbPoint = 4;
        this.largeur = largeur;
        this.couleur = couleur;
    }

    @Override
    public Graphics draw(Graphics g) {
        g.setColor(couleur);
        int[] pointX = new int[nbPoint];
        int[] pointY = new int[nbPoint];
        double angle = (Math.sin(b.getA()));
        pointX[0] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle - largeur));
        pointX[1] = (int) (b.getBirdCenterX() + 2 * b.getR() * Math.cos(angle));
        pointX[2] = (int) (b.getBirdCenterX() + 1.5 * b.getR() * Math.cos(angle + largeur));
        pointX[3] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle + largeur));
        pointY[0] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle - largeur));
        pointY[1] = (int) (b.getBirdCenterY() + 2 * b.getR() * Math.sin(angle));
        pointY[2] = (int) (b.getBirdCenterY() + 1.5 * b.getR() * Math.sin(angle + largeur));
        pointY[3] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle + largeur));
        g.fillPolygon(pointX, pointY, nbPoint);
        return g;
    }
//            super.polyX[0] = (int) (birdCenterX + r * Math.cos(getA() - tailleBec));
//        super.polyX[1] = (int) (birdCenterX + 2 * r * Math.cos(getA()));
//        super.polyX[2] = (int) (birdCenterX + 1.5 * r * Math.cos(getA() + tailleBec));
//        super.polyX[3] = (int) (birdCenterX + r * Math.cos(getA() + tailleBec));
//        super.polyY[0] = (int) (birdCenterY + r * Math.sin(getA() - tailleBec));
//        super.polyY[1] = (int) (birdCenterY + 2 * r * Math.sin(getA()));
//        super.polyY[2] = (int) (birdCenterY + 1.5 * r * Math.sin(getA() + tailleBec));
//        super.polyY[3] = (int) (birdCenterY + r * Math.sin(getA() + tailleBec));
    
}
