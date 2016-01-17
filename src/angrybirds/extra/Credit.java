package angrybirds.extra;

import angrybirds.FenetrePrincipale;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * Le label des credits
 */
public class Credit extends Pane {

    /**
     * L'animation des credits
     */
    private AnimationCredit anim;

    /**
     * L'image a animer
     */
    private ImageView iv;
    
    /**
     * Le root
     */
    private FenetrePrincipale root;
    
    /**
     * Crer l'animation des credits
     * @param root Le root sur le quel s'applique les credits
     */
    public Credit(FenetrePrincipale root) {

        setBackground(new Background(new BackgroundImage(new Image("ressource/fond.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(660, 980, false, false, true, true))));

        this.root = root;
        Image credit = new Image("ressource/credit.png");
        iv = new ImageView(credit);
        iv.setLayoutX(250);
        iv.setLayoutY(200);
        getChildren().add(iv);
        anim = new AnimationCredit(iv, 1300, root);
    }

    public void go() {
        iv.setLayoutY(200);
        anim = new AnimationCredit(iv, 1300, root);
        anim.start();
    }
}
