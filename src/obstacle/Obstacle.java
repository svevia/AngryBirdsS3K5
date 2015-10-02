package obstacle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Class abstraite des obstacles
 * @author Wissam
 */
public abstract class Obstacle {

    /**
     * La hauteur de l'obstacle
     */
    protected int hight;

    /**
     * La largeur de l'obstacle
     */
    protected int widht;

    /**
     * La position en X de l'obstacle
     */
    protected int x;

    /**
     * La position en Y de l'obstacle
     */
    protected int y;

    /**
     * La couleur de l'obstacle
     */
    protected Color c;

    /**
     * La hitbox de l'obstacle
     */
    protected Hitbox hb;
    
    
    /**
     * Cree un obtacle avec sa taille, sa position et sa couleur initiale
     * @param hight Hauteur
     * @param widht Largeur
     * @param x Position aux abscisses
     * @param y Position aux ordonnees
     * @param c Couleur
     */
    public Obstacle(int hight, int widht, int x, int y, Color c) {
        this.hight = hight;
        this.widht = widht;
        this.x = x;
        this.y = y;
        this.c = c;
        hb = new Hitbox(x, y, new Dimension(widht, hight));
    }

    /**
     * Dessine l'obstacle
     * @return 
     */
    public abstract Graphics drawMe(Graphics g);
    
    public abstract Graphics drawMe(int x, int y, Graphics g);
    
    public abstract Graphics drawMe(int x, int y, Color c,Graphics g);

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getWeight() {
        return widht;
    }

    public void setWeight(int weight) {
        this.widht = weight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getWidht() {
        return widht;
    }

    public Hitbox getHb() {
        return hb;
    }
    
    
}
