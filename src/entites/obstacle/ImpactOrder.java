package entites.obstacle;

import static angrybirds.Constante.*;
import angrybirds.jeu.core.HeartMoveBird;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static modele.Calcul.laPUISSANCE;
import modele.Courbe;

/**
 * Une liste d'ordre possible pour la fonction impact des obstacles
 */
public class ImpactOrder {

    /**
     * Le dernier obstacle sur le quel le pigeon a rebondi
     */
    public static Obstacle lastObstacleRebond;

    /**
     * Arrete le jeu
     */
    public static void stopCore() {
        last = true;
    }

    /**
     * Augmente la vitesse de l'oiseau
     */
    public static void burstVitesse(int burst) {
        vitesse += burst;
    }

    /**
     * Diminue la vitesse du pigeon
     */
    public static void downVitesse(int down) {
        vitesse -= down;
        if (vitesse < 1) {
            vitesse = 1;
        }
    }

    /**
     * Detruit l'obstacle qui indique
     *
     * @param o L'obstacle a detruire
     * @return Si l'obstacle a ete detruit
     */
    public static boolean destroy(Obstacle o) {
        obstacle.remove(o);
        return true;
    }

    /**
     * Destruit l'obstacle si le pigeon en a seulement le pouvoir
     *
     * @param o L'obstacle a detruire
     * @param masseMinimal La masse minimal requise
     * @return Si l'obstacle a ete detruit
     */
    public static boolean destroy(Obstacle o, int masseMinimal) {
        if (bird.getMasse() > masseMinimal) {
            return destroy(o);
        }
        return false;
    }

    /**
     *
     * @param e L'entite qui vois sa courbe modifie
     * @param direction La direction que doit prendre l'entite, 1 a gauche, 2
     * vers le haut, 3 a droite, 4 vers le bas
     */
    public static void rebondOiseau(int codeCollision) {
        switch (codeCollision) {
            case 1:
                bird.setA(bird.getA() - Math.PI);
                break;
            case 2:
                bird.setA(bird.getA() - Math.PI);
                break;
            case 3:
            case 4:
            case 7:
            case 8:
                bird.setA(Math.PI * 2 - bird.getA());
                break;
            case 5:
                bird.setA(bird.getA() - Math.PI);
                break;
            case 6:
                bird.setA(bird.getA() - Math.PI);
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                bird.setA(Math.PI - bird.getA());
                break;
        }
        System.out.println(codeCollision);
        HeartMoveBird.internalTime = 0;
        bird.setCourbe(new Courbe(0, cos(bird.getA()), bird.getX(), laPUISSANCE, sin(bird.getA()), bird.getY()));
    }

}
