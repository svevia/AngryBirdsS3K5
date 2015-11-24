package angrybirds.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javax.swing.Timer;

public class BoutonMenu extends Button implements EventHandler<MouseEvent> {

    Thread rotation;

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

class RotateButton extends Thread implements ActionListener {

    int angleMax = 10, delay = 40;
    Button b;
    double i;
    boolean uping = true, finish = false;
    Timer t = new Timer(delay, this);

    public RotateButton(Button b) {
        this.b = b;
        i = b.getRotate();
        t.setRepeats(false);
    }

    public void start() {
        rotation();
    }

    @Override
    public void interrupt() {
        super.interrupt();
        finish = true;
    }

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
