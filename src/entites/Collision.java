package entites;

import static angrybirds.Constante.*;
import java.awt.Color;

/**
 * Classe qui gere les collisions, le moteur de collision
 */
public class Collision extends Thread {

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

    /**
     * Methode qui indique si un cote de la fenetre est touche
     * @return True si l'oiseau touche les bords
     */
    private boolean borderTouch() {
        return (bird.getX() + bird.getWidht() > fenetre.width
                || bird.getY() + bird.getR()*2 > fenetre.height - 100
                || bird.getY() < 0
                ||bird.getX() < 0
                );
    }

    /**
     * Verifie qu'aucune collision n'est comise
     */
    private void verif() {
        if (entityHit() != 0 || borderTouch()) {
            entityHitty = entityHit();
            bird.setCorps(Color.gray);
            if (!borderTouch()){
	            obstacle.get(entityHitty).setC(Color.gray);
            }
            last = true;
        }
    }

    @Override
    public void run() {
        verif();
    }
}
