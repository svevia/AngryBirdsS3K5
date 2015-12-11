package modele;

import static angrybirds.Constante.bird;
import static angrybirds.Constante.vitesse;
import static modele.Courbe.calculAngle;
import static modele.Courbe.calculDistance;

/**
 * Cette classe, singleton, a pour but de reunir differentes methode de calcul
 * afin de bouger nos entites
 */
public class Calcul {

    /**
     * Position du centre de la cible
     */
    public static int xFocus, yFocus;

    /**
     * Position de la souris lorsque la cible est la
     */
    public static int xFocusActual, yFocusActual;

    /**
     * Rayon de la cible, jedi
     */
    public static int diametreCercleDeForce = 300;

    /**
     * @return Return la puissance du lance en pourcentage
     */
    public static int force() {
        int ret = (int) (((Math.pow((Math.pow((xFocus - xFocusActual), 2) + Math.pow((yFocus - yFocusActual), 2)), 0.5)) / (diametreCercleDeForce/2)) * 100);
        System.out.println((int) (Math.pow((Math.pow((xFocus - xFocusActual), 2) + Math.pow((yFocus - yFocusActual), 2)), 0.5)));
        if (ret > 100) {
            ret = 100;
        }
        return ret;
    }

    /**
     * @return Return l'angle du lance en radian
     */
    public static double angle() {
        double d1 = calculDistance(xFocus, yFocus, xFocusActual, yFocusActual);
        double d2 = calculDistance(xFocus, yFocus, xFocusActual, yFocus);
        double d3 = calculDistance(xFocusActual, yFocus, xFocusActual, yFocusActual);
        if (xFocusActual <= xFocus) {
            d2 = -d2;
        }
        if (yFocusActual <= yFocus) {
            d3 = -d3;
        }
        double a = calculAngle(d1, d2, d3);
        if (yFocusActual <= yFocus) {
            a = -a;
        }
        return a;
    }

    public static void setCourbeDragNDrop() {
        if (angle() < 1.14 && angle() > -1.14 && force() > 20) {
            bird.setA(angle());
            vitesse = force() / 20;
            bird.setCourbe(new Courbe(0, vitesse, bird.getX(), 0.9 / force(), bird.getA(), bird.getY()));
        }
    }
}
