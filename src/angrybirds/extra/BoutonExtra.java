package angrybirds.extra;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Les boutons pimpes pour le menu extra
 */
public class BoutonExtra extends Button implements EventHandler<MouseEvent> {

    public BoutonExtra(String text) {
        super(text);

        setOnMouseEntered(this);
        setOnMouseExited(this);

        setStyle("-fx-background-color: "
                + "rgba(0,0,200,0.5);"
                + "-fx-background-radius: 40;"
                + "-fx-padding: 2 30 2 30;"
                + "-fx-text-fill: black;"
                + "-fx-font-size: 20px;");
        setPrefWidth(300);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
            setStyle("-fx-background-color: "
                    + "rgba(0,0,255,0.7);"
                    + "-fx-background-radius: 40;"
                    + "-fx-padding: 2 30 2 30;"
                    + "-fx-text-fill: black;"
                    + "-fx-font-size: 20px;");
        }
        if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            setStyle("-fx-background-color: "
                    + "rgba(0,0,200,0.5);"
                    + "-fx-background-radius: 40;"
                    + "-fx-padding: 2 30 2 30;"
                    + "-fx-text-fill: black;"
                    + "-fx-font-size: 20px;");
        }
    }
}
