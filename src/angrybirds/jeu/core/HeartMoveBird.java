package angrybirds.jeu.core;

import static angrybirds.Constante.*;
import static angrybirds.jeu.core.HeartCore.t;

/**
 * Ce coeur battant a pour but de gérer le mouvement des oiseaux
 */
public class HeartMoveBird extends Thread {

    /**
     * Le pigeon trancende les proprietes de ce monde, contrairement a toi
     * pauvre humain, le pigeon a son propre coeur de temps, si le pigeon avait
     * un peu plus d'inteligence, il serait capable de controler le temps
     */
    public static int internalTime = 0;

    /**
     * Comme le pigeon est un autre trop rapide, et pour qu'il soi visible pour
     * tes propres yeux humains, nous avons ici grandement reduit sa vitesse de
     * vol
     */
    private int internalSpeedCalculatorSpacial = 0;

    @Override
    public void run() {
        for (int i = 0; i < vitesse; i++, internalSpeedCalculatorSpacial++) {
            if (internalSpeedCalculatorSpacial == 2) {
                bird.move(internalTime);
                internalSpeedCalculatorSpacial = 0;
                internalTime++;
                addFootstepCoord();
            }
        }
    }

    /**
     * Fonction qui ajoute les coordonnes actuel a une liste
     */
    private void addFootstepCoord() {
        if (bird.isMove()) {
            footstepX.add(bird.getX());
            footstepY.add(bird.getY() + bird.getR());
            footstepA.add(bird.getCourbe().angleAenT(t));
        }
    }
}
