package angrybirds.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javax.swing.Timer;

/**
 * Les boutons du menu
 */
public class BoutonMenu extends Button implements EventHandler<MouseEvent> {

    /**
     * Le thread qui fait tourner les tetes
     */
    Thread rotation;

    /**
     * Constuit un bouton comme je le veux
     * @param text Le texte du bouton
     */
    public BoutonMenu(String text) {
        super(text);
        setPrefHeight(100);
        setPrefWidth(300);
        setOnMouseEntered(this);
        setOnMouseExited(this);
        getStyleClass().add("boutonMenu");
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
            rotation = new RotateButton(this);
            rotation.start();
        }
        if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            rotation.interrupt();
        }
    }
}

/**
 *  Classe qui fait tourner les boutons, un bouton a son thread a lui 
 */
class RotateButton extends Thread implements ActionListener {

    /**
     * Angle d'inclinais maximal
     */
    int angleMax = 10;
    
    /**
     * Delay entre deux mouvement
     */
    int delay = 40;
    
    /**
     * Le boutton qui recoit
     */
    Button b;
    
    /**
     * La rotation actuel
     */
    double i;
    
    /**
     * Le boolean qui permet de connaitre le sens de rotation
     */
    boolean uping = true;
    
    /**
     * Le boolean qui permet de savoir quand c'est fini
     */
    boolean finish = false;
    
    /**
     * Le timer qui regularise la vitesse du bouton avec delay
     */
    Timer t = new Timer(delay, this);

    /**
     * Construit la rotation
     * @param b sur le bouton voulu
     */
    public RotateButton(Button b) {
        this.b = b;
        i = b.getRotate();
        t.setRepeats(false);
    }

    /**
     * Demarrage le tournage
     */
    public void start() {
        rotation();
    }

    @Override
    public void interrupt() {
        super.interrupt();
        finish = true;
    }

    /**
     * Fait tourner
     */
    void rotation() {
        if (uping) {
            i++;
            if (i > angleMax) {
                uping = false;
            }
        } else {
            i--;
            if (i < -angleMax) {
                uping = true;
            }
        }
        if (!finish) {
            t.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        b.setRotate(i);
        rotation();
    }
}
