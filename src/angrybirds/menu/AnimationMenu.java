package angrybirds.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javax.swing.Timer;

/**
 * L'animation du jeu 
 */
public class AnimationMenu implements Runnable, ActionListener {

    /**
     * Le tomer de l'animation
     */
    Timer t = new Timer(500, this);

    /**
     * Le boolean qui permet de savoir quelle image doit s'afficher
     */
    boolean boobool = true;

    /**
     * La Pane qui recoit
     */
    Pane racine;

    /**
     * La premiere image de l'animation
     */
    Image img1 = new Image("ressource/rayonBleu1.png");

    /**
     * La seconde image de l'animation
     */
    Image img2 = new Image("ressource/rayonBleu2.png");

    /**
     * Le background de la premere image
     */
    Background bkg1 = new Background(new BackgroundImage(img1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

    /**
     * Le background de la seconde image
     */
    Background bkg2 = new Background(new BackgroundImage(img2, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

    /**
     * Construit une animation
     * @param r Le menu qui recoit l'animation
     */
    public AnimationMenu(Pane r) {
        racine = r;
    }

    @Override
    public void run() {
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (boobool) {
            racine.setBackground(bkg1);
            boobool = false;
        } else {
            racine.setBackground(bkg2);
            boobool = true;
        }
    }
}
