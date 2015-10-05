package obstacle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static angrybirds.Constante.obstacle;
import java.util.ArrayList;

/**
 * Class abstraite des obstacles
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
     *
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
     *
     * @param g
     * @return
     */
    public abstract Graphics drawMe(Graphics g);

    /**
     * Dessine l'obstacle en une position donne
     *
     * @param x
     * @param y
     * @param g
     * @return
     */
    public abstract Graphics drawMe(int x, int y, Graphics g);

    /**
     * Dessine l'obstacle en une position donne et en une couleur specifie
     *
     * @param x
     * @param y
     * @param c
     * @param g
     * @return
     */
    public abstract Graphics drawMe(int x, int y, Color c, Graphics g);

    /**
     *
     * @return
     */
    public int getHight() {
        return hight;
    }

    /**
     *
     * @param hight
     */
    public void setHight(int hight) {
        this.hight = hight;
    }

    /**
     *
     * @return
     */
    public int getWeight() {
        return widht;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(int weight) {
        this.widht = weight;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public Color getC() {
        return c;
    }

    /**
     *
     * @param c
     */
    public void setC(Color c) {
        this.c = c;
    }

    /**
     *
     * @return
     */
    public int getWidht() {
        return widht;
    }

    /**
     *
     * @return
     */
    public Hitbox getHb() {
        return hb;
    }

    /**
     * Ajoute un obstacle
     *
     * @param o Obstacle a ajouter
     */
    static public void addObstacle(Obstacle o) {
        obstacle.add(o);
    }

    /**
     * Ajoute une liste d'obstacle a la liste principal
     *
     * @param o La liste
     */
    static public void addListObstacle(Obstacle... o) {
        for (Obstacle oi : o) {
            addObstacle(oi);
        }
    }

    /**
     * Retire l'obstacle numero i
     *
     * @param i L'index de l'obstacle
     */
    static public void removeObstacle(int i) {
        obstacle.remove(i);
    }

    /**
     * Retire tout les obstacles
     */
    static public void removeAllObstacle() {
        obstacle = new ArrayList<>();
    }

    /**
     * Retire tout les obstacles d'un certain type
     *
     * @param o Le type
     */
    static public void removeAllSpecifiedKindObstacle(Obstacle o) {
        for (int i = 0; i < obstacle.size(); i++) {
            obstacle.remove(o);
        }
    }
    
}
