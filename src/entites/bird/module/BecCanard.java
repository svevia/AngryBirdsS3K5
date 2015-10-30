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
    int[] pointX, pointY;

    public BecCanard(double largeur, double distanceCentre, Bird b, Color couleur) {
        super(distanceCentre, b, false);
        nbPoint = 4;
        this.largeur = largeur;
        this.couleur = couleur;
    }

    @Override
    public Graphics draw(Graphics g) {
        g.setColor(couleur);
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
        g.fillPolygon(pointX, pointY, nbPoint);
        return g;
    }
    
    

//    @Override
//    public void createHitbox() {
//        for (int i = 0; i < this.pointX.length; i++) {
//            for (int j = 0; j < this.pointY.length; j++) {
//                hb = new Hitbox(pointX[i], pointY[j], new Dimension(pointX[nbPoint], pointY[nbPoint]));
//            }
//        }
//    }

    public double getLargeur() {
        return largeur;
    }

    public int getSize() {
        return 20;
    }
}
