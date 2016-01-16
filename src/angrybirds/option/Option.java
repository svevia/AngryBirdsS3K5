package angrybirds.option;

import static angrybirds.Constante.footstep;
import static angrybirds.Constante.indexPFAGUtilise;
import angrybirds.FenetrePrincipale;
import entites.bird.Footstep;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import static angrybirds.FenetrePrincipale.*;
import static modele.PFAGReader.listePFAG;

/**
 *  Les options permettent de configurer le jeu
 */
public class Option extends GridPane implements EventHandler<ActionEvent> {

    /**
     * La fenetre ou doit s'afficher les options
     */
    FenetrePrincipale root;
    
    /**
     * Le bloc principal
     */
    VBox vb = new VBox();
    
    /**
     * Le bloc secondaire
     */
    VBox vb2 = new VBox();
    
    /**
     * Le titre au sommet
     */
    Text option = new Text("Options");
    
    /**
     * Le label sur la liste deroulante
     */
    Text choiseMap = new Text("Choisissez votre map");
    
    /**
     * La liste deroulante
     */
    ChoiceBox<String> cb1 = new ChoiceBox<>(FXCollections.observableArrayList(listePFAG()));
    
    /**
     * Le label au dessus de la seconde liste deroulante
     */
    Text choiseFootstep = new Text("Choisissez votre empreinte");
    
    /**
     * La seconde liste deroulante
     */
    ChoiceBox<String> cb2 = new ChoiceBox<>(FXCollections.observableArrayList(Footstep.getListFootstep()));

    /**
     * Le bloc tout en bas avec les boutons
     */
    GridPane hb1 = new GridPane();
    
    /**
     * Le bloc secondaire du bloc si dessus
     */
    GridPane hb2 = new GridPane();
    
    /**
     * Le bouton qui permet de revenir en arriere
     */
    BoutonOption back = new BoutonOption("Retour au menu");
    
    /**
     * Le bouton qui permet d'appliquer les changements
     */
    BoutonOption apply = new BoutonOption("Appliquer");

    /**
     * Separateur qui gere la partie Divers des options
     */
    SeparatorVDeux s1 = new SeparatorVDeux("Divers", this);
    
    /**
     * Separateur du bloc tout en bas
     */
    Separator s2 = new Separator();

    /**
     * Construit les options sur la fenetre root
     * @param root La fenetre
     */
    public Option(FenetrePrincipale root) {
        
        setBackground(new Background(new BackgroundImage(new Image("ressource/sable.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        
        this.root = root;
        setAlignment(Pos.CENTER);
        option.getStyleClass().add("textOption1");
        choiseMap.getStyleClass().add("textOption2");
        choiseFootstep.getStyleClass().add("textOption2");

        vb.setMinSize(800, 666);
        vb.setAlignment(Pos.TOP_CENTER);
        vb2.setAlignment(Pos.TOP_CENTER);
       /* vb.setBackground(new Background(new BackgroundImage(new Image("ressource/papyrus.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        */
        back.setOnAction(this);
        apply.setOnAction(this);
        hb1.setAlignment(Pos.CENTER_LEFT);
        hb1.add(back, 0, 0);
        hb2.setAlignment(Pos.CENTER);
        hb2.add(apply, 0, 0);

        cb1.setValue(listePFAG().get(indexPFAGUtilise));
        String fsUse = footstep.toString();
        int indexFsUse = Footstep.getListFootstep().indexOf(fsUse);
        cb2.setValue(Footstep.getListFootstep().get(indexFsUse));

        vb2.getChildren().addAll(choiseMap, cb1, choiseFootstep, cb2);
        vb.getChildren().addAll(option, s1, vb2, s2, hb2, hb1);
        add(vb, 1, 1);

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == apply) {
            indexPFAGUtilise = listePFAG().indexOf(cb1.getValue());
            footstep = Footstep.valueOf(cb2.getValue());
        }
        if (event.getSource() == back) {
            root.changeScene(ChoseScene.MENU);
        }
        if (event.getSource() == s1.b) {
            if (vb.getChildren().contains(vb2)) {
                s1.indexHided = vb.getChildren().indexOf(vb2);
                vb.getChildren().remove(s1.indexHided);
            } else {
                vb.getChildren().add(s1.indexHided, vb2);
            }
        }
    }
}
