package skin;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oiseau {

    /**
     * Taille du corp l'oiseau en pixel en largeur
     */
    protected int fatX;

    /**
     * Taille du corp l'oiseau en pixel en hauteur
     */
    protected int fatY;

    /**
     * Rayon du corp de l'oiseau en pixel
     */
    protected int r;

    /**
     * Sa position en X sur la fenetre
     */
    protected int posX;

    /**
     * Sa postion en Y sur la fenetre
     */
    protected int posY;

    /**
     * La position graphique du centre du corp de l'oiseau en x sur la fenetre
     */
    protected int birdCenterX;

    /**
     * La position graphique du centre du corp de l'oiseau en y sur la fenetre
     */
    protected int birdCenterY;

    /**
     * La taille de l'oeil en pixel
     */
    protected int tailleOeil;

    /**
     * Le nombre de point du bec, un triangle en vaux 3 par exemple
     */
    protected int nbPointBec;

    /**
     * Les coordonnees des points du bec de l'oiseau en x sur le fenetre
     */
    protected int[] polyX;

    /**
     * Les coordonnees des points du bec de l'oiseau en y sur le fenetre
     */
    protected int[] polyY;

    /**
     * La taille du bec en radian ex : PI/4 donnera un bec de 35°
     */
    protected double tailleBec;

    /**
     * La position de l'oeil par rapport au centre de l'oiseau ex : 0.7 donnera
     * l'oeil à 70% du rayon du bord
     */
    protected double positionOeil;

    /**
     * La couleur du corps
     */
    protected Color corps;
    /**
     * La couleur du bec
     */
    protected Color bec;
    /**
     * La couleur des yeux
     */
    protected Color oeil;

    public Oiseau(int fatX, int fatY, int tailleOeil, int nbPointBec, double tailleBec, double positionOeil, Color corps, Color bec, Color oeil) {
        this.fatX = fatX;
        this.fatY = fatY;
        this.tailleOeil = tailleOeil;
        this.nbPointBec = nbPointBec;
        this.tailleBec = tailleBec;
        this.positionOeil = positionOeil;
        this.corps = corps;
        this.bec = bec;
        this.oeil = oeil;
        r = fatX / 2;
        polyX = new int[nbPointBec];
        polyY = new int[nbPointBec];
    }

    protected Graphics getGraphic(int posX, int posY, double angle, Graphics g) {
        g.setColor(corps); // La couleur du pigeon
        g.fillOval(posX, posY, fatX, fatY); // Le corp du canard (35 de diametre par defaut, fat)
        g.setColor(bec);  // La couleur du bec
        g.fillPolygon(polyX, polyY, polyX.length); // Le bec
        g.setColor(oeil); // La couleur de son oeil droit
        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil)), (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil)), tailleOeil, tailleOeil); // Son oeil droit
        return g;
    }

    public int getR() {
        return r;
    }

    public abstract Graphics draw(int posX, int posY, double angle, Graphics g);

}
