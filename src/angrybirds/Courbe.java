package angrybirds;

/**
 * Objet permettant de creer une courbe du second degres
 */
public class Courbe {

    double aX, bX, cX;
    double aY, bY, cY;
    int nbMaxY, nbMaxX;

    /**
     * Constructeur vide
     */
    private Courbe() {
    }

    public Courbe(double aX, double bX, double cX, double aY, double bY, double cY) {
        this.aX = aX;
        this.bX = bX;
        this.cX = cX;
        this.aY = aY;
        this.bY = bY;
        this.cY = cY;
    }

    public Courbe(double aX, double bX, double cX, double aY, double bY, double cY, int nbMaxY, int nbMaxX) {
        this.aX = aX;
        this.bX = bX;
        this.cX = cX;
        this.aY = aY;
        this.bY = bY;
        this.cY = cY;
        this.nbMaxY = nbMaxY;
        this.nbMaxX = nbMaxX;
    }

    /**
     * Renvoie la position x du pigeon en temps t
     *
     * @param t
     * @return
     */
    public double getXenT(double t) {
        return (aX * Math.pow(t, 2) + bX * t + cX);
    }

    /**
     * Renvoie la position y du pigeon en temps t
     *
     * @param t
     * @return
     */
    public double getYenT(double t) {
        return (aY * Math.pow(t, 2) + bY * t + cY);
    }

    public double calculDistance(double x1, double y1, double x2, double y2) {
        return (Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5));
    }

    public double calculAngle(double d1, double d2, double d3) {
        double p1 = (Math.pow(d1, 2) + Math.pow(d2, 2) - Math.pow(d3, 2));
        double p2 = 2 * d1 * d2;
        return Math.acos(p1 / p2);
    }

    public double angleAenT(double t) {
        double x = getXenT(t);
        double y = getYenT(t);
        double xP = getXenT(t + 1);
        double yP = getYenT(t + 1);
        double d1 = calculDistance(x, y, xP, yP);
        double d2 = calculDistance(x, y, xP, y);
        double d3 = calculDistance(xP, y, xP, yP);
        if (xP < x) {
            d2 = -d2;
        }
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
