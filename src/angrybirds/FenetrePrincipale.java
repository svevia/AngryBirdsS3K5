package angrybirds;

import static angrybirds.Constante.gf;
import angrybirds.jeu.GameFrame;
import angrybirds.menu.Menu;
import angrybirds.menu.MusicMenu;
import angrybirds.option.Option;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetrePrincipale extends Application {

    public enum ChoseScene {

        MENU(1),
        OPTION(2);

        int scene;

        private ChoseScene(int scene) {
            this.scene = scene;
        }

        public int getScene() {
            return scene;
        }
    }
    public static Thread son = new MusicMenu();
    public Menu menu = new Menu(this);
    public Option option = new Option(this);
    public Scene scene = new Scene(menu, 980, 660);

    public void start(Stage primaryStage) {
        scene.getStylesheets().add("ressource/stylesheet.css");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu Angry Birds");
        primaryStage.getIcons().add(new Image("ressource/icon.png"));
        primaryStage.show();
        son.start();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    public void changeScene(ChoseScene choseScene) {
        System.out.println(choseScene.getScene());
        switch (choseScene.getScene()) {
            case 1:
                scene.setRoot(menu);
                break;
            case 2:
                scene.setRoot(option);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        launch(args);
        gf = new GameFrame();
        gf.run();
    }
}
