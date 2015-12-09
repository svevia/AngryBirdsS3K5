package modele;

/**
 * Objet permettant de creer une courbe a partir de deux polynomes du second
 * degres
 */
public class Courbe {

    /**
     * Valeur du premier polynome
     */
    double aX, bX, cX;

    /**
     * Valeur du second polynome
     */
    double aY, bY, cY;

    /**
     * Valeur d'arret de la courbe
     */
    int mouvementMax;

    /**
     * Sens de la courbe
     */
    boolean sens = true;

    /**
     * Si l'obstacle doit faire demi tour ou pas
     */
    boolean demiTour = false;

    /**
     * Valeur a retirer pour faire demi tour
     */
    int soustracteur = 0;

    /**
     * Constructeur vide
     */
    private Courbe() {
    }

    /**
     * Construit la courbe a partir de deux polynomes
     *
     * @param aX
     * @param bX
     * @param cX
     * @param aY
     * @param bY
     * @param cY
     */
    public Courbe(double aX, double bX, double cX, double aY, double bY, double cY) {
        this.aX = aX;
        this.bX = bX;
        this.cX = cX;
        this.aY = aY;
        this.bY = bY;
        this.cY = cY;
    }

    /**
     * Construit la courbe a partir de deux polynomes et une valeur de demi tour
     *
     * @param aX
     * @param bX
     * @param cX
     * @param aY
     * @param bY
     * @param cY
     * @param mouvementMax
     * @param demiTour
     */
    public Courbe(double aX, double bX, double cX, double aY, double bY, double cY, int mouvementMax, boolean demiTour) {
        this.aX = aX;
        this.bX = bX;
        this.cX = cX;
        this.aY = aY;
        this.bY = bY;
        this.cY = cY;
        this.mouvementMax = mouvementMax;
        this.demiTour = demiTour;
    }

    /**
     * Renvoie la position x de l'entite en temps t
     *
     * @param t
     * @return
     */
    public double getXenT(double t) {
        System.out.println(t);
        t -= soustracteur;
        if (demiTour) {
            if (t == mouvementMax) {
                sens = false;
            }
            if (t == 1) {
                sens = true;
                soustracteur = (int) t;
            }
            if (!sens) {
                t = mouvementMax - (t % mouvementMax);
            }
        }
        return (aX * Math.pow(t, 2) + bX * t + cX);
    }

    /**
     * Renvoie la position y de l'entite en temps t
     *
     * @param t
     * @return
     */
    public double getYenT(double t) {
             t -= soustracteur;
        if (demiTour) {
            if (t == mouvementMax) {
                sens = false;
            }
            if (t == 1) {
                sens = true;
                soustracteur = (int) t;
            }
            if (!sens) {
                t = mouvementMax - (t % mouvementMax);
            }
        }
        return (aY * Math.pow(t, 2) + bY * t + cY);
    }

    /**
     * Calcul la distance entre deux points
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return La distance entre les deux points
     */
    public double calculDistance(double x1, double y1, double x2, double y2) {
        return (Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5));
    }

    /**
     * Calcul l'angle d1^d2 entre trois distances
     *
     * @param d1
     * @param d2
     * @param d3
     * @return
     */
    public double calculAngle(double d1, double d2, double d3) {
        double p1 = (Math.pow(d1, 2) + Math.pow(d2, 2) - Math.pow(d3, 2));
        double p2 = 2 * d1 * d2;
        return Math.acos(p1 / p2);
    }

    /**
     * Donne l'angle en t
     *
     * @param t Temps
     * @return L'angle en t
     */
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
