package angrybirds;

import entites.bird.skin.*;
import entites.obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
import entites.bird.*;

/**
 * La classe constante reunni toute les constantes du programme.
 */
public class Constante {

    /**
     * La vitesse de l'oiseau
     */
    public static int vitesse;
    
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
    public static Dimension fenetre = new Dimension(1200, 600);

    /**
     * Liste des obstacles du jeu
     */
    public static ArrayList<Obstacle> obstacle;

    /**
     * Liste de tout les modules
     */
    public static ArrayList<ModuleBird> allModul;

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
        allModul = new ArrayList<>();
        bird = new Canard();
        footstep = Footstep.GAY;
        fond = Fond.PAYSAGE;
        obstacle = new ArrayList<>();
        footstepX = new ArrayList<>();
        footstepY = new ArrayList<>();
        footstepA = new ArrayList<>();
    }

    /**
     * Genere une courbe aleatoirement dans le cadre du jeu
     *
     * @return La courbe genere
     */
    public static Courbe generateCourbe() {
        return new Courbe(0.0008, -0.9, 450);
    }
}
