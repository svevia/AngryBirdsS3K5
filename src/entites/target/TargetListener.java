package entites.target;

import static angrybirds.Constante.screen;
import angrybirds.core.VisualCore;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Le listener qui gere l'utilisation de la target. Son but est simple, il
 * recoit un clic, coordonne le tire et balance la sauce avant de disparaitre
 * comme un assassin.
 */
public class TargetListener implements MouseListener {

    /**
     * Le visu qui gere la target
     */
    public VisualCore visu;

    /**
     * La force actuel
     */
    public static int forceActuel = 0;

    public TargetListener(VisualCore visu) {
        this.visu = visu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        visu.xTarget = e.getX();
        visu.yTarget = e.getY();
        visu.paintCible = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (forceActuel > 20) {
            visu.paintCible = false;
            screen.removeMouseListener(this);
            screen.oder227();
        } else {
            visu.paintCible = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
