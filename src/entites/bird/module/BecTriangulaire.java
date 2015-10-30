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
    private Color couleur;
    private int hauteur;
    private double largeur;
    int[] pointX, pointY;

    public BecTriangulaire(int hauteur, double largeur, double distanceCentre, Bird b, Color couleur) {
        super(distanceCentre, b, false);
        nbPoint = 3;
        this.hauteur = hauteur;
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
        pointX[1] = (int) (b.getBirdCenterX() + hauteur * b.getR() * Math.cos(angle));
        pointX[2] = (int) (b.getBirdCenterX() + b.getR() * Math.cos(angle + largeur));
        pointY[0] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle - largeur));
        pointY[1] = (int) (b.getBirdCenterY() + ((hauteur * b.getR()) * Math.sin(angle)));
        pointY[2] = (int) (b.getBirdCenterY() + b.getR() * Math.sin(angle + largeur));
        g.fillPolygon(pointX, pointY, nbPoint);
        return g;
    }

//    @Override
//    public void createHitbox() {
//        for (int i = 0; i < this.pointX.length; i++) {
//            for (int j = 0; j < this.pointY.length; i++) {
//                hb = new Hitbox(this.pointX[i], this.pointY[j],
//                        new Dimension(this.pointX[this.nbPoint], this.pointY[this.nbPoint]));
//            }
//        }
//    }

    @Override
    public int getSize() {
        return hauteur;
    }
}
