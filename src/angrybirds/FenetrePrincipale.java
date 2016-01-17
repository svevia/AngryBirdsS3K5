package angrybirds;

import static angrybirds.Constante.*;
import angrybirds.extra.Credit;
import angrybirds.extra.Extra;
import angrybirds.extra.WebViewer;
import angrybirds.menu.Menu;
import angrybirds.menu.MusicMenu;
import angrybirds.option.Option;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Cette classe represente le point de depart du programme, quand la fontion
 * start est utilise (par le biais de lunch), elle ouvrira une fenetre du menu
 * du jeu
 */
public class FenetrePrincipale extends Application {

    /**
     * Enum qui permet de modifier la scene
     */
    public enum ChoseScene {

        MENU(1),
        OPTION(2),
        EXTRA(3),
        WEB(4),
        CREDIT(5);

        int scene;

        private ChoseScene(int scene) {
            this.scene = scene;
        }

        public int getScene() {
            return scene;
        }
    }

    /**
     * Le son du menu
     */
    public static Thread son = new MusicMenu();

    /**
     * Le menu
     */
    public Menu menu = new Menu(this);

    /**
     * Les options
     */
    public Option option = new Option(this);

    /**
     * Le menu des extras
     */
    public Extra extra = new Extra(this);

    /**
     * Le site web du jeu
     */
    public WebViewer web = new WebViewer("http://77.149.96.131/AngryBeurds/");

    /**
     * Les credits du jeu
     */
    public Credit credit = new Credit(this);
    
    /**
     * La scene principale
     */
    public Scene scene = new Scene(menu, 980, 660);

    /**
     * Demarre le menu
     *
     * @param primaryStage
     */
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
                order66();
            }
        });
    }

    /**
     * Change la scene sur la scene voulu
     *
     * @param choseScene Enumerateur de la scene
     */
    public void changeScene(ChoseScene choseScene) {
        switch (choseScene.getScene()) {
            case 1:
                scene.setRoot(menu);
                break;
            case 2:
                scene.setRoot(option);
                break;
            case 3:
                scene.setRoot(extra);
                break;
            case 4:
                scene.setRoot(web);
                break;
            case 5:
                scene.setRoot(credit);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Attention, ne garder sans commentaires que une des options si dessous

        // Cette ligne sert à lancer le menu
//        launch(args);
        // Ces lignes servent à lancer angry birds sans menu
        gf = new angrybirds.jeu.GameFrame();
        gf.run();
        // Ces lignes servent à lancer le jeu du laser sans menu
//        MainLaser ml = new MainLaser();
//        ml.run();
    }
}
