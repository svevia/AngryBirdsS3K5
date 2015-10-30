package angrybirds;

import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;

/**
 *
 * @author Wissam
 */
public class LivOne implements Runnable {

    /**
     * Le programme qui se lancera
     */
    static LivOne p = new LivOne(10);

    /**
     * Le numero de lancement de l'application
     */
    private int i;

    /**
     * Le nombre d'essai total
     */
    private int n;

    public LivOne(int n) {
        this.n = n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p.run();
    }

    @Override
    public void run() {
        if (i < n) {
            iniz();
            Obstacle.addListObstacle(generateListObstacle(9));
            gf = new GameFrame(i + 1, n, generateCourbe());

            i++;
        }
    }
}
