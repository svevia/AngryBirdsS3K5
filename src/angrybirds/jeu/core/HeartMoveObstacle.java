package angrybirds.jeu.core;

import static angrybirds.Constante.obstacle;
import entites.obstacle.Obstacle;

/**
 * Ce coeur battant a pour but de gérer le mouvement des oiseaux
 */
public class HeartMoveObstacle extends Thread {

    /**
     * L'horloge interne aux obstacles, la staticite fait bien les choses, le
     * jeu peut perdre son coeur et en redemarrer un autre, les obstacles ne
     * perdront pas leur positions
     */
    public static int tWall = 0;

    /**
     * Un oiseau aura le pouvoir de ralentir le temps
     */
    @Override
    public void run() {
        for (Obstacle o : obstacle) {
            if (o.isMove()) {
                o.move(tWall);
            }
        }
        tWall++;
    }
}
