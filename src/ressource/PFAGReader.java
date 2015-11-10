package ressource;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
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
     * @return La liste des imges
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

    public Dimension dimensionFenetre() {
        Dimension d = new Dimension();
        String line = "";
        StringTokenizer st;
        StringTokenizer st2;
        int x = 0, y = 0;
        try {
            in = Files.newBufferedReader(Paths.get(source), Charset.forName("UTF-8"));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
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

    public static void main(String[] args) {
        PFAGReader gReader = new PFAGReader("src/ressource/plaine.pfag");
        HashMap<String, ImageCustomz> hm = gReader.listeImage();
        Dimension d = gReader.dimensionFenetre();
        System.out.println(hm);
        System.out.println(d);
    }
}
