package angrybirds.extra;

import angrybirds.FenetrePrincipale;
import extra.lasergame.MainLaser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

/**
 * Petit menu des extras du jeu
 */
public class Extra extends GridPane implements EventHandler<ActionEvent> {

    private Label titre = new Label("Extras");

    /**
     * Le boutton donnant accees au jeu du laser
     */
    private Button jeuLaser = new BoutonExtra("Jeu du laser");

    /**
     * Le boutton du retour menu
     */
    private Button retourMenu = new Button("Retour au menu");

    /**
     * La fenetre principale
     */
    FenetrePrincipale root;

    public Extra(FenetrePrincipale root) {
        this.root = root;

        jeuLaser.setOnAction(this);
        retourMenu.setOnAction(this);

        setBackground(new Background(new BackgroundImage(new Image("ressource/fond.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(660, 980, false, false, true, true))));

        titre.getStyleClass().add("titreMenu");
        titre.setPadding(new Insets(0, 0, 25, 50));

        retourMenu.setPadding(new Insets(0, 20, 0, 0));
        setStyle("-fx-alignment: top-center;"
                + "-fx-padding: 100;");

        add(titre, 5, 1);
        add(jeuLaser, 5, 5);
        add(retourMenu, 4, 7);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == jeuLaser) {
            MainLaser ml = new MainLaser();
            ml.run();
        }
        if (event.getSource() == retourMenu) {
            root.changeScene(FenetrePrincipale.ChoseScene.MENU);
        }
    }
}
