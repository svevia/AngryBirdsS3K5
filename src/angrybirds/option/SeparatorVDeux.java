package angrybirds.option;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Mon separateur a moi permet de cacher ou de montrer certaine partie d'un bloc
 * en appuyant sur un bouton (magique), il contient un label et une ligne en
 * plus
 */
public class SeparatorVDeux extends VBox {

    /**
     * Le separateur
     */
    Separator s = new Separator(Orientation.HORIZONTAL);

    /**
     * Le texte sur le separatuer
     */
    Text t;

    /**
     * L'image sur le separateur
     */
    Image img = new Image("ressource/triangle.png");

    /**
     * Le bouton a parametrer
     */
    Hyperlink b = new Hyperlink(null, new ImageView(img));

    /**
     * Conteneur secondaire
     */
    HBox hb;

    /**
     * Conteneur principal
     */
    VBox vb;

    /**
     * L'index de l'element cache
     */
    int indexHided;

    /**
     * Construit un separateur avec un bouton avec un evenement et un texte
     *
     * @param event L'evenement a prendre en compte
     * @param text Le texte
     */
    public SeparatorVDeux(String text, EventHandler<ActionEvent> event) {
        t = new Text(text);
        t.getStyleClass().add("textSeparator");
        b.getStyleClass().add("bouttonSeparator");
        hb = new HBox(t, b);
        getChildren().addAll(hb, s);
        b.setStyle("-fx-color: red;");
        b.setOnAction(event);
    }

    /**
     * Modifie l'action du bouton
     *
     * @param event La nouvelle action
     */
    public void setOnAction(EventHandler<ActionEvent> event) {
        b.setOnAction(event);
    }
}
