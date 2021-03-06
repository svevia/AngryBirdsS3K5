package entites.bird.power;

import static angrybirds.Constante.bird;
import java.awt.event.KeyEvent;

/**
 * @author K5
 */
public class DoubleMasse extends Power {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_M) {
            bird.setMasse(bird.getMasse() * 2);
            autodestruction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
