package angrybirds;

import static angrybirds.Constante.bird;
import static angrybirds.Presentation.jeu;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux thread comme
 * coeur qui bat.
 */
public class HeartCore implements Runnable {

    /**
     * En milliseconde, le temps entre 2 pas (ou deux battements d'ailes)
     */
    int vitesse;

    /**
     * Le pas d'avancement de l'oiseau
     */
    int step;

    /**
     *
     * @param vitesse
     */
    public HeartCore(int vitesse, int step) {
        this.vitesse = vitesse;
        this.step = step;
    }

    /**
     * Le run avance le x par "step", repaint et attends un peu
     */
    @Override
    public void run() {
        while (true) {
            try {
                int x1 = bird.getBirdCenterX() - bird.getR() - 10;
                int x2 = bird.getBirdCenterX() + bird.getR() + 10;
                int y1 = bird.getBirdCenterY() - bird.getR() - 10;
                int y2 = bird.getBirdCenterY() + bird.getR() + 10;
                jeu.incrementeX(step);
                jeu.repaint(x1, y1, x2, y2);
                if (bird.getBirdCenterX() < 40) {
                   jeu.repaint();
                }
                Thread.sleep(vitesse);
            } catch (InterruptedException e) {
                System.out.println("Fred a un soucis :(\n" + e.getMessage());
            }
        }
    }
}
