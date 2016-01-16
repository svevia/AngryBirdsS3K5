package entites.bird.power;

import static angrybirds.Constante.screen;
import static modele.Visualisateur.listeAnimationToDraw;
import angrybirds.jeu.animation.Animation;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represent la toute nouvelle puissance des pigeons
 */
public abstract class Power implements KeyListener {

    protected Queue<Animation> animation = new LinkedList<>();

    protected void autodestruction() {
        screen.removeKeyListener(this);
    }

    public Queue<Animation> getAnimation() {
        return animation;
    }

    public void setAnimation(Queue<Animation> animation) {
        this.animation = animation;
    }

    protected void lunchFirstAnim() {
        listeAnimationToDraw.add(animation.remove());
    }
}
