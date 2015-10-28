package angrybirds;

import static angrybirds.Constante.bird;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux thread comme
 * coeur qui bat.
 */
public class HeartCore implements Runnable {

    /**
     * En milliseconde, le temps entre 2 pas (ou deux battements d'ailes)
     */
    int vitesse;

    private double distanceParcourue;
    private int xDepart;
    private int yDepart;

    /**
     * L'animation utilise
     */
    AnimationOiseau anim;

    /**
     *
     * @param vitesse
     * @param step
     * @param animationOiseau
     */
    public HeartCore(int vitesse, AnimationOiseau animationOiseau) {
        this.vitesse = vitesse;
        anim = animationOiseau;
    }

    /**
     * Le run avance le x par "step", repaint et attends un peu
     */
    @Override
    public void run() {
        xDepart = bird.getX();
        yDepart = (int) anim.getCourbe().getYenX(bird.getX());
        while (true) {
            System.out.println(bird.getX() + " - " + anim.getCourbe().getYenX(bird.getX()));
            distanceParcourue = anim.getCourbe().distanceEntreDeuxPoints(xDepart, bird.getX(), yDepart, anim.getCourbe().getYenX(bird.getX()));
            bird.setPosX(bird.getPosX() + 1);
            bird.setPosY((int) anim.getCourbe().getYenX(bird.getPosX()));
            bird.setA(anim.getCourbe().angleNextD(bird.getPosX()));
            // A varier entre 2 et 6
            if (distanceParcourue > vitesse) {
                refresh();
            }

        }
    }

    private void refresh() {
        /* Pour d'obscures raisons, quand l'oiseau n'a pas quitté les premiers
         pixels, le repaint bug */
        if (bird.getBirdCenterX() < 80) {
            anim.repaint();
        } else {
            int x1 = bird.getPosX() - 10;
            int x2 = bird.getBirdCenterX() + 10;
            int y1 = bird.getPosY() - 10;
            int y2 = bird.getBirdCenterY() + 10;
            x1 = (x1 > 0) ? x1 : 0;
            x2 = (x2 > 0) ? x2 : 0;
            y2 = (y2 > 0) ? y2 : 0;
            y1 = (y1 > 0) ? y1 : 0;
            anim.repaint(x1, y1, x2, y2);
        }
        xDepart = bird.getX();
        yDepart = (int) anim.getCourbe().getYenX(bird.getX());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Fred a un soucis :(\n" + e.getMessage());
        }
    }
}
