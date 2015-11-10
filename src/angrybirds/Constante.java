package angrybirds;

import ressource.Fond;
import entites.Matrice;
import entites.bird.skin.*;
import entites.obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
import entites.bird.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import ressource.ImageCustomz;
import ressource.PFAGReader;

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
    public static Dimension fenetre = new Dimension(1920, 1080);//4K maggle

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
     * Le reader de pfag
     */
    public static PFAGReader gReader;

    /**
     * Les images du packet utilise
     */
    static public HashMap<String, ImageCustomz> allIPacketmageRessource;

    /**
     * Reinitialise la class a zero
     */
    public static void iniz() throws IOException {
        gReader = new PFAGReader("src/ressource/enfer.pfag");
        allIPacketmageRessource = gReader.listeImage();
        fenetre = gReader.dimensionFenetre();
        allModul = new ArrayList<>();
        bird = new RougeGorge();
        footstep = Footstep.VODKA;
        fond = Fond.Enfer;
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
        double a = (alea.nextDouble() + 7) / 10000;
        double b = alea.nextDouble() * -2;
        return new Courbe(a, b, fenetre.getHeight() - 150);
    }

    /**
     * Retourne une matrice permettant de faire une homotetie de rapport k
     * autour de l'origine
     *
     * @param k
     * @return
     */
    public static Matrice homotetie(int k) {
        Matrice homo = new Matrice(3, 3);
        for (int idx = 0; idx < 2; idx++) {
            homo.setValueAtIdx(idx, idx, k);
        }
        homo.setValueAtIdx(2, 2, 1);
        return homo;
    }

    /**
     * Retourne une matrice permettant de faire une translation de vecteur (x,y)
     *
     * @param x
     * @param y
     * @return
     */
    public static Matrice translation(int x, int y) {
        Matrice trans = new Matrice(3, 3);
        for (int idx = 0; idx < 3; idx++) {
            trans.setValueAtIdx(idx, idx, 1);
        }
        trans.setValueAtIdx(0, 2, x);
        trans.setValueAtIdx(1, 2, y);
        return trans;
    }

    /**
     * Retourne une matrice permettant de faire une rotation autour de l'origine
     * d'angle teta
     *
     * @param teta
     * @return
     */
    public static Matrice rotation(int teta) {
        Matrice rota = new Matrice(3, 3);
        for (int idx = 0; idx < 2; idx++) {
            rota.setValueAtIdx(idx, idx, (int) Math.cos(teta));
        }
        rota.setValueAtIdx(0, 1, (int) -Math.sin(teta));
        rota.setValueAtIdx(1, 0, (int) Math.sin(teta));
        rota.setValueAtIdx(2, 2, 1);
        return rota;
    }
}
