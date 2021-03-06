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

    public static double laPUISSANCE;

    /**
     * @return Return la puissance du lance en pourcentage
     */
    public static int force(int xFocus, int yFocus, int mouseX, int mouseY, int rayonDeLaForce) {
        int ret = (int) (((pow((pow((xFocus - mouseX), 2) + pow((yFocus - mouseY), 2)), 0.5)) / (rayonDeLaForce / 2)) * 100);
        if (ret > 100) {
            ret = 100;
        }
        return ret;
    }

    /**
     * @return Return l'angle du lance en radian
     */
    public static double angle(int xFocus, int yFocus, int mouseX, int mouseY) {
        double d1 = calculDistance(xFocus, yFocus, mouseX, mouseY);
        double d2 = calculDistance(xFocus, yFocus, mouseX, yFocus);
        double d3 = calculDistance(mouseX, yFocus, mouseX, mouseY);
        if (mouseX <= xFocus) {
            d2 = -d2;
        }
        if (mouseX <= yFocus) {
            d3 = -d3;
        }
        Double a = calculAngle(d1, d2, d3);
        if (mouseY <= yFocus) {
            a = PI + -(a - PI);
        }
        if (a.isNaN()) {
            a = 0.0;
        }
        return a;
    }

    /**
     * Met a jour la courbe du drag and drop (la cible)
     */
    public static void setCourbeDragNDrop(int xFocus, int yFocus, int mouseX, int mouseY, int rayonDeLaForce) {
        if (force(xFocus, yFocus, mouseX, mouseY, rayonDeLaForce) > 20 && angle(xFocus, yFocus, mouseX, mouseY) < 10 && angle(xFocus, yFocus, mouseX, mouseY) > -10) {
            bird.setA(angle(xFocus, yFocus, mouseX, mouseY) + PI);
            vitesse = force(xFocus, yFocus, mouseX, mouseY, rayonDeLaForce) / 10;
            int force = force(xFocus, yFocus, mouseX, mouseY, rayonDeLaForce) - 100;
            force = abs(force);
            laPUISSANCE = force * vitesse; // C'est une question de physique
            laPUISSANCE /= 100000; // Mon pigeon est faible en faite
            /**
             * Explication : La courbe se fait donc avec deux polynomes du
             * second degree Chaque polynome est construit ainsi : Le 1er
             * parametre sert a regler la courbation de la courbe, vue que la
             * puissance viens de la vitesse, plus le pigeon est puissant, plus
             * sa vitesse sera forte ! Si on fait varier la puissance de x, on
             * obtiens des truc bizzares
             *
             * Le 2e parametre sert d'angle
             *
             * Le 3e parametre sert de point de depart
             *
             * Le 2e et le 3e parametre varie que sa soit le 1er ou le 2e
             * polynome
             */
            bird.setCourbe(new Courbe(0, cos(bird.getA()), bird.getX(), laPUISSANCE, sin(bird.getA()), bird.getY()));
            vitesse++;
        }
    }

    /**
     * Fzit tourner une matrice autours de l'origine
     *
     * @param tab La matrice sous forme de tableau
     * @param angle L'angle a ajouter
     * @param cos Si la mtrice est celle des points en abscisse (true) ou en
     * ordonne
     * @return La matrice modifie
     */
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

    /**
     * Fait tourner un seul point autour de l'origine
     *
     * @param x Le point a tourner
     * @param angle L'angle a ajouter
     * @param cos Si le point est en abscisse ou en ordonne
     * @return Le point modifie
     */
    public static int rotation(int x, double angle, boolean cos) {
        if (cos) {
            x = (int) (x * cos(angle));
        } else {
            x = (int) (x * sin(angle));
        }
        return x;
    }

    /**
     * Additionne un chiffre a une matrice
     *
     * @param tab La matrice
     * @param add Le addition
     * @return La matrice additionne
     */
    public static int[] addition(int[] tab, int add) {
        int[] ret = tab; 
        for (int i = 0; i < tab.length; i++) {
            ret[i] = tab[i] + add;
        }
        return ret;
    }

    /**
     * Calcul la courbe d'un point x a toX et y toX
     *
     * @param x L'origine
     * @param y L'origine
     * @param toX La destination final
     * @param toY La destination
     * @return La courbe genere
     */
    public static Courbe calculCourbe(int x, int y, int toX, int toY) {
        Courbe ret = new Courbe(0, toX - x, x, 0, toY - y, y);
        return ret;
    }
}
