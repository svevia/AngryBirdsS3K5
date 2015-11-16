package angrybirds;

/**
 * Objet permettant de creer une courbe du second degres
 */
public class Courbe {

    public Courbe() {
    }

    /**
     * Renvoie la position x du pigeon en temps t
     *
     * @param t
     * @return
     */
    public int getXenT(double t) {
        return (int) (t * 1);
    }

    /**
     * Renvoie la position y du pigeon en temps t
     *
     * @param t
     * @return
     */
    public int getYenT(double t) {
        return (int) (0.0009 * Math.pow(t, 2) + -0.9 * t + (Constante.fenetre.height - 200));
    }

    double calculDistance(int x1, int y1, int x2, int y2) {
        return (Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5));
    }

    double calculAngle(double d1, double d2, double d3) {
        double p1 = (Math.pow(d1, 2) + Math.pow(d2, 2) - Math.pow(d3, 2));
        double p2 = 2 * d1 * d2;
        return Math.acos(p1 / p2);
    }

    double angleAenT(double t) {
        int x = getYenT(t);
        int y = getYenT(t);
        int xP = getXenT(t+1);
        int yP = getYenT(t+1);
        double d1 = calculDistance(x, y, xP, yP);
        double d2 = calculDistance(x, y, xP, y);
        if (xP < x) {
            d2 = -d2;
        }
        double d3 = calculDistance(xP, y, xP, yP);
        if (yP < y) {
            d3 = -d3;
        }
        double a = calculAngle(d1, d2, d3);
        if (yP < y) {
            a = -a;
        }
        return a;
    }
}
