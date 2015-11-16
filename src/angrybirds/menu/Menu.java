package angrybirds.menu;

import static angrybirds.menu.FenetrePrincipale.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Wissam
 */
public class Menu extends GridPane implements EventHandler<ActionEvent> {

    private Label jeu = new Label("AngryBirds");
    private BoutonMenu jouer = new BoutonMenu("Jouer");
    private BoutonMenu option = new BoutonMenu("Option");
    private BoutonMenu quitter = new BoutonMenu("Quitter");
    private Thread fred = new Thread(new AnimationMenu(this));
    private FenetrePrincipale root;

    public Menu(FenetrePrincipale root) {
        this.root = root;
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);

        jeu.setStyle("-fx-font-size: 40;\n"
                + "-fx-text-fill: rgba(255,0,0,1);\n"
                + "-fx-font-family: sans-serif;\n"
                + "-fx-font-angle: 40;\n"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,127,1) , 1,10,0,0 );\n"
                + "-fx-scale-y:3;\n"
                + "-fx-scale-x:3;"
        );
        jeu.setPadding(new Insets(0, 0, 25, 30));
        jouer.setOnAction(this);
        option.setOnAction(this);
        quitter.setOnAction(this);
        // Note ou plutot astuce de progra, ne commencez pas par l'index
        // 0 pour placer vos articles sur la grille, on sait jamais si d'autres
        // viennent s'ajouter avant, le resultat est le meme au final
        add(jeu, 5, 2);
        add(jouer, 5, 5);
        add(option, 5, 6);
        add(quitter, 5, 7);
        
        fred.start();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == jouer) {
            p = new LivOne(10);
            son.stop();
            p.run();
        }

        if (event.getSource() == option) {
            root.changeScene(2);
        }

        if (event.getSource() == quitter) {
            System.exit(0);
        }
    }
}
