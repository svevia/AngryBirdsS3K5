package angrybirds.extra;

import javafx.scene.control.Button;

/**
 * Les boutons pimpes pour le menu extra
 */
public class BoutonExtra extends Button {

    public BoutonExtra(String text) {
        super(text);

        setStyle("-fx-background-color: "
                + "rgba(0,0,0,0.08),"
                + "linear-gradient(#fafdfe, #e8f5fc),"
                + "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-radius: 40;"
                + "-fx-padding: 2 30 2 30;"
                + "-fx-text-fill: black;"
                + "-fx-font-size: 14px;");
        setPrefWidth(300);
    }

}
