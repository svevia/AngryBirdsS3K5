package entites.bird;

import entites.Entity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import entites.Hitbox;
import java.util.ArrayList;

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
     * La couleur du corps
     */
    protected Color corps;

    /**
     * Les modules de l'oiseau
     */
    protected ArrayList<ModuleBird> modul = new ArrayList<>();

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
    public Bird(int pigeonX, int pigeonY, int fatX, int fatY, Color corps) {
        super(pigeonX, pigeonY, fatX, fatY);
        this.corps = corps;
        r = fatX / 2;
        hb = new Hitbox(0, 0, new Dimension(fatX, fatY));
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
    protected Graphics MinimalBirdFactory(Graphics g) {
        g.setColor(corps); // La couleur du pigeon
        g.fillOval(getPosX(), getPosY(), getWidht(), getHight()); // Le corp
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

    /**
     * Le draw des modules
     *
     * @param g
     * @return
     */
    public Graphics drawAllModule(Graphics g, boolean over) {
        if (over) {
            for (int i = 0; i < modul.size(); i++) {
                if (modul.get(i).over) {
                    modul.get(i).draw(g);
                }
            }
        } else {
            for (int i = 0; i < modul.size(); i++) {
                if (!modul.get(i).over) {
                    modul.get(i).draw(g);
                }
            }
        }
        return g;
    }

    /**
     * Ajoute un module a l'oiseau
     *
     * @param mb
     */
    public void addModule(ModuleBird mb) {
        modul.add(mb);
    }
}