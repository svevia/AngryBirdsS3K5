package entites.obstacle;

import entites.Skin;
import java.awt.Color;
import modele.Courbe;

/**
 * Dessine un obstacle en forme de carre
 */
public class Objectif extends Obstacle {

    /**
     * La couleur du carre
     */
    Color c;

    /**
     * Variable qui indique si l'impact a deja etait fait avec cette obstacle
     */
    boolean boom = true;

    /**
     * Cree un obstacle en forme de carre
     *
     * @param hight La hauteur de l'obstacle
     * @param widht La largeur de l'obstacle
     * @param x La position en x de l'obstacle
     * @param y La position en y de l'obstacle
     * @param c La couleur de l'obstacle
     */
    public Objectif(int x, int y, int hight, int widht, Courbe crb, Color c) {
        super(x, y, widht, hight, crb);
        this.c = c;
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(c);
        s.getG().fillRect(x, y, widht, hight);
        return s;
    }

    @Override
    public void impact() {
        try {
            Thread.sleep(5000);
            ImpactOrder.stopCore();
        } catch (InterruptedException ex) {
            System.out.println("Fin du jeu impossible " + ex.getMessage());
        }
    }
}
