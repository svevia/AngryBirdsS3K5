package angrybirds.extra;

import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Un petit moteur web
 */
public class WebViewer extends Pane {

    public WebViewer(String lien) {
        WebView view = new WebView();
        WebEngine eng = view.getEngine();
        view.setMinSize(990, 670);
        view.setPrefSize(990, 670);
        eng.load(lien);
        getChildren().addAll(view);
    }
}
