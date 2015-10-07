package entites.bird;

import entites.Entity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import entites.Hitbox;

/**
 * La class abstraite Bird normalise la creation des oiseaux donnant acce a une
 * methode un constructeur et une fonction draw.
 */
public abstract class Bird extends Entity {

    /**
     * Angle d'inclinaison du pigeon
     */
    protected double a;

    /**
     * Rayon du corp de l'oiseau en pixel
     */
    protected int r;

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

    /**
     * Le constructeur de l'oiseau
     *
     * @param fatX Sa largeur
     * @param fatY Sa hauteur
     * @param tailleOeil La taille de son oiel droit
     * @param nbPointBec Le nombre d'angle de son bec (3 pour un triangle)
     * @param tailleBec La taille en radian du bec (la taille de la base du bec)
     * @param positionOeil La distance par rapport au centre et au rayon de
     * l'oeil compris entre 0 et 1 (si non l'oeil sera en dehors du pigeon)
     * @param corps La couleur principale du pigeon
     * @param bec La couleur de son bec
     * @param oeil La couleur de son oeil droit
     */
    public Bird(int pigeonX, int pigeonY, int fatX, int fatY, int tailleOeil, int nbPointBec, double tailleBec, double positionOeil, Color corps, Color bec, Color oeil) {
        super(pigeonX, pigeonY, fatX, fatY);
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
        hb = new Hitbox(0, 0, new Dimension(fatX + (int) tailleBec, fatY));
    }

    /**
     * La fonction dessine l'oiseau en position x, y et angle a sur le Graphics
     * voulu "g"
     *
     * @param posX La position de l'entite en x
     * @param posY La position de l'entite en y
     * @param angle Sa direction
     * @param g Le Graphics sur le quel applique le dessin
     * @return Le Graphics dessine
     */
    protected Graphics getGraphic(Graphics g) {
        g.setColor(corps); // La couleur du pigeon
        g.fillOval(getPosX(), getPosY(), getWidht(), getHight()); // Le corp
        g.setColor(bec);  // La couleur du bec
        g.fillPolygon(polyX, polyY, polyX.length); // Le bec
        g.setColor(oeil); // La couleur de son oeil droit
        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(getA() - positionOeil)), (int) (birdCenterY + (positionOeil * r) * Math.sin(getA() - positionOeil)), tailleOeil, tailleOeil); // Son oeil droit
        return g;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    /**
     *
     * @return
     */
    public int getR() {
        return r;
    }

    /**
     *
     * @return
     */
    public Hitbox getHb() {
        return hb;
    }

    /**
     *
     * @param corps
     */
    public void setCorps(Color corps) {
        this.corps = corps;
    }

    /**
     *
     * @return
     */
    public int getPosX() {
        return super.x;
    }

    /**
     *
     * @param posX
     */
    public void setPosX(int posX) {
        super.x = posX;
    }

    /**
     *
     * @return
     */
    public int getPosY() {
        return super.y;
    }

    /**
     *
     * @param posY
     */
    public void setPosY(int posY) {
        super.y = posY;
    }

    /**
     *
     * @return
     */
    public int getBirdCenterX() {
        return birdCenterX;
    }

    /**
     *
     * @param birdCenterX
     */
    public void setBirdCenterX(int birdCenterX) {
        this.birdCenterX = birdCenterX;
    }

    /**
     *
     * @return
     */
    public int getBirdCenterY() {
        return birdCenterY;
    }

    /**
     *
     * @param birdCenterY
     */
    public void setBirdCenterY(int birdCenterY) {
        this.birdCenterY = birdCenterY;
    }
}
