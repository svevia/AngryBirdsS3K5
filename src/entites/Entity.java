package entites;

import java.awt.Graphics;

/**
 * Donne les parametres minimale pour obtenir une entitee utilisable sur le jeu
 */
public abstract class Entity {

    /**
     * Position en x sur la fenetre
     */
    protected int x;

    /**
     * Position en y sur la fenetre
     */
    protected int y;

    /**
     * La hauteur de l'entitie
     */
    protected int hight;

    /**
     * La largeur de l'entite
     */
    protected int widht;

    /**
     * La hitbox de l'entite
     */
    protected Hitbox hb;

    /**
     * Definie une entite en x et y sur une taille donne avec sa Hitbox carre
     *
     * @param x La position en x de l'entite
     * @param y La position en y de l'entite
     * @param hight La hauteur de l'entite
     * @param widht La largeur de l'entite
     */
    public Entity(int x, int y, int hight, int widht) {
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.widht = widht;
        hb = new Hitbox(x, y, widht, hight);
    }

    /**
     *
     * @return La position de l'entite en x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x La position de l'entite en x a changer
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return La position de l'entite en y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y La position de l'entite en y a changer
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return La hauteur de l'entite
     */
    public int getHight() {
        return hight;
    }

    /**
     *
     * @param hight La hauteur de l'entite a changer
     */
    public void setHight(int hight) {
        this.hight = hight;
    }

    /**
     *
     * @return La largeur de l'entite
     */
    public int getWidht() {
        return widht;
    }

    /**
     *
     * @param widht La largeur de l'entite a changer
     */
    public void setWidht(int widht) {
        this.widht = widht;
    }

    /**
     * 
     * @return La Hitbox de l'entite 
     */
    public Hitbox getHb() {
        return hb;
    }

    /**
     * 
     * @param hb La Hitbox a changer 
     */
    public void setHb(Hitbox hb) {
        this.hb = hb;
    }

    /**
     * Dessine l'entite sur un Graphics
     *
     * @param g le Graphics sur le quel dessiner
     * @return Le Graphics modifie
     */
    public abstract Skin draw(Skin g);
}
