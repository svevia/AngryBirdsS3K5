package angrybirds.menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Menu extends Application implements EventHandler<ActionEvent> {

    public static LivOne p;

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

    private BoutonMenu jouer = new BoutonMenu("Jouer");
    private BoutonMenu option = new BoutonMenu("Option");
    private BoutonMenu quitter = new BoutonMenu("Quitter");

    void ajouterComposant(GridPane root) {
        jouer.setOnAction(this);
        option.setOnAction(this);
        quitter.setOnAction(this);
        // Note ou plutot astuce de progra, ne commencez pas par l'index
        // 0 pour placer vos articles sur la grille, on sait jamais si d'autres
        // viennent s'ajouter avant, le resultat est le meme au final
        root.add(jouer, 5, 5);
        root.add(option, 5, 6);
        root.add(quitter, 5, 7);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == jouer) {
            p = new LivOne(10);
            p.run();
        }

        if (event.getSource() == option) {

        }

        if (event.getSource() == quitter) {
            System.exit(0);
        }
    }
}
