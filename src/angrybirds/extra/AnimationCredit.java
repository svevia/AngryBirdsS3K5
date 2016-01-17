package angrybirds.extra;

import angrybirds.FenetrePrincipale;
import static java.lang.Thread.sleep;
import javafx.scene.Node;

/**
 *
 * @author Wissam
 */
public class AnimationCredit extends Thread {

    /**
     * Le node a bouger
     */
    Node n;
    
    /**
     * Le nombre de pixel a bouger
     */
    int pix = 0;
    
    /**
     * Le root de la page
     */
    FenetrePrincipale root;
    
    /**
     * Le constructeur de l'animation, l'animation va defiler une image vers le haut
     * de pix pixels
     * @param objetToMove
     * @param nbPixel
     * @param root 
     */
    public AnimationCredit(Node objetToMove, int nbPixel, FenetrePrincipale root) {
        n = objetToMove;
        pix = nbPixel;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            double max = n.getLayoutY() - pix;
            for (double i = n.getLayoutY(); i > max; i--) {
                try {
                    n.setLayoutY(i);
                    sleep(20);
                } catch (InterruptedException ex) {
                    System.out.println("Problème Credit Animation  - " + ex.getMessage());
                }
            }
            sleep(5000);
            root.changeScene(FenetrePrincipale.ChoseScene.EXTRA);
            this.stop();
        } catch (InterruptedException ex) {
            System.out.println("Come back invalid " + ex.getMessage());
        }
    }
}
