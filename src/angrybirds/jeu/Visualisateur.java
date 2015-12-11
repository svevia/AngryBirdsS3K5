package angrybirds.jeu;

import modele.Courbe;
import java.awt.Graphics;
import static angrybirds.Constante.*;
import entites.Entity;
import entites.Skin;
import java.awt.Color;
import javax.swing.JPanel;
import modele.Calcul;
import static modele.Calcul.angle;
import static modele.Calcul.force;
import static modele.Calcul.diametreCercleDeForce;
import static modele.Calcul.xFocus;
import static modele.Calcul.xFocusActual;
import static modele.Calcul.yFocus;
import static modele.Calcul.yFocusActual;

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
        g = bird.draw(new Skin(g)).getG();
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
            g = obstacle.get(i).draw(new Skin(g)).getG();
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
        for (int i = 0; i < fond.size(); i++) {
            g.drawImage(fond.get(i).getImage(), fond.get(i).getPosX(), fond.get(i).getPosY(), null);
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
        //    g = drawFond(g);
        g = drawFootstep(true, calculTraceFootStep(), 3, (int) vitesse + 3, g);
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
        //Si jamais on a un x/0 on cale un finally ici
        try {
            return (100 / ((int) vitesse + 1)) + 10;
        } finally {
            return (100 / ((int) vitesse + 2)) + 10;
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
        g.drawRect(e.getHb().x, e.getHb().y, e.getHb().w, e.getHb().h);
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

    /**
     * Dessine la courbe dans les limites de la fenetre
     *
     * @param g Le graphics qui recois
     * @param c La courbe a dessiner
     * @return Le graphics modifier
     */
    public Graphics drawCurve(Graphics g, Courbe c) {
        if (c != null) {
            int x, y, t = 0;
            do {
                t++;
                x = (int) c.getXenT(t);
                y = (int) c.getYenT(t);
                g.fillOval(x, y, 3, 3);
            } while (x < fenetre.width && x > 0 && y < fenetre.height && y > 0);
        }
        return g;
    }

    /**
     * Surement la methode du visu la plus proche d'un model
     * @param g Le graphics a modifier
     * @param pane Le panel du graphics
     * @param centreX Le centre de la cible
     * @param centreY Le centre de la cible
     * @return 
     */
    public Graphics drawTarget(Graphics g, JPanel pane, int centreX, int centreY) {
        try {
            xFocusActual = pane.getMousePosition().x;
            yFocusActual = pane.getMousePosition().y;
        } finally {
        }
        xFocus = centreX;
        yFocus = centreY;
        int rayonCentral = diametreCercleDeForce*20/100;
        g.setColor(new Color(50, 50, 200, 50));
        g.fillOval(xFocus - rayonCentral/2, yFocus - rayonCentral/2, rayonCentral, rayonCentral);
        g.drawOval(xFocus - diametreCercleDeForce / 2, yFocus - diametreCercleDeForce / 2, diametreCercleDeForce, diametreCercleDeForce);
        g.drawLine(xFocus, yFocus, xFocusActual, yFocusActual);
        g.setColor(Color.black);
        g.drawString(angle() + " r", xFocus + 10, yFocus - 10);
        g.setColor(Color.red);
        g.drawString(force() + "%", xFocus + 20, yFocus + 10);
        Calcul.setCourbeDragNDrop();
        return g;
    }
}
