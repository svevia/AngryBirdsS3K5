package angrybirds.option;

import javafx.scene.control.Button;

public class BoutonOption extends Button {


    public BoutonOption(String text) {
        super(text);
        setPrefHeight(30);
        getStyleClass().add("boutonOption");
    }
}