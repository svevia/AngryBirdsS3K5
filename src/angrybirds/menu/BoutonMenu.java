package angrybirds.menu;

import javafx.scene.control.Button;

public class BoutonMenu extends Button {

    public BoutonMenu(String text) {
        super(text);
        setPrefHeight(100);
        setPrefWidth(300);
        setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n"
                + "-fx-background-radius: 30;\n"
                + "-fx-background-insets: 0;\n"
                + "-fx-text-fill: white;\n"
                + "-fx-font-family: monospace;\n"
                + "-fx-font-size: 40px;\n");
    }
}
