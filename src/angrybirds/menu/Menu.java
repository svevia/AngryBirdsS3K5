package angrybirds.menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Menu extends Application {

    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(root, 1000, 666);
        Thread fred = new Thread(new AnimationMenu(root));
        ajouterComposant(root);

        primaryStage.setTitle("Manu Angry Birds");
        primaryStage.setScene(scene);
        primaryStage.show();
        fred.start();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void ajouterComposant(GridPane root) {
        BoutonMenu jouer = new BoutonMenu("Jouer");
        BoutonMenu option = new BoutonMenu("Option");
        BoutonMenu quitter = new BoutonMenu("Quitter");
        root.add(jouer, 0, 0);
        root.add(option, 0, 1);
        root.add(quitter, 0, 2);
    }
}
