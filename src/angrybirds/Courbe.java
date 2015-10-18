package angrybirds;

/**
 * Objet permettant de creer une courbe du second degres
 */
public class Courbe {

    private double a, b, c;

    /**
     * Cree une courbe du type a*x²+b*x+c (second degres)
     *
     * @param a
     * @param b
     * @param c
     */
    public Courbe(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Renvoie la position du pigeon en x
     *
     * @param x
     * @return
     */
    public double getYenX(int x) {
        return (a * Math.pow(x, 2) + b * x + c);
    }

    /**
     * Renvoei le prochain angle qu'aura l'oiseau
     *
     * @param x
     * @return
     */
    public double angleNextD(int x) {
        double d1 = distanceEntreDeuxPoints(x + 1, x, getYenX(x + 1), getYenX(x));
        double d2 = distanceEntreDeuxPoints(x + 1, x + d1, getYenX(x + 1), getYenX(x));
        double angle = calculAngle(d1, d1, d2);

        if (!actualYRiserThanNext(x)) {
            return angle;
        } else {
            return -angle;
        }
    }

    /**
     * Calcule la distance entre deux point (x, y)
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    private double distanceEntreDeuxPoints(double x1, double x2, double y1, double y2) {
        return (Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5));
    }

    /**
     * Calcule l'angle de trois distance dans un triangle isocéle (calcul ici la
     * pointe)
     *
     * @param d1
     * @param d2
     * @param d3
     * @return
     */
    private double calculAngle(double d1, double d2, double d3) {
        double p1 = (Math.pow(d1, 2) + Math.pow(d2, 2) - Math.pow(d3, 2));
        double p2 = 2 * d1 * d2;
        return Math.acos(p1 / p2);
    }

    private boolean actualYRiserThanNext(int x) {
        double actual = getYenX(x);
        double next = getYenX(x + 1);
        return actual > next;
    }
}
