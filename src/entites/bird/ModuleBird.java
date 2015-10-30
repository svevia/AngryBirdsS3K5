package entites.bird;

import java.awt.Graphics;

/**
 * Un module d'oiseau est un éléments qui se rajoute au corps de l'oiseau en
 * fonction de sa distance au centre de l'oiseau
 */
public abstract class ModuleBird {

    /**
     * L'oiseau a qui appartient le module
     */
    protected Bird b;

    /**
     * L'emplecement par rapport au corps de l'oiseau, sur ou sous l'oiseau sur
     * un plan 2D
     */
    protected boolean over;

    /**
     * Distance comprise entre 0 et 1, plus que 1 mettra le module hors du corp
     * de l'oiseau
     */
    protected double distanceCentre;

    public ModuleBird(double distanceCentre, Bird b, boolean over) {
        this.distanceCentre = distanceCentre;
        this.b = b;
        this.over = over;
    }

    public double getDistanceCentre() {
        return distanceCentre;
    }

    public void setDistanceCentre(double distanceCentre) {
        this.distanceCentre = distanceCentre;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * La representation graphique du module
     *
     * @param g
     */
    abstract public Graphics draw(Graphics g);

//    /**
//     * Cree ou met a jour la Hitbox du module
//     */
//    abstract public void createHitbox();
    abstract public int getSize();
}
