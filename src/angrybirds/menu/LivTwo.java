package angrybirds.menu;

import static angrybirds.Constante.*;
import angrybirds.Luncher;
import entites.obstacle.Obstacle;
import java.io.IOException;
import ressource.PFAGReader;

/**
 * La classe qui lancera le livrable 1
 */
public class LivTwo implements Runnable {

    /**
     *
     * @param n
     */
    public LivTwo() {
    }

    /**
     * Un run equivaut a un jeu
     */
    @Override
    public void run() {
        try {
            iniz();
            Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
            l = new Luncher();
        } catch (IOException ex) {
            System.out.println("Bug LivTwo Iniz");
        }
    }
}
