package angrybirds;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import obstacle.*;
import skin.Footstep;
import skin.Bird;
import skin.Fond;
import skin.oiseau.*;

/**
 * La classe constante reunni toute les constantes du programme.
 */
public class Constante {

    /**
     * L'oiseau choisi
     */
    public static Bird bird = new RougeGorge();

    /**
     * La couleur du trace choisi
     */
    public static Footstep footstep = Footstep.ROUGE;
    
    /**
     * La fond choisi
     */
    public static Fond fond = Fond.PAYSAGE;
   
    /**
     * Les dimensions de la fenetre
     */
    public static Dimension fenetre = new Dimension(800, 600);

    /**
     * Liste des obstacles du jeu
     */
    public static ArrayList<Obstacle> obstacle = new ArrayList<>();

    /**
     * Fonction qui ajoute entre 5 obstacles a des endroits fix sur une fenetre
     * de 800 par 600 par defaut.
     */
    public static void inizObstacle() {
        obstacle.add(new Rond(20, 20, 650, 80, Color.red));
        obstacle.add(new Carre(100, 40, 750, 400, Color.pink));
        obstacle.add(new Carre(40, 40, 550, 300, Color.yellow));
        obstacle.add(new Rond(20, 20, 600, 500, Color.black));
        obstacle.add(new Rond(60, 60, 550, 200, Color.GREEN));
    }
}
