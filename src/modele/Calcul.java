package modele;

import static angrybirds.Constante.bird;
import static angrybirds.Constante.vitesse;
import static modele.Courbe.calculAngle;
import static modele.Courbe.calculDistance;
import static java.lang.Math.*;

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
        int ret = (int) (((pow((pow((xFocus - xFocusActual), 2) + pow((yFocus - yFocusActual), 2)), 0.5)) / (diametreCercleDeForce / 2)) * 100);
        System.out.println((int) (pow((pow((xFocus - xFocusActual), 2) + pow((yFocus - yFocusActual), 2)), 0.5)));
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
            a = PI + -(a -PI);
        }
        return a;
    }

    /**
     * Met a jour la courbe du drag and drop (la cible)
     */
    public static void setCourbeDragNDrop() {
        if (force() > 20 && angle() < 10 && angle() > -10) {
            bird.setA(angle() + PI);
            vitesse = force() / 20;
            Courbe potentielC = Calcul.calculCourbe(xFocus, yFocus, xFocusActual, yFocusActual);
            bird.setCourbe(potentielC);
            bird.setCourbe(new Courbe(0.009 / force(), cos(bird.getA()), bird.getX(), 0.009 / force(), sin(bird.getA()), bird.getY()));
        }
    }

    public static int[] rotation(int[] tab, double angle, boolean cos) {
        for (int i = 0; i < tab.length; i++) {
            if (cos) {
                tab[i] = (int) (tab[i] * cos(angle));
            } else {
                tab[i] = (int) (tab[i] * sin(angle));
            }
        }
        return tab;
    }

    public static int rotation(int x, double angle, boolean cos) {
        if (cos) {
            x = (int) (x * cos(angle));
        } else {
            x = (int) (x * sin(angle));
        }
        return x;
    }

    public static int[] addition(int[] tab, int add) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (tab[i] + add);
        }
        return tab;
    }

    public static Courbe calculCourbe(int x, int y, int toX, int toY) {
        Courbe ret = new Courbe(0, toX - x, x, 0, toY - y, y);
        return ret;
    }
}
