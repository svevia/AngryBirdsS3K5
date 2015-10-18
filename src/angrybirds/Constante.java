package angrybirds;

import entites.bird.skin.Canard;
import entites.obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
import entites.bird.Footstep;
import entites.bird.Bird;
import entites.bird.Fond;
import entites.bird.skin.RougeGorge;

/**
 * La classe constante reunni toute les constantes du programme.
 */
public class Constante {

    /**
     * L'oiseau choisi
     */
    public static Bird bird;

    /**
     * La couleur du trace choisi
     */
    public static Footstep footstep;

    /**
     * La fond choisi
     */
    public static Fond fond;

    /**
     * Les dimensions de la fenetre
     */
    public static Dimension fenetre = new Dimension(800, 600);

    /**
     * Liste des obstacles du jeu
     */
    public static ArrayList<Obstacle> obstacle;

    /**
     * Liste des points de passages du pigeon en x
     */
    public static ArrayList<Integer> footstepX;

    /**
     * Liste des points de passages du pigeon en y
     */
    public static ArrayList<Integer> footstepY;

    /**
     * Liste des angles fait par le pigeon
     */
    public static ArrayList<Double> footstepA;
    
    /**
     * La fenetre du jeu
     */
    public static GameFrame gf;
    
    /**
     * Reinitialise la class a zero
     */
    public static void iniz() {
        bird = new Canard();
        footstep = Footstep.ARCENCIEL;
        fond = Fond.PAYSAGE;
        obstacle = new ArrayList<>();
        footstepX = new ArrayList<>();
        footstepY = new ArrayList<>();
        footstepA = new ArrayList<>();
    }
}
