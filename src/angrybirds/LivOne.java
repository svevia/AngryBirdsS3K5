package angrybirds;

import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;
import entites.obstacle.skin.*;
import java.awt.Color;

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

    @Override
    public void run() {
        if (i < n) {
            try {
                iniz();
                Obstacle.addListObstacle(
                        new Rond(500, 20, 20, 80, Color.red),
                        //                        new Rond(550, 200, 80, 80, Color.red),
                        //                        new Carre(500, 400, 50, 0, Color.pink),
                        //                        new Carre(400, 400, 50, 30, Color.yellow),
                        //                        new Rond(200, 200, 60, 50, Color.black),
                        new Rond(600, 600, 50, 20, Color.black)
                );
                gf = new GameFrame(i + 1, n, generateCourbe());
            } catch (Exception e) {
                System.out.println("CA MARCHE PAS !!!\n" + e.toString());
            }
            i++;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p.run();
    }
}
