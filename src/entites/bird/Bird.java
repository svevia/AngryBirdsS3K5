package entites.bird;

import entites.bird.module.ModuleBird;
import static angrybirds.Constante.allModul;
import angrybirds.Courbe;
import entites.Entity;
import java.awt.Color;
import entites.Hitbox;
import entites.Skin;
import java.util.ArrayList;

/**
 * La class abstraite Bird normalise la creation des oiseaux donnant acce a une
 * methode un constructeur et une fonction draw.
 */
public class Bird extends Entity {

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
     * Les modules de l'oiseau (pimp my cybird)
     */
    protected ArrayList<ModuleBird> modul = new ArrayList<>();

    /**
     * Le constructeur de l'oiseau
     *
     * @param pigeonX La position de départ en x
     * @param pigeonY La position de départ en y
     * @param fatX Sa largeur
     * @param fatY Sa hauteur
     * @param crb Sa courbe
     * @param corps La couleur principale du pigeon
     * @param m Ses modules
     */
    public Bird(int pigeonX, int pigeonY, int diametre, Courbe crb, Color corps) {
        super(pigeonX, pigeonY, diametre, diametre, crb);
        this.corps = corps;
        r = diametre / 2;
        hb = new Hitbox(pigeonX, pigeonY, diametre, diametre);
    }

    /**
     * La fonction dessine l'oiseau en position x, y et angle a sur le Graphics
     * voulu "g"
     *
     * @param posX La position de l'entite en x
     * @param g Le Graphics sur le quel applique le dessin
     * @return Le Graphics dessine
     */
    protected Skin MinimalBirdFactory(Skin s) {
        s.getG().setColor(corps); // La couleur du pigeon
        s.getG().fillOval(x, y, widht, hight); // Le corp
        s.getG().setColor(Color.black);
        s.getG().drawOval(x, y, widht, hight); // Les contours du corp
        return s;
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
     * @param corps
     */
    public void setCorps(Color corps) {
        this.corps = corps;
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
     * @param over
     * @return
     */
    public Skin drawAllModule(Skin s, boolean over) {
        if (over) {
            for (int i = 0; i < modul.size(); i++) {
                if (modul.get(i).over) {
                    modul.get(i).draw(s);
                }
            }
        } else {
            for (int i = 0; i < modul.size(); i++) {
                if (!modul.get(i).over) {
                    modul.get(i).draw(s);
                }
            }
        }
        return s;
    }

    /**
     * Ajoute un module a l'oiseau
     *
     * @param mb
     */
    public void addModule(ModuleBird mb) {
        modul.add(mb);
        allModul.add(mb);
    }

    @Override
    public Skin draw(Skin s) {
        birdCenterX = getX() + getWidht() / 2;
        birdCenterY = getY() + getHight() / 2;

        super.hb.setPosition(getX(), getY());
        s = drawAllModule(s, false);
        s = MinimalBirdFactory(s);
        s = drawAllModule(s, true);
        return s;
    }
}
