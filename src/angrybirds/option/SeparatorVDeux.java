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

public class SeparatorVDeux extends VBox {

    Separator s = new Separator(Orientation.HORIZONTAL);
    Text t;
    Image img = new Image("ressource/triangle.png");
    Hyperlink b = new Hyperlink(null, new ImageView(img));
    HBox hb;
    VBox vb;
    int indexHided;
    
    
    public SeparatorVDeux(String text) {
        t = new Text(text);
        t.getStyleClass().add("textSeparator");
        b.getStyleClass().add("bouttonSeparator");
        hb = new HBox(t, b);
        getChildren().addAll(hb, s);
        b.setStyle("-fx-color: red;");
    }
    
    public void setOnAction (EventHandler<ActionEvent> event) {
        b.setOnAction(event);
    }
}
