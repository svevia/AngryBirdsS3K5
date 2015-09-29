package angrybirds;

public class CourbeBeta {

    private double a, b, c;

    /**
     * Cree une courbe du type a*x²+b*x+c (second degré)
     *
     * @param a
     * @param b
     * @param c
     */
    public CourbeBeta(double a, double b, double c) {
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
     * Renvoie le nombre de y qu'aura en plus au prochain x l'oiseau, donnant
     * ainsi une "direction" Si le chiffre est negative, le pigeon s'envole, si
     * non il est en train de se crasher
     *
     * @param x
     * @return
     */
    public double getCoefficientDirecteur(int x) {
        double yCoef, xCoef;
        yCoef = (getYenX(x) - getYenX(x + 1));
        xCoef = (x - (x + 1));
        return yCoef / xCoef;
    }

    /**
     * Retourne la difference en la position du pigeon en Ordonnees et de sa
     * position suivante
     *
     * @param x
     * @return
     */
    public double getCoefficientDirecteurY(int x) {
        return getYenX(x) - getYenX(x - 1);
    }

    /**
     * Renvoie l'angle en radian du prochain point
     *
     * @param x
     * @return
     */
    public double angleNext(int x) {
        double tmp = getCoefficientDirecteurY(x);
        if (tmp < 0) {
            return Math.PI / 2 - Math.atan(1 / getCoefficientDirecteurY(x)) + Math.PI;
        } else {
            return Math.PI / 2 - Math.atan(1 / getCoefficientDirecteurY(x));
        }
        //return 1 / getCoefficientDirecteurY(x); //Pour faire un 3'6 au pigeon en l'air rpz oklm #posay
    }
}
