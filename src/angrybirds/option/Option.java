package angrybirds.option;

import angrybirds.menu.FenetrePrincipale;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Option extends GridPane implements EventHandler<ActionEvent> {

    FenetrePrincipale root;
    VBox vb = new VBox();
    Text option = new Text("Option");
    ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList(
            "First", "Second", "Third")
    );
    CheckBox pe = new CheckBox("Plein ecran");

    GridPane hb1 = new GridPane();
    GridPane hb2 = new GridPane();
    Button back = new Button("Retour au menu");
    Button apply = new Button("Appliqué");

    Separator s1 = new Separator();
    Separator s2 = new Separator();

    public Option(FenetrePrincipale root) {

        this.root = root;
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: red;");

        vb.setMinSize(800, 666);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.setBackground(new Background(new BackgroundImage(new Image("ressource/papyrus.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        back.setOnAction(this);
        apply.setOnAction(this);
        hb1.setAlignment(Pos.CENTER_LEFT);
        hb1.add(back, 0, 0);
        hb2.setAlignment(Pos.CENTER);
        hb2.add(apply, 0, 0);

        vb.getChildren().addAll(option, s1, pe, cb, s2, hb2, hb1);
        add(vb, 1, 1);

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == apply) {
            System.out.println("ouaip");
        }
        if (event.getSource() == back) {
            root.changeScene(1);
        }
    }

}
