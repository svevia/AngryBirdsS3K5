package extra.lasergame;

import angrybirds.jeu.core.VisualCore;
import entites.target.TargetListener;
import java.awt.event.MouseEvent;

/**
 * Le target listener adapte au jeu du laser
 *
 */
public class TargetLaserListener extends TargetListener {

    public TargetLaserListener(VisualCore visu) {
        super(visu);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        visu.paintCible = false;
    }
}
