package angrybirds;

import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;
import java.util.Random;

/**
 * La classe qui lancera le livrable 1
 */
public class LivOne implements Runnable {

    /**
     * Le programme qui se lancera
     */
    static LivOne p;

    /**
     * Le numero de lancement de l'application
     */
    private int i;

    /**
     * Le nombre d'essai total
     */
    private int n;

    /**
     *
     * @param n
     */
    public LivOne(int n) {
        this.n = n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p = new LivOne(10);
        p.run();
    }

    /**
     * Un run equivaut a un jeu
     */
    @Override
    public void run() {
        if (i < n) {
            iniz();
            Random r = new Random();
            Obstacle.addListObstacle(generateListObstacle(r.nextInt(5) + 5));
            gf = new GameFrame(i + 1, n, generateCourbe());
            i++;
        }
    }
}
