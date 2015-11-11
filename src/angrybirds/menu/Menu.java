package angrybirds.menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Menu extends Application {

    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
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

    void ajouterComposant(FlowPane root) {
        root.getChildren().add(new Button("Jouer"));
        root.getChildren().add(new Button("Option"));
    }
}
