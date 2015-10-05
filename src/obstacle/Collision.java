package obstacle;

import angrybirds.AnimationOiseau;
import static angrybirds.Constante.bird;
import static angrybirds.Constante.fenetre;
import static angrybirds.Constante.obstacle;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class qui gere les collisions
 */
public class Collision {

    AnimationOiseau anim;

    public Collision(AnimationOiseau animationOiseau) {
        anim = animationOiseau;
    }

    /**
     * Fonction permettant de trouver l'element percute
     *
     * @return 0 si aucun element n'est percute, si non son index dans la liste
     */
    private int entityHit() {
        for (int i = 0; i < obstacle.size(); i++) {
            int j = bird.getHb().compareTo(obstacle.get(i).getHb());
            if (j == 1) {
                return i;
            }
        }
        return 0;
    }
    
    private boolean BorderTouch () {
        return (bird.getBirdCenterX() > fenetre.width 
                || bird.getBirdCenterY() > fenetre.height-50);
    }

    /**
     * Verifie qu'aucune collision n'est comise
     */
    public void verif() {
        if (entityHit() != 0 || BorderTouch()) {
            try {
                bird.setCorps(Color.black);
                obstacle.get(entityHit()).setC(Color.black);
                anim.repaint();
                Thread.sleep(2000);
                anim.arret();
            } catch (InterruptedException ex) {
                Logger.getLogger(Collision.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
