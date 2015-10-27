package angrybirds;

import java.awt.Graphics;
import static angrybirds.Constante.*;

/**
 * Pour une programme en structure MVC, il est necessaire que se qui dessine, se
 * qui est dessine et se qui dit quand on doit dessine ne se melange pas, cette
 * class a donc pour but de faire la liaison entre se que sur quoi on dessine,
 * qui appel un evement et se qui est dessine. Concretement, une class contenant
 * un Graphics veut qu'on lui ajoute en dessin, un oiseau, un obstacle ou une
 * empreintes full ou partiel, la class Viasualisateur prendra donc en parametre
 * se qu'on veut, ou on veut et sur quoi on le veut pour le mettre.
 */
public class Visualisateur {

    /**
     * Dessine l'oiseau en x, y et a sur g
     *
     * @param x Position en x
     * @param y Position en y
     * @param a Angle en a
     * @param g Graphics qui recoit le dessin
     * @return Le Graphics modefie
     */
    public Graphics drawOiseau(Graphics g) {
        g = bird.draw(g);
        return g;
    }

    /**
     * Dessine les toute ou partiellement les empreintes
     *
     * @param full Si on les veut toute ou pas
     * @param part Le nombre d'empreinte si full = false
     * @param g Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public Graphics drawFootstep(boolean full, int part, Graphics g) {
        if (full) {
            g = footstep.drawAllFootstep(g);
        } else {
            g = footstep.drawFootstep(part, g);
        }
        return g;
    }

    /**
     * Dessine les obstacles
     *
     * @param g Le Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public Graphics drawObstacle(Graphics g) {
        for (int i = 0; i < obstacle.size(); i++) {
            g = obstacle.get(i).draw(g);
        }
        return g;
    }

    /**
     * Dessine le fond
     *
     * @param g Le Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public Graphics drawFond(Graphics g) {
        g.drawImage(fond.getFond(), 0, 0, null);
        return g;
    }

    /**
     * Dessinne tout se qu'il faut pour avoir le jeu
     * C'est a dire le fond, le trace, l'oiseau et les obstacles
     * @param g Le Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public Graphics drawAllNeed(Graphics g) {
        g = drawFond(g);
        g = drawFootstep(false, 20, g);
        g = drawOiseau(g);
        g = drawObstacle(g);
        return g;
    }
}
