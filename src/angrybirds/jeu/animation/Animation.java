package angrybirds.jeu.animation;

import entites.Skin;

/**
 * Definie la base d'une animation
 */
public abstract class Animation {

    /**
     * Le centre de l'animation en x
     */
    int centreX;
    
    /**
     * Le centre de l'animation en x
     */
    int centreY;

    /**
     * Le temps au demarrage de l'animation
     */
    public int tDepart;

    /**
     * La duree t de l'animation
     */
    public int duree;

    /**
     * Le constructeur
     * @param centreX 
     * @param centreY
     * @param tDepart
     * @param duree 
     */
    public Animation(int centreX, int centreY, int tDepart, int duree) {
        this.centreX = centreX;
        this.centreY = centreY;
        this.tDepart = tDepart;
        this.duree = duree;
    }

    /**
     * L'effet visuel de l'animation si elle doit en avoir une
     * @param s Le skin qui recoit
     * @return Le skin modifie
     */
    public abstract Skin draw(Skin s);
}
