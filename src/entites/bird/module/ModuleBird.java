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
     * @param distanceCentre Renvoie la distance entre le module et le centre de l'oiseau
     */
    public void setDistanceCentre(double distanceCentre) {
        this.distanceCentre = distanceCentre;
    }

    /**
     * @return Si il est sur ou sous l'oiseau
     */
    public boolean isOver() {
        return over;
    }

    /**
     * @param over Sur ou sous l'oiseau
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * La representation graphique du module
     * @param s Le skin a drow
     * @return Le skin drow
     */
    abstract public Skin draw(Skin s);

    /**
     * 
     * @return La taille du module
     */
    abstract public int getSize();
}
