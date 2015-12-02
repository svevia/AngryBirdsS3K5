package entites.obstacle;

import entites.Hitbox;
import java.awt.Color;
import static angrybirds.Constante.obstacle;
import modele.Courbe;
import entites.Entity;
import java.util.ArrayList;

/**
 * Class abstraite des obstacles
 */
public abstract class Obstacle extends Entity{
    
    /**
     * La couleur de l'obstacle
     */
    protected Color c;

    /**
     * Cree un obtacle avec sa taille, sa position et sa couleur initiale
     *
     * @param hight Hauteur
     * @param widht Largeur
     * @param x Position aux abscisses
     * @param y Position aux ordonnees
     * @param c Couleur
     */
    public Obstacle(int x, int y, int widht, int hight, Courbe crb, Color c) {
        super(x , y, hight, widht, crb);
        this.c = c;
    }

    /**
     *
     * @return Return la hauteur de l'entite
     */
    public int getHight() {
        return hight;
    }

    /**
     *
     * @param hight
     */
    public void setHight(int hight) {
        if(hight > 0)
            this.hight = hight;
        else
            this.hight = 42;
    }

    /**
     *
     * @return Return la largeur de l'entite
     */
    public int getWeight() {
        return widht;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(int weight) {
        if(weight > 0)
            this.widht = weight;
        else
            this.widht = 42;
    }

    /**
     *
     * @return Return la position en x de l'entite
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
        this.hb.setX(x);
    }

    /**
     *
     * @return Return la position en y de l'entite
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
        this.hb.setY(y);
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
     * Ajoute une liste d'obstacle a la liste principal
     *
     * @param o La liste
     */
    static public void addListObstacle(ArrayList<Obstacle> o) {
        obstacle = o;
    }

    /**
     * Retire l'obstacle numero i
     *
     * @param i L'index de l'obstacle
     */
    static public void removeObstacle(int i) {
        if(i < obstacle.size())
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
