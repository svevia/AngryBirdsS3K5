package angrybirds;

import entites.bird.skin.*;
import entites.obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
import entites.bird.*;
import entites.obstacle.skin.Carre;
import java.awt.Color;
import java.util.Random;

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
     * Indique au coeur que c'est son dernier batement....
     */
    public static boolean last = false;

    /**
     * L'index de l'obstacle rencontre si il y a collision
     */
    public static int wallHurty;

    /**
     * Reinitialise la class a zero
     */
    public static void iniz() {
        allModul = new ArrayList<>();
        bird = new RougeGorge();
        footstep = Footstep.GAY;
        fond = Fond.PLAINE;
        obstacle = new ArrayList<>();
        footstepX = new ArrayList<>();
        footstepY = new ArrayList<>();
        footstepA = new ArrayList<>();
        last = false;
    }

    /**
     * Genere une courbe aleatoirement dans le cadre du jeu
     *
     * @return La courbe genere
     */
    public static Courbe generateCourbe() {
	Random alea = new Random();
    	double a = (alea.nextDouble() + 7)/10000;
    	double b = alea.nextDouble()*1.5;
        System.out.println(a + " - " + b);
    	if(alea.nextInt(2) == 0)
    		b = -b;
        return new Courbe(a, b, 450);
    }

    /**
     * Genere une liste d'obstacle aleatoire
     *
     * @param combien
     * @return
     */
    public static ArrayList<Obstacle> generateListObstacle(int combien) {
        ArrayList<Obstacle> ret = new ArrayList<>();
        for (int i = 0; i < combien; i++) {
            ret.add(genereObstacle());
        }
        return ret;
    }

    /**
     * Genere un obstacle aleatoire
     *
     * @return un obstacle genere aleatoirement
     */
    public static Obstacle genereObstacle() {
        Random r = new Random();
        int x = r.nextInt(fenetre.width-200)+200, y = r.nextInt(fenetre.height), h = r.nextInt(100), w = r.nextInt(100);
        return new Carre(x, y, h, w, Color.red);
    }
}
