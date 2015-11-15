package angrybirds.menu.option;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Wissam
 */
public class Option extends GridPane {

    private Label jeu = new Label("AngryBirds");

    public Option() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        jeu.setStyle("-fx-font-size: 40;\n"
                + "-fx-text-fill: rgba(255,0,0,1);\n"
                + "-fx-font-family: sans-serif;\n"
                + "-fx-font-angle: 40;\n"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,127,1) , 1,10,0,0 );\n"
                + "-fx-scale-y:3;\n"
                + "-fx-scale-x:3;"
        );
        jeu.setPadding(new Insets(0, 0, 25, 30));
    }

}
