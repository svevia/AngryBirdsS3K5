package angrybirds;

import java.awt.Dimension;
import java.awt.Graphics;
import obstacle.Hitbox;

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
     * Definie une entite en x et y sur une taille donne
     * @param x
     * @param y
     * @param hight
     * @param widht 
     */
    public Entity(int x, int y, int hight, int widht) {
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.widht = widht;
        hb = new Hitbox(x, y, new Dimension(widht, hight));
    }
    
    /**
     * Dessine l'entite sur un Graphics
     * @param g
     * @return 
     */
    public abstract Graphics draw(Graphics g);
}
