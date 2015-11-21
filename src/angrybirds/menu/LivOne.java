package angrybirds.menu;

import angrybirds.OldGameFrame;
import static angrybirds.Constante.*;
import angrybirds.Courbe;
import entites.obstacle.Obstacle;
import java.io.IOException;
import ressource.PFAGReader;

/**
 * La classe qui lancera le livrable 1
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

    /**
     *
     * @param n
     */
    public LivOne(int n) {
        this.n = n;
    }

    /**
     * Un run equivaut a un jeu
     */
    @Override
    public void run() {
        if (i < n) {
            try {
                iniz();
                Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
                gf = new OldGameFrame(i + 1, n, new Courbe(0, 1, 0, 0.0009, -0.9, (fenetre.height-200)));
                i++;
            } catch (IOException ex) {
                System.out.println("Bug LivOne Iniz");
            }
        } else {
            System.exit(i);
        }
    }
}
