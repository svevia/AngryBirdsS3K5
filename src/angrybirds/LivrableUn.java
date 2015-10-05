package angrybirds;

import static angrybirds.Constante.iniz;
import java.awt.Color;
import java.util.Random;
import obstacle.Obstacle;
import obstacle.type.*;

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
                jeu = new AnimationOiseau(0, 0.0005, -0.5, 450 + r.nextInt(50));
                //jeu = new AnimationOiseau(0, 0, 0, 450 + r.nextInt(50));
                Obstacle.addListObstacle(
                        new Rond(20, 20, 650, 80, Color.red),
                        new Rond(20, 20, 650, 80, Color.red),
                      //  new Carre(100, 40, 750, 400, Color.pink),
                        new Carre(40, 40, 550, 300, Color.yellow),
                        new Rond(20, 20, 600, 500, Color.black),
                        new Rond(60, 60, 550, 200, Color.GREEN)
                );
                jeu.start();
            } catch (Exception e) {
                System.out.println("CA MARCHE PAS !!!\n" + e.toString());
            }
            i++;
        }
    }
}
