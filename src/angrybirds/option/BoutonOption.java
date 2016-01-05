package angrybirds.option;

import javafx.scene.control.Button;

/**
 * Un bouton des options (actuellement pauvre au niveau du pimpage) 
 */
public class BoutonOption extends Button {

    /**
     * Construit un bouton tel souhaite
     * @param text Avec un texte
     */
    public BoutonOption(String text) {
        super(text);
        setPrefHeight(30);
        getStyleClass().add("boutonOption");
    }
}