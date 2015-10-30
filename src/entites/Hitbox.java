package entites;

import angrybirds.Constante;
import java.awt.Dimension;

/**
 * HitBox qui définie l'endroit virtuel ou se situe un objet qui contient le
 * contient
 */
public class Hitbox implements Comparable<Hitbox> {

    /**
     * Position en x de la Hitbox
     */
    private int x;

    /**
     * Position en y en de la Hitbox
     */
    private int y;

    /**
     * Dimension d'une Hitbox carre
     */
    private Dimension d;

    /**
     * Crée une hitbox avec sa position et sa dimension
     *
     * @param x position aux abscisses
     * @param y position aux ordonnees
     * @param d dimensions de la hitbox
     */
    public Hitbox(int x, int y, Dimension d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    /**
     * Fonction qui gere les collisions ULTRA SIMPLIFIEE
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Hitbox o) {
        if (x + d.width > o.x && x < o.x + o.d.width) {
            if (y < o.y + o.d.height && y + d.height > o.y) {
                return 1;
            }
        }
        return 0;
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

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public void misaAJour(int x, int y, Dimension d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void misaAJour(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position : x : " + x + " ; y : " + y + " ; Taille : w " + d.width + " ; h : " + d.height;
    }
}
