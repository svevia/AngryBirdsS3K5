package extra.lasergame;

import static angrybirds.Constante.screen;
import angrybirds.core.VisualCore;
import entites.target.TargetListener;
import java.awt.event.MouseEvent;

/**
 * Le target listener adapte au jeu du laser
 *
 * @author Wissam
 */
public class TargetLaserListener extends TargetListener {

    public TargetLaserListener(VisualCore visu) {
        super(visu);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        visu.paintCible = false;
        screen.removeMouseListener(this);
    }
}
