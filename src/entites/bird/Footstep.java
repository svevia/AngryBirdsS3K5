package entites.bird;

import java.awt.Color;
import java.awt.Graphics;
import static angrybirds.Constante.*;
import java.util.ArrayList;
import static java.awt.Color.*;

/**
 * L'enumeration qui contient tout les skins d'empreinte et les fonctions
 * associees
 */
public enum Footstep {

    /**
     * Sans couleur
     */
    NONE(),
    /**
     * Couleur simple rouge
     */
    ROUGE(red),
    /**
     * Couleur simple noir
     */
    NOIR(black),
    /**
     * Au couleur de l'arc en ciel
     */
    ARCENCIEL(magenta, blue, cyan, green, yellow, ORANGE, red),
    /**
     * Au couleur du drapeau Allemand
     */
    BRETZEL(BLACK, RED, YELLOW),
    /**
     * Au couleur du drapeau de la gaypride
     */
    GAY(red, orange, yellow, green, blue, magenta),
    /**
     * Couleur simple rose
     */
    ROSE(pink),
    /**
     * Au couleur du serpent vert et noir
     */
    RAZER(black, new Color(2, 255, 4), black),
    /**
     * Aux couleurs des pays bas
     */
    NEERLANDE(red, red, white, white, blue, blue),
    /**
     * Aux couleurs des USA
     */
    USA(red, white, red, white, red, white, red, white, red, white, red, white, red),
    /**
     * au couleur du drapeau Russe
     */
    VODKA(WHITE, BLUE, RED);

    /**
     * La liste des couleurs du skin
     */
    private Color[] c;

    /**
     * Constructeur prenant en parametre une liste de couleurs
     *
     * @param c
     */
    Footstep(Color... c) {
        this.c = c;
    }

    /**
     * Return un tableau des couleurs d'un skin
     *
     * @return
     */
    public Color[] getC() {
        return c;
    }

    /**
     * Dessinne une partie des empreintes Methode obselete
     *
     * @param tailleVerticale
     * @param g Graphique sur le quel il s'applique
     * @param tailleHorizontale
     * @return
     */
    @Deprecated
    public Graphics drawFootstep(int tailleVerticale, int tailleHorizontale, Graphics g) {
        if (!footstepA.isEmpty()) {
            int[] xP = new int[4], yP = new int[4];
            footstepX.stream().forEach((Integer i) -> {
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
            });
        }
        return g;
    }

    /**
     * Dessinne toute les empreintes
     *
     * @param tailleVerticale
     * @param tailleHorizontale
     * @param g Graphique sur le quel il s'applique
     * @return
     */
    public Graphics drawAllFootstep(int tailleVerticale, int tailleHorizontale, Graphics g) {
        if (!footstepA.isEmpty()) {
            try {
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
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return g;
    }

    /**
     * @return La liste des footsteps
     */
    public static ArrayList<String> getListFootstep() {
        ArrayList<String> al = new ArrayList<>();
        for (Footstep f : Footstep.values()) {
            al.add(f.toString());
        }
        return al;
    }
}
