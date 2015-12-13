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
     * Crée une hitbox avec sa position et sa dimension
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
     * @return Le numero de l'obstacle en collision ou 0 si rien
     */
    @Override
    public int compareTo(Hitbox o) {
        if (x + w > o.x && x < o.x + o.w) {
            if (y < o.y + o.h && y + h > o.y) {
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
     * @param w La nouvelle largeur
     * @param h la nouvelle hauteur
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
