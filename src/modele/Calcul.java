package modele;

import static angrybirds.Constante.rayonCercleDeForce;
import static angrybirds.Constante.xFocus;
import static angrybirds.Constante.xFocusActual;
import static angrybirds.Constante.yFocus;
import static angrybirds.Constante.yFocusActual;
import static modele.Courbe.calculAngle;
import static modele.Courbe.calculDistance;

/**
 * Cette classe, singleton, a pour but de reunir differentes methode de calcul
 * afin de bouger nos entites
 */
public class Calcul {

    /**
     * @return Return la puissance du lance en pourcentage
     */
    public static int force() {
        int ret = (int) (Math.pow((Math.pow((xFocus - xFocusActual), 2) + Math.pow((yFocus - yFocusActual), 2)), 0.5)) * rayonCercleDeForce / 100;
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

}
