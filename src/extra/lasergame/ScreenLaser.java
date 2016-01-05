package extra.lasergame;

import angrybirds.jeu.Screen;
import angrybirds.core.VisualCore;
import java.awt.Graphics;
import static angrybirds.Constante.*;

/**
 * Le panel du jeu du laser
 *
 * @author Wissam
 */
public class ScreenLaser extends Screen {

    public ScreenLaser() {
        bird = new Depart(null);
        setFocusable(true);
        setDoubleBuffered(true);
        visu = new VisualCore(this);
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
