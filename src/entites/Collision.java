package entites;

import angrybirds.AnimationOiseau;
import static angrybirds.Constante.*;
import java.awt.Color;

/**
 * Classe qui gere les collisions, le moteur de collision
 */
public class Collision {

    /**
     * L'animation ou est appele le moteur de collision
     */
    AnimationOiseau anim;

    /**
     *
     * @param animationOiseau
     */
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
            // Compare les hit boxes
            int j = bird.getHb().compareTo(obstacle.get(i).getHb());
            if (j == 1) {
                return i;
            }
        }
        return 0;
    }

    private boolean borderTouch() {
        return (bird.getBirdCenterX() > fenetre.width
                || bird.getBirdCenterY() > fenetre.height - 50);
    }

    /**
     * Verifie qu'aucune collision n'est comise
     */
    public void verif() {
        if (entityHit() != 0 || borderTouch()) {
            bird.setCorps(Color.gray);
            obstacle.get(entityHit()).setC(Color.gray);
            last = true;
        }
    }
}
