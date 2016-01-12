package entites.bird.power;

import static angrybirds.Constante.bird;
import angrybirds.jeu.animation.OndeChoc;
import static angrybirds.jeu.core.HeartCore.t;
import java.awt.event.KeyEvent;

/**
 * Cree une onde de choc autour du pigeon
 */
public class OndeChocPower extends Power {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_O) {
            animation.add(new OndeChoc(bird.getBirdCenterX(), bird.getBirdCenterY(), t, 500));
            lunchFirstAnim();
            autodestruction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
