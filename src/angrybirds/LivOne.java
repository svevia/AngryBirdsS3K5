package angrybirds;

import static angrybirds.Constante.iniz;
import static angrybirds.Constante.gf;
import entites.obstacle.Obstacle;
import entites.obstacle.skin.Carre;
import entites.obstacle.skin.Rond;
import java.awt.Color;

/**
 *
 * @author Wissam
 */
public class LivOne implements Runnable {

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
                        new Rond(550, 200, 80, 80, Color.red),
                        new Carre(500, 400, 50, 0, Color.pink),
                        new Carre(400, 400, 50, 30, Color.yellow),
                        new Rond(200, 200, 60, 50, Color.black),
                        new Rond(600, 600, 50, 20, Color.GREEN)
                );
                gf = new GameFrame(i, n);
            } catch (Exception e) {
                System.out.println("CA MARCHE PAS !!!\n" + e.toString());
            }
            i++;
        }
    }
}
