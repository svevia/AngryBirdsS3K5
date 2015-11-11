package angrybirds;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javax.swing.Timer;

public class Menu extends Application {

    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1000, 666);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread fred = new Thread(new fredAnimation(scene, primaryStage));
        fred.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

class fredAnimation implements Runnable, ActionListener {

    Timer t = new Timer(500, this);
    boolean boobool = true;
    Scene scene;
    Stage primaryStage;

    Image img1 = new Image("ressource/rayonBleu1.png");
    Image img2 = new Image("ressource/rayonBleu2.png");

    public fredAnimation(Scene s, Stage sp) {
        scene = s;
        primaryStage = sp;
    }

    @Override
    public void run() {
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (boobool) {
            scene.setFill(new ImagePattern(img1));
            boobool = false;
        } else {
            scene.setFill(new ImagePattern(img2));
            boobool = true;
        }
    }
}
