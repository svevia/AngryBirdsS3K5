package angrybirds;

import static angrybirds.Constante.obstacle;
import java.awt.Color;
import java.util.Random;
import obstacle.type.Carre;
import obstacle.Obstacle;
import obstacle.type.Rond;

public class Presentation implements Runnable {

    private Random r = new Random();
    private int n;
    public int i;
    static public AnimationOiseau jeu;

    public Presentation(int nombreSerie) {
        n = nombreSerie;
    }

    @Override
    public void run() {
        if (i < n) {
            try {
                //new AnimationOiseau(0, 0.0005, -0.5, 450 + r.nextInt(50)).setVisible(true);
                jeu = new AnimationOiseau(0, 0.0005, -0.5, 450 + r.nextInt(50));
                Obstacle.addListObstacle(
                        new Rond(20, 20, 650, 80, Color.red),
                        new Rond(20, 20, 650, 80, Color.red),
                        new Carre(100, 40, 750, 400, Color.pink),
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
