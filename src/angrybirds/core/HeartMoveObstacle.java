package angrybirds.core;

import static angrybirds.Constante.obstacle;
import static angrybirds.core.HeartCore.t;

/**
 * Ce coeur battant a pour but de gérer le mouvement des oiseaux
 */
public class HeartMoveObstacle extends Thread {

    public HeartMoveObstacle() {
    }

    /**
     * Un oiseau aura le pouvoir de ralentir le temps
     */
    @Override
    public void run() {
        obstacle.stream().filter((o) -> (o.isMove())).forEach((o) -> {
            o.move(t);
        });
    }
}
