package entites.bird.power;

import static angrybirds.Constante.bird;
import angrybirds.jeu.animation.TheWorld;
import static angrybirds.jeu.core.HeartCore.permiseWall;
import static angrybirds.jeu.core.HeartCore.t;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * Le pouvoir permet a son pocesseur d'arreter le temps pendant 9 sc et de
 * pouvoir se mouvoir lui meme comme si que rien n'avait change
 */
public class StandTheWorld extends Power implements ActionListener {

    Timer t1 = new Timer(9000, this);

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            permiseWall = false;
            t1.setRepeats(false);
            t1.start();
            animation.add(new TheWorld(bird.getBirdCenterX(), bird.getBirdCenterY(), t));
            lunchFirstAnim();
            autodestruction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        permiseWall = true;
    }

}
