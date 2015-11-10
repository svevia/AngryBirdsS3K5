package ressource;

import static angrybirds.Constante.allIPacketmageRessource;

/**
 * Enumeration contenant tout les fonds
 */
public enum Fond {

    /**
     * Une jolie plaine
     */
    Plaine(allIPacketmageRessource.get("ciel"), allIPacketmageRessource.get("nuage"), allIPacketmageRessource.get("herbe")),
    
    Enfer(allIPacketmageRessource.get("sunset"), allIPacketmageRessource.get("cielnoir"), allIPacketmageRessource.get("volcan"), allIPacketmageRessource.get("solrocheux"));

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
