package angrybirds.option;

import angrybirds.menu.FenetrePrincipale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Option extends Pane {

    private FenetrePrincipale root; 
    
    public Option(FenetrePrincipale root) {
        this.root = root;
        // La box contenant tout les autres nodes
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
//        vb.setBackground(new Background(new BackgroundImage(new Image("ressource/papyrus.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // La barre de retour en bas de l'écran
        HBox hb = new HBox();
        Button back = new Button("Retour au menu");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.changeScene(1);
            }
        });
        hb.getChildren().add(back);

        // Le scrollPane qui contient la VBox
        ScrollPane sp = new ScrollPane(vb);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Text option = new Text("Option");
        CheckBox pe = new CheckBox("Plein ecran");

        vb.getChildren().addAll(option, pe, hb);
        getChildren().add(vb);

    }

}
