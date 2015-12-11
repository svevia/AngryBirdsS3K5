package angrybirds;

import angrybirds.jeu.GameFrame;
import entites.bird.module.ModuleBird;
import entites.bird.*;
import entites.obstacle.Obstacle;
import java.awt.Dimension;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import modele.ImageCustomz;
import modele.PFAGReader;
import static modele.PFAGReader.listePFAG;

/**
 * La classe constante reunni toute les constantes du programme.
 */
public class Constante {

    /**
     * Le reader de pfag
     */
    public static PFAGReader gReader = new PFAGReader();

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
    public static Footstep footstep = Footstep.ARCENCIEL;

    /**
     * La fond choisi
     */
    public static ArrayList<ImageCustomz> fond;

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
     * OLD - La fenetre du jeu
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
     * Les images du packet utilise
     */
    static public HashMap<String, ImageCustomz> allIPacketmageRessource;

    /**
     * L'index du PFAG a utiliser
     */
    public static int indexPFAGUtilise = 1;

    /**
     * Variable qui indique quel obstacle de la liste est touche
     */
    public static int entityHitty = 0;

    /**
     * Reinitialise la class a zero
     */
    public static void iniz() throws IOException {
        fenetre = gReader.dimensionFenetre(listePFAG().get(indexPFAGUtilise));
        allModul = new ArrayList<>();
        bird = new RougeGorge(null);
        fond = gReader.listeImage(listePFAG().get(indexPFAGUtilise));
        obstacle = new ArrayList<>();
        footstepX = new ArrayList<>();
        footstepY = new ArrayList<>();
        footstepA = new ArrayList<>();
        entityHitty = 0;
        last = false;
    }

    /**
     * Liste tout les fichiers de la source qui ont l'extension specifie en clef
     * et sa source en valeur
     *
     * @param source Source a parcourir, ex : src/ressource
     * @param extension Suite de lettre apres le point, ex : pfag
     * @return
     */
    public static HashMap<String, String> listeFichier(String source, String extension) {
        if (extension.length() < 1) {
            return null;
        }
        HashMap<String, String> sources = new HashMap<>();
        String tmp = "";
        String src = "";
        try {
            Path path = Paths.get(source);
            DirectoryStream<Path> stream;
            stream = Files.newDirectoryStream(path);
            try {
                Iterator<Path> iterator = stream.iterator();
                while (iterator.hasNext()) {
                    Path p = iterator.next();
                    tmp = p.toString();
                    tmp = tmp.substring(tmp.length() - extension.length());
                    if (tmp.equals(extension)) {
                        if (p.getName(0).toString().equals("Ressource")) {
                            tmp = "";
                            for (int i = 1; i < p.getNameCount() - 1; i++) {
                                tmp += p.getName(i) + "/";
                            }
                        }
                        src = tmp + p.getName(p.getNameCount() - 1).toString();
                        tmp = p.getName(p.getNameCount() - 1).toString();
                        tmp = tmp.substring(0, tmp.length() - (extension.length() + 1));
                        sources.put(tmp, src);
                    }
                }
            } finally {
                stream.close();
            }
        } catch (IOException ex) {
            System.out.println("Bug lecture des sources, source ou/et extension incorectes");
        }
        return sources;
    }

}
