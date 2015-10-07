package angrybirds;

import entites.obstacle.skin.Rond;
import entites.obstacle.skin.Carre;
import static angrybirds.Constante.iniz;
import java.awt.Color;
import java.util.Random;
import entites.obstacle.Obstacle;

/**
 * Premier livrable
 */
public class LivrableUn implements Runnable {

    private Random r = new Random();
    private int n;

    /**
     * Le numero de lancement de l'application
     */
    public int i;
    
    /**
     * L'animation sur la quelle travailler
     */
    private AnimationOiseau jeu;

    /**
     *
     * @param nombreSerie
     */
    public LivrableUn(int nombreSerie) {
        n = nombreSerie;
    }

    @Override
    public void run() {
        if (i < n) {
            try {
                iniz();
                jeu = new AnimationOiseau(0.0005, -0.5, 450 + r.nextInt(50));
                //jeu = new AnimationOiseau(0, 0, 0, 450 + r.nextInt(50));
                Obstacle.addListObstacle(
                        new Rond(500, 20, 20, 80, Color.red),
                        new Rond(550, 200, 80, 80, Color.red),
                        new Carre(500, 400, 50, 0, Color.pink),
                        new Carre(400, 400, 50, 30, Color.yellow),
                        new Rond(200, 200, 60, 50, Color.black),
                        new Rond(600, 600, 50, 20, Color.GREEN)
                );
                jeu.start();
            } catch (Exception e) {
                System.out.println("CA MARCHE PAS !!!\n" + e.toString());
            }
            i++;
        }
    }
}
