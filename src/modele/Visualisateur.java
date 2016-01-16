package modele;

import java.awt.Graphics;
import static angrybirds.Constante.*;
import angrybirds.jeu.animation.Animation;
import static angrybirds.jeu.core.HeartCore.t;
import entites.Entity;
import entites.Skin;
import entites.obstacle.Obstacle;
import extra.lasergame.Miroir;
import extra.lasergame.Objectif;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Bibliotheque de dessin a draw, le pauvre est devenu un singleton maintenant
 */
public class Visualisateur {

    public static ArrayList<Animation> listeAnimationToDraw = new ArrayList<Animation>();

    /**
     * Dessine l'oiseau en x, y et a sur g
     *
     * @return Le Graphics modefie
     */
    public static Graphics drawOiseau(Graphics g) {
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
    public static Graphics drawFootstep(int tailleVerticale, int tailleHorizontale, Graphics g) {
        g = footstep.drawAllFootstep(tailleVerticale, tailleHorizontale, g);
        return g;
    }

    /**
     * Dessine les obstacles
     *
     * @param g Le Graphics qui recoit le dessin
     * @return Le Graphics modifie
     */
    public static Graphics drawObstacle(Graphics g) {
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
    public static Graphics drawFond(Graphics g) {
        for (int i = 0; i < fond.size(); i++) {
            g.drawImage(fond.get(i).getImage(), fond.get(i).getPosX(), fond.get(i).getPosY(), null);
        }
        return g;
    }

    /**
     * Calcule le nombre de trace laisse par le footstep Methode obselete, a
     * l'époque elle servait a deduire le nombre de pas qu'il fallait dessiner
     * pour ne pas faire lagguer le jeu
     *
     * @return Le nombre de point que doit garder le footstep en memoire
     */
    public static int calculTraceFootStep() {
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
    public static Graphics drawHitBox(Entity e, Graphics g, Color c) {
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
    public static Graphics drawAllHitBox(Graphics g) {
        for (int i = 0; i < obstacle.size(); i++) {
            g = drawHitBox(obstacle.get(i), g, Color.black);
        }
        if (bird != null) {
            g = drawHitBox(bird, g, Color.red);
        }
        return g;
    }

    /**
     * Dessine la courbe dans les limites de la fenetre
     *
     * @param g Le graphics qui recois
     * @param c La courbe a dessiner
     * @return Le graphics modifier
     */
    public static Graphics drawCurve(Graphics g, Courbe c) {
        if (c != null) {
            int x, y, t = 0;
            do {
                t++;
                x = (int) c.getXenT(t) + bird.getWidht() / 2;
                y = (int) c.getYenT(t) + bird.getHight() / 2;
                g.fillOval(x, y, 3, 3);
            } while (x < fenetre.width && x > 0 && y < fenetre.height && y > 0);
        }
        return g;
    }

    /**
     * Dessine la courbe dans les limites de la fenetre
     *
     * @param g Le graphics qui recois
     * @param c La courbe a dessiner
     * @return Le graphics modifier
     */
    public static Graphics drawCurveLaser(Graphics g, Courbe c) {
        boolean fin = false;
        if (c != null) {
            int x, y, t = 0;
            do {
                t++;
                x = (int) c.getXenT(t) + bird.getWidht() / 2;
                y = (int) c.getYenT(t) + bird.getHight() / 2;
                if (t < 500) {
                    g.fillOval(x, y, 3, 3);
                } else {
                    g.fillOval(x, y, 2, 3);
                }
                for (Obstacle o : obstacle) {
                    if (o instanceof Objectif && x > o.getX() && y > o.getY() && y < (o.getY() + o.getHight()) && (x < o.getX() + o.getWeight())) {
                        fin = true;
                    }
                    if (o instanceof Miroir && x > o.getX() && y > o.getY() && y < (o.getY() + o.getHight()) && (x < o.getX() + o.getWeight())) {
                        System.out.println(c);
                        c.cX = x;
                        c.cY = y;
                        c.bX = c.bX + Math.PI;
                        c.bY = c.bY + Math.PI;
                        t = 0;
                    }
                }
                if (!(x < fenetre.width && x > 0 && y < fenetre.height && y > 0)) {
                    fin = true;
                }
            } while (!fin);
        }

        return g;
    }

    /**
     * Dessine une cible sur un graphics
     *
     * @param g Le graphics a modifier
     * @param mouseX La position de la souris
     * @param mouseY La position de la souris
     * @param centreX Le centre de la cible
     * @param centreYLe centre de la cible
     * @return Le graphics modifie
     */
    public static Graphics drawTarget(Graphics g, int mouseX, int mouseY, int centreX, int centreY) {
        Skin s = new Skin(g);
        target.draw(s, centreX, centreY, mouseX, mouseY);
        // Met a jour la courbe a chaque changement de l'etat de la cible
        Calcul.setCourbeDragNDrop(centreX, centreY, mouseX, mouseY, target.getRayonDeLaForce());
        return s.getG();
    }

    /**
     * Dessine une cible sur un graphics
     *
     * @param g Le graphics a modifier
     * @param mouseX La position de la souris
     * @param mouseY La position de la souris
     * @param centreX Le centre de la cible
     * @param centreYLe centre de la cible
     * @return Le graphics modifie
     */
    public static Graphics drawTargetLaser(Graphics g, int mouseX, int mouseY, int centreX, int centreY) {
        Skin s = new Skin(g);
        target.draw(s, centreX, centreY, mouseX, mouseY);
        // Met a jour la courbe a chaque changement de l'etat de la cible
        Calcul.setCourbeDragNDrop(centreX, centreY, mouseX, mouseY, 0);
        return s.getG();
    }

    /**
     * Dessine toute les animations du jeu
     *
     * @param g Le graphics sur quoi les dessiner
     * @return Le graphics modifie
     */
    public static Graphics drawAnimation(Graphics g) {
        for (Animation a : listeAnimationToDraw) {
            g = a.draw(new Skin(g)).getG();
            // Si la durée expire, l'animation est retiré
            if (t - a.tDepart >= a.duree) {
                listeAnimationToDraw.remove(a);
            }
        }
        return g;
    }
}
