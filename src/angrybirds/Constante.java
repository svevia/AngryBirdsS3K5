package angrybirds;

import angrybirds.jeu.Screen;
import angrybirds.jeu.GameFrame;
import angrybirds.jeu.core.HeartCore;
import angrybirds.jeu.core.HeartMoveBird;
import angrybirds.jeu.core.HeartMoveObstacle;
import entites.bird.Bird;
import entites.bird.Footstep;
import entites.obstacle.Obstacle;
import static entites.obstacle.Obstacle.addListObstacle;
import entites.target.ClassicalTarget;
import entites.target.Target;
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
import modele.InfoPigeon;
import modele.PFAGReader;
import static modele.PFAGReader.listePFAG;

/**
 * @author K5 La classe constante reunni toute les "constantes" du programme.
 */
public class Constante {

    /**
     * Le temps entre deux images pour un jeu en 30 fps
     */
    public static final int FPS30 = 34;

    /**
     * Le temps entre deux images pour un jeu en 60 fps
     */
    public static final int FPS60 = 16;

    /**
     * Le temps entre deux images pour un jeu en 120 fpd
     */
    public static final int FPS120 = 8;

    /**
     * Le temps maximal entre deux images, 500 fps, affichage subliminal (meme
     * si ton oeil ne vois que 60 fps)
     */
    public static final int FPSUNLIMITED = 2;

    /**
     * Le reader de pfag
     */
    public static PFAGReader gReader = new PFAGReader();

    /**
     * La vitesse de l'oiseau
     */
    public static int vitesse = 5;

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
    public static ArrayList<ImageCustomz> fond = new ArrayList<>();

    /**
     * Les dimensions de la fenetre
     */
    public static Dimension fenetre = new Dimension(1920, 1080);//4K maggle

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

    /**
     * OLD - La fenetre du jeu
     */
    @Deprecated
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
     * La target du jeu, qui sert a viser au lancement
     */
    public static Target target = new ClassicalTarget();

    /**
     * L'animation principal du jeu
     */
    public static Screen screen;

    /**
     * L'essai numero x, actuel
     */
    public static int essai = 1;

    /**
     * Le nombre d'essai total
     */
    public static int nombreEssai = 1;

    /**
     * La map des pigeons
     */
    public static HashMap<Integer, InfoPigeon> pigeons = new HashMap<>();

    /**
     * Initialise le jeu
     */
    public static void iniz() {
        fenetre = gReader.dimensionFenetre(listePFAG().get(indexPFAGUtilise));
        nombreEssai = gReader.nombreEssai(listePFAG().get(indexPFAGUtilise));
        gReader.initialisePigeons(listePFAG().get(indexPFAGUtilise));
        fond = gReader.listeImage(listePFAG().get(indexPFAGUtilise));
        addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
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
            System.out.println("Bug lecture des sources, source ou/et extensions incorectes");
        }
        return sources;
    }

    /**
     * A n'executer qu'en cas de rebellion du systeme
     */
    static public void order66() {
        System.exit(0);
    }
    
    /**
     * Super methode qui renvoie la valeur de tout les timers du jeu
     * @return Tout les timers du jeu sous la forme d'une chaine de charactere separe par un tiret
     */
    static public String soutAllTimer() {
        return HeartCore.t + " - " + HeartMoveBird.internalTime + " - " + HeartMoveObstacle.tWall;
    } 
}
