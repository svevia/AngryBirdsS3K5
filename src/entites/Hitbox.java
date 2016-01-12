package entites;

/**
 * HitBox qui définie l'endroit virtuel ou se situe un objet qui contient le
 * contient
 */
public class Hitbox implements Comparable<Hitbox> {

    /**
     * Position en x de la Hitbox
     */
    public int x;

    /**
     * Position en y en de la Hitbox
     */
    public int y;

    /**
     * La largeur d'une Hitbox carre
     */
    public int w;

    /**
     * La hauteur d'une Hitbox carre
     */
    public int h;

    /**
     * Cree une hitbox avec sa position et sa dimension
     *
     * @param x position aux abscisses
     * @param y position aux ordonnees
     * @param w largeur de la hitbox
     * @param h hauteur de la hitbox
     */
    public Hitbox(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * Fonction qui gere les collisions ULTRA SIMPLIFIEE
     *
     * @param o La Hitbox a comparer
     * @return 1 si collision si non 0
     */
    @Deprecated
    public int simpleCompareTo(Hitbox o) {
        if (x + w > o.x && x < o.x + o.w) {
            if (y < o.y + o.h && y + h > o.y) {
                return 1;
            }
        }
        return 0;
    }
    
    /**
     * Fonction qui gere les collisions ameliore
     * @param o L'obstacle en question, sa hitbox
     * @return L'impact de la collision
     */
    @Override
    public int compareTo(Hitbox o) {
        int xb1 = x;
        int xb2 = x + w;
        int yb1 = y;
        int yb2 = y + h;
        int x1 = o.x;
        int x2 = o.x + o.w;
        int y1 = o.y;
        int y2 = o.y + o.h;

        if (xb2 >= x1 && xb1 <= x2 && yb1 <= y2 && yb2 >= y1) {
            if (yb1 <= y1 && yb1 <= y2 && yb2 >= y1 && yb2 <= y2) {
                if (xb1 <= x1 && xb1 <= x2 && xb2 >= x1 && xb2 <= x2) {
                    return 1;
                }
                if (xb1 >= x1 && xb1 <= x2 && xb2 >= x1 && xb2 >= x2) {
                    return 2;
                }
                if (xb1 >= x1 && xb1 <= x2 && xb2 >= x1 && xb2 <= x2) {
                    return 3;
                }
                if (xb1 <= x1 && xb1 <= x2 && xb2 >= x1 && xb2 >= x2) {
                    return 4;
                }
            }
            if (yb1 >= y1 && yb1 <= y2 && yb2 >= y1 && yb2 >= y2) {
                if (xb1 <= x1 && xb1 <= x2 && xb2 >= x1 && xb2 <= x2) {
                    return 5;
                }
                if (xb1 >= x1 && xb1 <= x2 && xb2 >= x1 && xb2 >= x2) {
                    return 6;
                }
                if (xb1 >= x1 && xb1 <= x2 && xb2 >= x1 && xb2 <= x2) {
                    return 7;
                }
                if (xb1 <= x1 && xb1 <= x2 && xb2 >= x1 && xb2 >= x2) {
                    return 8;
                }
            }
            if (xb1 <= x1 && xb1 <= x2 && xb2 >= x1 && xb2 <= x2) {
                if (yb1 >= y1 && yb1 <= y2 && yb2 >= y1 && yb2 <= y2) {
                    return 9;
                }
                if (yb1 <= y1 && yb1 <= y2 && yb2 >= y1 && yb2 >= y2) {
                    return 10;
                }
            }
            if (xb1 >= x1 && xb1 <= x2 && xb2 >= x1 && xb2 >= x2) {
                if (yb1 >= y1 && yb1 <= y2 && yb2 >= y1 && yb2 <= y2) {
                    return 11;
                }
                if (yb1 <= y1 && yb1 <= y2 && yb2 >= y1 && yb2 >= y2) {
                    return 12;
                }
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
     * Met a jour les points x et y en même temps
     *
     * @param x La nouvelle position en x
     * @param y La nouvelle position en y
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Met a jour les points x et y et la dimension en même temps
     *
     * @param x La nouvelle position en x
     * @param y La nouvelle position en y
     * @param d La nouvelle dimension
     */
    public void misaAJour(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Position : x : " + x + " ; y : " + y + " ; Taille : w " + w + " ; h : " + h;
    }
}
