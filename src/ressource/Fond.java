package ressource;

import static ressource.AllRessource.*;

/**
 * Enumeration contenant tout les fonds
 */
public enum Fond {

    /**
     * Une jolie plaine
     */
    PLAINE(allImageRessource.get("ciel"), allImageRessource.get("nuage"), allImageRessource.get("herbe"));

    ImageCustomz[] source;

    Fond(ImageCustomz... sources) {
        source = sources;
    }

    /**
     *
     * @return Un tableau d'image customz a afficher
     */
    public ImageCustomz[] getFond() {
        return source;
    }
}
