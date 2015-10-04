package Obstacle;

import static angrybirds.Constante.bird;
import static angrybirds.Constante.obstacle;

/**
 * Class qui gere les collisions
 */
public class Collision {

    /**
     * Fonction permettant de trouver l'element percute
     * @return 0 si aucun element n'est percute, si non son index dans la liste
     */
    public int entityHit() {
        for (int i = 0; i < obstacle.size(); i++) {
            int j = bird.getHb().compareTo(obstacle.get(i).getHb());
            if (j == 1) {
                return i;
            }
        }
        return 0;
    }

}
