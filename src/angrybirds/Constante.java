package angrybirds;

import obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
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
     * Liste des points de passages du pigeon en x
     */
    public static ArrayList<Integer> footstepX = new ArrayList<>();

    /**
     * Liste des points de passages du pigeon en y
     */
    public static ArrayList<Integer> footstepY = new ArrayList<>();

    /**
     * Liste des angles fait par le pigeon
     */
    public static ArrayList<Double> footstepA = new ArrayList<>();
}
