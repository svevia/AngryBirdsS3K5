package extra.lasergame;

import static angrybirds.Constante.bird;
import static angrybirds.Constante.screen;
import static modele.Visualisateur.drawCurveLaser;
import static modele.Visualisateur.drawObstacle;
import static modele.Visualisateur.drawOiseau;
import static modele.Visualisateur.drawTargetLaser;
import angrybirds.jeu.core.VisualCore;
import java.awt.Color;
import java.awt.Graphics;

/**
 *  Le visu adapte au jeu du laser
 */
public class VisuLaser extends VisualCore {

    @Override
    public Graphics draw(Graphics g) {
        g = drawObstacle(g);
        if (bird != null) {
            g.setColor(Color.red);
            g = drawCurveLaser(g, bird.getCourbe());
            g = drawOiseau(g);
        }
        if (paintCible) {
            try {
                g = drawTargetLaser(g, screen.getMousePosition().x, screen.getMousePosition().y, xTarget, yTarget);
            } catch (NullPointerException e) {
            }
        }
        return g;
    }

}
