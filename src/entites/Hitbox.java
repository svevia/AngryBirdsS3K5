package entites;

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
     * @param o La Hitbox a comparer
     * @return Le numero de l'obstacle en collision ou 0 si rien
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

    /**
     * 
     * @return Retourne la position en x de la Hitbox 
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @param x Change la position en x de la Hitbox
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @return Retourne la position en y de la Hitbox 
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param y Change la positon en y de la Hitbox 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 
     * @return Retourne la dimension de la Hitbox 
     */
    public Dimension getD() {
        return d;
    }

    /**
     * 
     * @param d Change la dimension de la Hitbox
     */
    public void setD(Dimension d) {
        this.d = d;
    }

    /**
     * Met a jour les points x et y en même temps
     * @param x La nouvelle position en x
     * @param y La nouvelle position en y
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    
    /**
     * Met a jour les points x et y et la dimension en même temps
     * @param x La nouvelle position en x
     * @param y La nouvelle position en y
     * @param d La nouvelle dimension
     */
    public void misaAJour(int x, int y, Dimension d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Position : x : " + x + " ; y : " + y + " ; Taille : w " + d.width + " ; h : " + d.height;
    }
}
