package entites.bird.power;

import angrybirds.jeu.core.HeartMoveBird;
import java.awt.event.KeyEvent;

/**
 * Teleporte un pigeon un peu plus loin
 */
public class Teleportation extends Power {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F) {
            HeartMoveBird.internalTime += 100;
            autodestruction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
