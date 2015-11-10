package angrybirds;

import java.awt.Graphics;
import static angrybirds.Constante.*;
import entites.Entity;
import java.awt.Color;
import ressource.AllRessource;

/**
 * Pour une programme en structure MVC, il est necessaire que se qui dessine, se
 * qui est dessine et se qui dit quand on doit dessine ne se melange pas, cette
 * classe a donc pour but de faire la liaison entre se que sur quoi on dessine,
 * qui appel un evement et se qui est dessine. Concretement, une classe
 * contenant un Graphics veut qu'on lui ajoute en dessin, un oiseau, un obstacle
 * ou une empreintes full ou partiel, la classe Viasualisateur prendra donc en
 * parametre se qu'on veut, ou on veut et sur quoi on le veut pour le mettre.
 */
public class Visualisateur {

    /**
     * Dessine l'oiseau en x, y et a sur g
     *
     * @param y Position en y
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
     * @param tailleVerticale
     * @param g Graphics qui recoit le dessin
     * @param tailleHorizontale
     * @return Le Graphics modifie
     */
    public Graphics drawFootstep(boolean full, int part, int tailleVerticale, int tailleHorizontale, Graphics g) {
        if (full) {
            g = footstep.drawAllFootstep(tailleVerticale, tailleHorizontale, g);
        } else {
            g = footstep.drawFootstep(part, tailleVerticale, tailleHorizontale, g);
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
        for (int i = 0; i < fond.getFond().length; i++) {
            g.drawImage(fond.getFond()[i].getImage(), fond.getFond()[i].getPosX(), fond.getFond()[i].getPosY(), null);
        }
        return g;
    }

    /**
     * Dessinne tout se qu'il faut pour avoir le jeu C'est a dire le fond, le
     * trace, l'oiseau et les obstacles
     *
     * @param g Le Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public Graphics drawAllNeed(Graphics g) {
        g = drawFond(g);
        g = drawFootstep(false, calculTraceFootStep(), 3, vitesse + 3, g);
        g = drawOiseau(g);
        g = drawObstacle(g);
        return g;
    }

    /**
     * Calcule le nombre de trace laisse par le footstep
     *
     * @return Le nombre de point que doit garder le footstep en memoire
     */
    private int calculTraceFootStep() {
        //Si jamais on a un 60/0 on cale un finally ici
        try {
            return (60 / (vitesse + 1)) + 10;
        } finally {
            return (60 / (vitesse + 2)) + 10;
        }
    }

    /**
     * Dessine les contours de la hitbox d'une entite
     *
     * @param e
     * @param g
     * @param c
     * @return
     */
    public Graphics drawHitBox(Entity e, Graphics g, Color c) {
        g.setColor(c);
        g.drawRect(e.getHb().getX(), e.getHb().getY(), e.getHb().getD().width, e.getHb().getD().height);
        return g;
    }

    /**
     * Dessine la hitbox de toute les entite, en bleu l'oiseau, en noir les
     * obstacles
     *
     * @param g
     * @return
     */
    public Graphics drawAllHitBox(Graphics g) {
        for (int i = 0; i < obstacle.size(); i++) {
            g = drawHitBox(obstacle.get(i), g, Color.black);
        }
        g = drawHitBox(bird, g, Color.red);
        return g;
    }
}
