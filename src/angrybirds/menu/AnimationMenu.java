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

public class AnimationMenu implements Runnable, ActionListener {

    Timer t = new Timer(500, this);
    boolean boobool = true;
    Pane racine;
    
    Image img1 = new Image("ressource/rayonBleu1.png");
    Image img2 = new Image("ressource/rayonBleu2.png");
    Background bkg1 = new Background(new BackgroundImage(img1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
    Background bkg2 = new Background(new BackgroundImage(img2, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

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
