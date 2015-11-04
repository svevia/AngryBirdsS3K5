package entites.bird;

import java.awt.Color;
import java.awt.Graphics;
import static angrybirds.Constante.*;

/**
 * L'enumeration qui contient tout les skins d'empreinte et les fonctions associees
 */
public enum Footstep {

    /**
     * Sans couleur
     */
    NONE(),

    /**
     * Couleur simple rouge
     */
    ROUGE(Color.red),

    /**
     * Couleur simple noir
     */
    NOIR(Color.black),

    /**
     * Au couleur de l'arc en ciel
     */
    ARCENCIEL(Color.magenta, Color.blue, Color.cyan, Color.green, Color.yellow, Color.ORANGE, Color.red),
    
    /**
     * Au couleur du drapeau Allemand
     */
    BRETZEL(Color.BLACK, Color.RED, Color.YELLOW),

    /**
     * Au couleur du drapeau de la gaypride
     */
    GAY(Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta),

    /**
     * Couleur simple rose
     */
    ROSE(Color.pink),

    /**
     * Au couleur du serpent vert et noir
     */
    RAZER(Color.black, new Color(2, 255, 4), Color.black),

    /**
     * Aux couleurs des pays bas
     */
    NEERLANDE(Color.red, Color.red, Color.white, Color.white, Color.blue, Color.blue),

    /**
     *  Aux couleurs des USA
     */
    USA(Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red),
    
    /**
     * au couleur du drapeau Russe
     */
    VODKA(Color.WHITE, Color.BLUE, Color.RED );

    /**
     * La liste des couleurs du skin
     */
    private Color[] c;

    /**
     * Constructeur prenant en parametre une liste de couleurs
     * @param c 
     */
    Footstep(Color... c) {
        this.c = c;
    }

    /**
     * Return un tableau des couleurs d'un skin
     * @return 
     */
    public Color[] getC() {
        return c;
    }

    /**
     * Dessinne une partie des empreintes
     * @param part Nombre de pas a dessiner a partir de l'entite
     * @param tailleVerticale
     * @param g Graphique sur le quel il s'applique
     * @param tailleHorizontale
     * @return 
     */
    public Graphics drawFootstep(int part, int tailleVerticale, int tailleHorizontale, Graphics g) {
        int[] xP = new int[4], yP = new int[4];
        int i = (footstepX.size() - part < 0)?0:footstepX.size() - part;
        for (i = i; i < footstepX.size(); i++) {
            for (int j = 0; j < c.length; j++) {
                g.setColor(c[j]);
                xP[0] = footstepX.get(i);
                xP[1] = footstepX.get(i) + tailleHorizontale;
                xP[2] = footstepX.get(i) + tailleHorizontale;
                xP[3] = footstepX.get(i);
                yP[0] = footstepY.get(i) + j * tailleVerticale;
                yP[1] = (int) (footstepY.get(i) + footstepA.get(i)) + j * tailleVerticale;
                yP[2] = (int) (footstepY.get(i) + footstepA.get(i)) + tailleVerticale + j * tailleVerticale;
                yP[3] = footstepY.get(i) + tailleVerticale + j * tailleVerticale;
                g.fillPolygon(xP, yP, 4);
            }
        }
        return g;
    }
    
    /**
     * Dessinne toute les empreintes
     * @param tailleVerticale
     * @param tailleHorizontale
     * @param g Graphique sur le quel il s'applique
     * @return 
     */
    public Graphics drawAllFootstep(int tailleVerticale, int tailleHorizontale, Graphics g) {
        int[] xP = new int[4], yP = new int[4];
        for (int i = 0; i < footstepX.size(); i++) {
            for (int j = 0; j < c.length; j++) {
                g.setColor(c[j]);
                xP[0] = footstepX.get(i);
                xP[1] = footstepX.get(i) + tailleHorizontale;
                xP[2] = footstepX.get(i) + tailleHorizontale;
                xP[3] = footstepX.get(i);
                yP[0] = footstepY.get(i) + j * tailleVerticale;
                yP[1] = (int) (footstepY.get(i) + footstepA.get(i)) + j * tailleVerticale;
                yP[2] = (int) (footstepY.get(i) + footstepA.get(i)) + tailleVerticale + j * tailleVerticale;
                yP[3] = footstepY.get(i) + tailleVerticale + j * tailleVerticale;
                g.fillPolygon(xP, yP, 4);
            }
        }
        return g;
    }}
