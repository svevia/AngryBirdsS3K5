package ressource;

import modele.ImageCustomz;
import static angrybirds.Constante.fenetre;
import static angrybirds.Constante.listeFichier;
import modele.Courbe;
import entites.obstacle.Obstacle;
import entites.obstacle.Carre;
import entites.obstacle.Rond;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class PFAGReader {

    String source;
    BufferedReader in;
    HashMap<String, String> pfagOfSource;

    /**
     * Cree un reader du fichier src/ressource
     *
     */
    public PFAGReader() {
        this.source = "Ressource/ressource";
        pfagOfSource = listeFichier(source, "pfag");
    }

    /**
     * Liste toute les ImageCustomz du fichier pfag dans une hashmap
     *
     * @return La liste des images et leur positions, si aucune position n'est
     * specifie la position de l'image vaut 0
     */
    public LinkedHashMap<String, ImageCustomz> hashMapImage(String pfag) {
        LinkedHashMap<String, ImageCustomz> hm = new LinkedHashMap<>();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        String name = "";
        String src = "";
        int x = 0, y = 0;
        try {
            in = Files.newBufferedReader(Paths.get("Ressource/" + pfagOfSource.get(pfag)));
            while ((line = in.readLine()) != null) {
                st = new StringTokenizer(line, ":");
                if (st.nextToken().equals("imagecustomz")) {
                    name = "";
                    src = "";
                    x = 0;
                    y = 0;
                    st2 = new StringTokenizer(st.nextToken(), ",");
                    while (st2.hasMoreTokens()) {
                        st = new StringTokenizer(st2.nextToken(), "=");
                        switch (st.nextToken()) {
                            case "name":
                                name = st.nextToken();
                                break;
                            case "src":
                                src = st.nextToken();
                                break;
                            case "x":
                                x = Integer.parseInt(st.nextToken());
                                break;
                            case "y":
                                y = Integer.parseInt(st.nextToken());
                                break;
                            default:
                                System.out.println("Un argument est incorrecte " + st.nextToken());
                                break;
                        }
                    }
                    hm.put(name, new ImageCustomz(x, y, src));
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Bug lecture");
        }
        return hm;
    }

    public ArrayList<ImageCustomz> listeImage(String pfag) {
        ArrayList<ImageCustomz> al = new ArrayList<>();
        HashMap<String, ImageCustomz> src = hashMapImage(pfag);
        for (HashMap.Entry<String, ImageCustomz> entry : src.entrySet()) {
            al.add(entry.getValue());
        }
        return al;
    }

    /**
     * Liste tout les fichiers pfag du repertoire Ressource/ressource
     *
     * @return Tout les fichiers pfag du repertoire Ressource/ressource
     */
    public static ArrayList<String> listePFAG() {
        ArrayList<String> ar = new ArrayList<>();
        HashMap<String, String> src = listeFichier("Ressource/ressource", "pfag");
        for (HashMap.Entry<String, String> entry : src.entrySet()) {
            ar.add(entry.getKey());
        }
        return ar;
    }

    /**
     * Liste toute les obstacles du fichier pfag dans une ArrayList
     *
     * @return La liste des images et leur positions, si aucune position n'est
     * specifie la position de l'image vaut 0
     */
    public ArrayList<Obstacle> listeObstacle(String pfag) {
        ArrayList<Obstacle> ar = new ArrayList<>();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        String type = "";   
        int x = 0, y = 0, w = 0, h = 0, mouvementMax = 0;
        double aX = 0, bX = 0, aY = 0, bY = 0;
        Color couleur = Color.red;
        Random r = new Random();
        try {
            in = Files.newBufferedReader(Paths.get("Ressource/" + pfagOfSource.get(pfag)));
            while ((line = in.readLine()) != null) {
                x = 0;
                y = 0;
                w = 0;
                h = 0;
                aX = 0;
                bX = 0;
                aY = 0;
                bY = 0;
                mouvementMax = 0;
                st = new StringTokenizer(line, ":");
                if (st.nextToken().equals("obstacle")) {
                    st2 = new StringTokenizer(st.nextToken(), ",");
                    while (st2.hasMoreTokens()) {
                        st = new StringTokenizer(st2.nextToken(), "=");
                        switch (st.nextToken()) {
                            case "type":
                                type = st.nextToken();
                                break;
                            case "x":
                                x = Integer.parseInt(st.nextToken());
                                break;
                            case "y":
                                y = Integer.parseInt(st.nextToken());
                                break;
                            case "w":
                                w = Integer.parseInt(st.nextToken());
                                break;
                            case "h":
                                h = Integer.parseInt(st.nextToken());
                                break;
                            case "aX":
                                aX = Double.parseDouble(st.nextToken());
                                break;
                            case "bX":
                                bX = Double.parseDouble(st.nextToken());
                                break;
                            case "cX":
                                x = Integer.parseInt(st.nextToken());
                                break;
                            case "aY":
                                aY = Double.parseDouble(st.nextToken());
                                break;
                            case "bY":
                                bY = Double.parseDouble(st.nextToken());
                                break;
                            case "cY":
                                y = Integer.parseInt(st.nextToken());
                                break;
                            case "color":
                                couleur = new Color(Integer.parseInt(st.nextToken()));
                                break;
                            case "mouvement":
                                mouvementMax = Integer.parseInt(st.nextToken());
                                break;
                            default:
                                System.out.println("Un argument est incorrecte " + st.nextToken());
                                break;
                        }
                    }
                    if (x == 0) {
                        x = r.nextInt(fenetre.width - 500) + 500;
                    }
                    if (y == 0) {
                        y = r.nextInt(fenetre.height);
                    }
                    if (w == 0) {
                        w = r.nextInt(100) + 100;
                    }
                    if (h == 0) {
                        h = r.nextInt(100) + 100;
                    }
                    if (mouvementMax == 0) {
                        if (type.equals("carre")) {
                            ar.add(new Carre(x, y, h, w, new Courbe(aX, bX, x, aY, bY, y), couleur));
                        }
                        if (type.equals("rond")) {
                            ar.add(new Rond(x, y, h, w, new Courbe(aX, bX, x, aY, bY, y), couleur));
                        }
                    } else {
                        if (type.equals("carre")) {
                            ar.add(new Carre(x, y, h, w, new Courbe(aX, bX, x, aY, bY, y, mouvementMax, true), couleur));
                        }
                        if (type.equals("rond")) {
                            ar.add(new Rond(x, y, h, w, new Courbe(aX, bX, x, aY, bY, y, mouvementMax, true), couleur));
                        }
                    }
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Bug lecture");
        }
        return ar;
    }

    /**
     *
     * @return La taille de la fenetre si specifie dans le ficher pfag si non
     * par defaut la fenetre fait 1920 par 1080 p
     */
    public Dimension dimensionFenetre(String pfag) {
        Dimension d = new Dimension();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        int x = 0, y = 0;
        try {
            in = Files.newBufferedReader(Paths.get("Ressource/" + pfagOfSource.get(pfag)));
            while ((line = in.readLine()) != null) {
                st = new StringTokenizer(line, ":");
                if (st.nextToken().equals("fenetre")) {
                    st2 = new StringTokenizer(st.nextToken(), ",");
                    while (st2.hasMoreTokens()) {
                        st = new StringTokenizer(st2.nextToken(), "=");
                        switch (st.nextToken()) {
                            case "x":
                                x = Integer.parseInt(st.nextToken());
                                break;
                            case "y":
                                y = Integer.parseInt(st.nextToken());
                                break;
                            default:
                                System.out.println("Un argument est incorrecte " + st.nextToken());
                                break;
                        }
                    }
                    d = new Dimension(x, y);
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Bug lecture");
        }
        return d;
    }

    /**
     *
     * @param pfag
     * @return La position du pigeon par le biais d'une Dimension
     */
    public Dimension positionOiseau(String pfag) {
        Dimension d = new Dimension();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        int x = 0, y = 0;
        try {
            in = Files.newBufferedReader(Paths.get("Ressource/" + pfagOfSource.get(pfag)));
            while ((line = in.readLine()) != null) {
                st = new StringTokenizer(line, ":");
                if (st.nextToken().equals("bird")) {
                    st2 = new StringTokenizer(st.nextToken(), ",");
                    while (st2.hasMoreTokens()) {
                        st = new StringTokenizer(st2.nextToken(), "=");
                        switch (st.nextToken()) {
                            case "x":
                                x = Integer.parseInt(st.nextToken());
                                break;
                            case "y":
                                y = Integer.parseInt(st.nextToken());
                                break;
                            default:
                                System.out.println("Un argument est incorrecte " + st.nextToken());
                                break;
                        }
                    }
                    d = new Dimension(x, y);
                }
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Bug lecture");
        }
        return d;
    }
}
