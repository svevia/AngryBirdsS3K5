package ressource;

import angrybirds.Constante;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Fonction qui contient actuellement une hashmap et sa methode qui permet de la
 * mettre a jour, cetet classe joue aussi avec l'api nio de java pour trouver
 * toute les images des ressources
 */
public class AllRessource {

    //Tentative qui n'a étrangement pas marché.....
    /**
     * Contient toute les images png avec comme clef le nom de l'image Exemple
     * ciel.png -> Key : ciel, Valeur : ImageCustomz(0, 0,
     * src/ressource/ciel.png) A besoin d'une mise a jour pour fonctionner, si
     * non cetet liste est vide
     */
    static public HashMap<String, ImageCustomz> allImageRessource = listeImage();

    /**
     * Met a jour la hashmap avec toute les images !png! du dossier ressource
     *
     * @throws IOException
     *
     */
    static public HashMap<String, ImageCustomz> listeImage() {
        HashMap<String, ImageCustomz> yolo = new HashMap<>();
        try {
            Path path = Paths.get("src/ressource");
            DirectoryStream<Path> stream;
            stream = Files.newDirectoryStream(path);
            try {
                Iterator<Path> iterator = stream.iterator();
                while (iterator.hasNext()) {
                    Path p = iterator.next();
                    String tmp = p.toString();
                    String extend = tmp.substring(tmp.length() - 3, tmp.length());
                    if (extend.equals("png")) {
                        tmp = p.getFileName().toString();
                        tmp = tmp.substring(0, tmp.length() - 4);
                        String chemin = p.toString().substring(3);
                        // Parce que nio nous embéte à mettre ses slash à l'enver
                        chemin = chemin.replace('\\', '/');
                        System.out.println(tmp);
                        if (!tmp.equals("herbe")) {
                            yolo.put(tmp, new ImageCustomz(0, 0, chemin));
                        } else {
                            yolo.put(tmp, new ImageCustomz(0, Constante.fenetre.height-100, chemin));
                        }
                    }
                }
            } finally {
                stream.close();
            }
        } catch (IOException ex) {
            System.out.println("Bug AllRessource");
        }
        return yolo;
    }

//    static public ImageCustomz ciel = new ImageCustomz(0, 0, "/ressource/ciel.png");
//    static public ImageCustomz nuage = new ImageCustomz(0, 0, "/ressource/nuage.png");
//    static public ImageCustomz herbe = new ImageCustomz(0, Constante.fenetre.height-100, "/ressource/herbe.png");
}
