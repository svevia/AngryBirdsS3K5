package Obstacle;

import java.awt.Dimension;

/**
 * HitBox qui définie l'endroit virtuel ou se situe un objet qui contient le
 * contient
 */
public class Hitbox implements Comparable<Hitbox> {

    private int x;

    private int y;

    private Dimension d;

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
        int x1 = o.getX(), x2 = o.getX() + o.getD().width, y1 = o.getY(), y2 = o.getY() + o.getD().height;
        boolean sous = false, dessus = false, droite = false, gauche = false;
        if (x + d.width > x1) {
            droite = true;
        }
        if (x < x2) {
            gauche = true;
        }
        if (y + d.height < y2) {
            dessus = true;
        }
        if (y > y1) {
            sous = true;
        }
        if (droite && dessus && sous) {
            return 1;
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
        this.x = x;
        this.y = y;
    }
}
