package angrybirds.menu;

import angrybirds.menu.option.Option;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetrePrincipale extends Application {

    public static Scene scene;
    public static LivOne p;
    public static Thread son = new MusicMenu();

    public void start(Stage primaryStage) {
        Menu menu = new Menu();
        Option option = new Option();
        scene = new Scene(option, 1000, 666);
        primaryStage.setTitle("Menu Angry Birds");
        primaryStage.getIcons().add(new Image("ressource/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        son.start();
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
}
