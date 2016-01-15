package extra.lasergame;

import angrybirds.jeu.Screen;
import java.awt.Graphics;
import static angrybirds.Constante.*;

/**
 * Le panel du jeu du laser
 *
 */
public class ScreenLaser extends Screen {

    public ScreenLaser() {
        bird = new Depart(null);
        bird.setX(200);
        bird.setY(500);
        setFocusable(true);
        setDoubleBuffered(true);
        visu = new VisuLaser();
        visu.setDaemon(true);
        addMouseListener(new TargetLaserListener(visu));
    }

    @Override
    public void start() {
        visu.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
