package angrybirds.core;

import static angrybirds.Constante.bird;
import static angrybirds.Constante.entityHitty;
import static angrybirds.Constante.fenetre;
import static angrybirds.Constante.last;
import static angrybirds.Constante.obstacle;
import java.awt.Color;

/**
 * Gestionnaire des crashs
 */
public class CrashCore extends Thread {

    /**
     * Fonction permettant de trouver l'element percute
     *
     * @return 0 si aucun element n'est percute, si non son index dans la liste
     */
    private int entityHitBird() {
        for (int i = 0; i < obstacle.size(); i++) {
            // Compare les hit boxes avec l'oiseau
            int j = bird.getHb().compareTo(obstacle.get(i).getHb());
            if (j == 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Methode qui indique si un cote de la fenetre est touche
     *
     * @return True si l'oiseau touche les bords
     */
    private boolean borderTouch() {
        return (bird.getX() + bird.getWidht() > fenetre.width
                || bird.getY() + bird.getR() * 2 > fenetre.height - 100
                //|| bird.getY() < 0 //Empéche l'oiseau d'aller au dessus de la fenêtreS
                || bird.getX() < 0);
    }

    /**
     * Verifie qu'aucune collision n'est comise
     */
    private void verif() {
        if (entityHitBird() != 0 || borderTouch()) {
            entityHitty = entityHitBird();
            bird.setCorps(Color.gray);
            if (!borderTouch()) {
                obstacle.get(entityHitty).impact();
            } else {
                last = true;
            }
        }
    }

    @Override
    public void run() {
        verif();
    }
}
