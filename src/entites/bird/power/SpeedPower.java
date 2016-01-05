package entites.bird.power;

import static angrybirds.Constante.vitesse;
import java.awt.event.KeyEvent;

public class SpeedPower extends Power {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            vitesse += 5;
            autodestruction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
