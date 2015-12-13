package angrybirds.menu;

import angrybirds.FenetrePrincipale;
import static angrybirds.Constante.gf;
import angrybirds.jeu.GameFrame;
import static angrybirds.FenetrePrincipale.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Le menu du jeu a partir du quel on peut lancer le jeu, le configurer ou le quitter
 */
public class Menu extends GridPane implements EventHandler<ActionEvent> {

    /**
     * Le label au sommet du menu
     */
    private Label jeu = new Label("AngryBirds");
    
    /**
     * Le bouton jouer
     */
    private BoutonMenu jouer = new BoutonMenu("Jouer");
    
    /**
     * Le bouton option
     */
    private BoutonMenu option = new BoutonMenu("Options");
    
    /**
     * Le bouton quitter
     */
    private BoutonMenu quitter = new BoutonMenu("Quitter");
    
    /**
     * L'animation
     */
    private Thread fred = new Thread(new AnimationMenu(this));
    
    /**
     * La fenetre qui recoit
     */
    private FenetrePrincipale root;

    /**
     * Cree le menu sur root
     * @param root La fenetre qui recoit
     */
    public Menu(FenetrePrincipale root) {
        this.root = root;
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);

        jeu.getStyleClass().add("titreMenu");
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
            gf = new GameFrame();
            son.stop();
            gf.run();
        }

        if (event.getSource() == option) {
            root.changeScene(ChoseScene.OPTION);
        }

        if (event.getSource() == quitter) {
            System.exit(0);
        }
    }
}
