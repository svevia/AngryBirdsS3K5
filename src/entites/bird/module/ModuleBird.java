package entites.bird.module;

import entites.Skin;
import entites.bird.Bird;

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
    public boolean over;

    /**
     * Distance comprise entre 0 et 1, plus que 1 mettra le module hors du corp
     * de l'oiseau
     */
    protected double distanceCentre;

    /**
     *
     * @param distanceCentre
     * @param b
     * @param over
     */
    public ModuleBird(double distanceCentre, Bird b, boolean over) {
        this.distanceCentre = distanceCentre;
        this.b = b;
        this.over = over;
    }

    /**
     *
     * @return
     */
    public double getDistanceCentre() {
        return distanceCentre;
    }

    /**
     *
     * @param distanceCentre
     */
    public void setDistanceCentre(double distanceCentre) {
        this.distanceCentre = distanceCentre;
    }

    /**
     *
     * @return
     */
    public boolean isOver() {
        return over;
    }

    /**
     *
     * @param over
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * La representation graphique du module
     *
     * @param g
     * @return
     */
    abstract public Skin draw(Skin s);

    /**
     * 
     * @return 
     */
    abstract public int getSize();
}
