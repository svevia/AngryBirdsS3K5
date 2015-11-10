package ressource;

import static angrybirds.Constante.fenetre;
import entites.obstacle.Obstacle;
import entites.obstacle.skin.Carre;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class PFAGReader {

    String source;
    BufferedReader in;

    /**
     * Cree un reader pfag avec une source
     *
     * @param source
     */
    public PFAGReader(String source) {
        this.source = source;
    }

    /**
     * Liste toute les ImageCustomz du fichier pfag dans une hashmap
     *
     * @return La liste des images et leur positions, si aucune position n'est
     * specifie la position de l'image vaut 0
     */
    public HashMap<String, ImageCustomz> listeImage() {
        HashMap<String, ImageCustomz> hm = new HashMap<>();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        String name = "";
        String src = "";
        int x = 0, y = 0;
        boolean opacacite = false;
        try {
            in = Files.newBufferedReader(Paths.get(source), Charset.forName("UTF-8"));
            while ((line = in.readLine()) != null) {
                st = new StringTokenizer(line, ":");
                if (st.nextToken().equals("imagecustomz")) {
                    name = "";
                    src = "";
                    x = 0;
                    y = 0;
                    opacacite = false;
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
                            case "opaque":
                                if (st.nextToken().equals("true")) {
                                    opacacite = true;
                                } else {
                                    opacacite = false;
                                }
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

    /**
     * Liste toute les obstacles du fichier pfag dans une ArrayList
     *
     * @return La liste des images et leur positions, si aucune position n'est
     * specifie la position de l'image vaut 0
     */
    public ArrayList<Obstacle> listeObstacle() {
        ArrayList<Obstacle> ar = new ArrayList<>();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        String type = "";
        int x = 0, y = 0, w = 0, h = 0;
        Color couleur = Color.red;
        Random r = new Random();
        try {
            in = Files.newBufferedReader(Paths.get(source), Charset.forName("UTF-8"));
            while ((line = in.readLine()) != null) {
                x = 0;
                y = 0;
                w = 0;
                h = 0;
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
                            case "color":
                                couleur = new Color(Integer.parseInt(st.nextToken()));
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
                    if (type.equals("carre")) {
                        ar.add(new Carre(x, y, h, w, couleur));
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
    public Dimension dimensionFenetre() {
        Dimension d = new Dimension();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        int x = 0, y = 0;
        try {
            in = Files.newBufferedReader(Paths.get(source), Charset.forName("UTF-8"));
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
}
