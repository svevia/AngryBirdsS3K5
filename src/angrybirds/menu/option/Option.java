package angrybirds.menu.option;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Option extends Pane {

    private Label jeu = new Label("Option");
    VBox gp = new VBox();
    ScrollPane sp = new ScrollPane(gp);
    Background bkg1 = new Background(new BackgroundImage(new Image("ressource/papyrus.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

    public Option() {

        jeu.setStyle("-fx-font-size: 40;\n"
                + "-fx-text-fill: rgba(255,0,0,1);\n"
                + "-fx-font-family: sans-serif;\n"
                + "-fx-font-angle: 40;\n"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,127,1) , 1,10,0,0 );\n"
                + "-fx-scale-y:3;\n"
                + "-fx-scale-x:3;"
        );
        gp.getChildren().add(jeu);
        gp.setAlignment(Pos.CENTER);
        gp.setPrefSize(800, 666);
        gp.setFillWidth(false);
        gp.setBackground(bkg1);
        sp.setLayoutX(100);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        getChildren().add(sp);
    }

}
