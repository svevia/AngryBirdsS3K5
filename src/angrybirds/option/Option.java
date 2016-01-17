package angrybirds.option;

import static angrybirds.Constante.*;
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
import java.util.ArrayList;
import static modele.PFAGReader.listePFAG;

/**
 * Les options permettent de configurer le jeu
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
     * Le bloc tertiaire
     */
    VBox vb3 = new VBox();

    /**
     * Le titre au sommet
     */
    Text option = new Text("Options");

    /**
     * Le label sur la liste deroulante
     */
    Text choiseMap = new Text("Choisissez votre map");

    /**
     * Le label sur la liste deroulante
     */
    Text fps = new Text("Raffraichissemet image par seconde");

    /**
     * La liste deroulante
     */
    ChoiceBox<String> cbMap = new ChoiceBox<>(FXCollections.observableArrayList(listePFAG()));

    /**
     * Le label au dessus de la seconde liste deroulante
     */
    Text choiseFootstep = new Text("Choisissez votre empreinte");

    /**
     * La seconde liste deroulante
     */
    ChoiceBox<String> cbFootPrint = new ChoiceBox<>(FXCollections.observableArrayList(Footstep.getListFootstep()));

    /**
     * La liste des fpd disponible
     */
    ArrayList<String> listFPS = new ArrayList<>(5);

    /**
     * La troisieme liste deroulante
     */
    ChoiceBox<String> cbFPS;

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
     * Separateur qui gere la partie Graphisme des options
     */
    SeparatorVDeux s3 = new SeparatorVDeux("Graphisme", this);

    /**
     * Separateur du bloc tout en bas
     */
    Separator s2 = new Separator();

    /**
     * Construit les options sur la fenetre root
     *
     * @param root La fenetre
     */
    public Option(FenetrePrincipale root) {

        listFPS.add("30");
        listFPS.add("60");
        listFPS.add("120");
        listFPS.add("Unlimited");
        cbFPS = new ChoiceBox<>(FXCollections.observableArrayList(listFPS));
        switch (FPSChose) {
            case FPS30:
                cbFPS.setValue("30");
                break;
            case FPS60:
                cbFPS.setValue("60");
                break;
            case FPS120:
                cbFPS.setValue("120");
                break;
            case FPSUNLIMITED:
                cbFPS.setValue("Unlimited");
                break;
        }
        
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
        fps.getStyleClass().add("textOption2");

        vb.setMinSize(800, 666);
        vb.setAlignment(Pos.TOP_CENTER);
        vb2.setAlignment(Pos.TOP_CENTER);
        vb3.setAlignment(Pos.TOP_CENTER);
        // Ancien background, remplace par du sable, parce que voila c'est cool le sable
       /* vb.setBackground(new Background(new BackgroundImage(new Image("ressource/papy-russe.png"),
         BackgroundRepeat.NO_REPEAT,
         BackgroundRepeat.REPEAT,
         BackgroundPosition.CENTER,
         BackgroundSize.DEFAULT)));
         */
        back.getStyleClass().add("boutonOption");
        apply.getStyleClass().add("boutonOption");

        cbMap.getStyleClass().add("scrollOption");
        cbFootPrint.getStyleClass().add("scrollOption");
        cbFPS.getStyleClass().add("scrollOption");

        back.setOnAction(this);
        apply.setOnAction(this);
        hb1.setAlignment(Pos.CENTER_LEFT);
        hb1.add(back, 0, 0);
        hb2.setAlignment(Pos.CENTER);
        hb2.add(apply, 0, 0);

        cbMap.setValue(listePFAG().get(indexPFAGUtilise));
        String fsUse = footstep.toString();
        int indexFsUse = Footstep.getListFootstep().indexOf(fsUse);
        cbFootPrint.setValue(Footstep.getListFootstep().get(indexFsUse));

        s2.setStyle("-fx-padding: 20;");

        vb2.getChildren().addAll(choiseMap, cbMap, choiseFootstep, cbFootPrint);
        vb3.getChildren().addAll(fps, cbFPS);
        vb.getChildren().addAll(option, s1, vb2, s3, vb3, s2, hb2, hb1);
        add(vb, 1, 1);

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == apply) {
            indexPFAGUtilise = listePFAG().indexOf(cbMap.getValue());
            footstep = Footstep.valueOf(cbFootPrint.getValue());
            switch (cbFPS.getValue()) {
                case "30":
                    FPSChose = FPS30;
                    break;
                case "60":
                    FPSChose = FPS60;
                    break;
                case "120":
                    FPSChose = FPS120;
                    break;
                case "Unlimited":
                    FPSChose = FPSUNLIMITED;
                    break;
            }
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
