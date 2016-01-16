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
     * Le bouton du site web
     */
    private Button siteWeb = new BoutonExtra("Le site web");

    /**
     * Le bouton des credits
     */
    private Button credit = new BoutonExtra("Credits");

    /**
     * Le boutton du retour menu
     */
    private Button retourMenu = new Button("Menu");

    /**
     * La fenetre principale
     */
    FenetrePrincipale root;
    
    public Extra(FenetrePrincipale root) {
        this.root = root;
        
        setVgap(10);
        
        jeuLaser.setOnAction(this);
        siteWeb.setOnAction(this);
        credit.setOnAction(this);
        retourMenu.setOnAction(this);
        
        setBackground(new Background(new BackgroundImage(new Image("ressource/fond.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(660, 980, false, false, true, true))));
        
        titre.getStyleClass().add("titreMenu");
        titre.setPadding(new Insets(0, 0, 25, 50));
        
        retourMenu.setPadding(new Insets(0, 20, 0, 0));
        setStyle("-fx-alignment: top-center;"
                + "-fx-padding: 100;");
        
        retourMenu.setStyle("-fx-background-color:"
                + "linear-gradient(#fff035, #ffa900),"
                + "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                + "-fx-background-radius: 6, 5;"
                + "-fx-background-insets: 0, 1;"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );"
                + "-fx-text-fill: #395306;"
                + "-fx-text-align: center;"
                + "-fx-padding: 4;");
        add(titre, 5, 1);
        add(jeuLaser, 5, 5);
        add(siteWeb, 5, 6);
        add(credit, 5, 7);
        setVgap(20);
        add(retourMenu, 5, 8);
    }
    
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == jeuLaser) {
            MainLaser ml = new MainLaser();
            ml.run();
        }
        if (event.getSource() == siteWeb) {
            root.changeScene(FenetrePrincipale.ChoseScene.WEB);
        }
        if (event.getSource() == credit) {
        }
        if (event.getSource() == retourMenu) {
            root.changeScene(FenetrePrincipale.ChoseScene.MENU);
        }
    }
}
