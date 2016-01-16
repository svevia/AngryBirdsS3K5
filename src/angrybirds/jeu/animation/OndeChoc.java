package angrybirds.jeu.animation;

import static angrybirds.jeu.core.HeartCore.t;
import entites.Skin;
import java.awt.Color;

/**
 * Cree une onde de choc
 */
public class OndeChoc extends Animation {

    public OndeChoc(int centreX, int centreY, int tDepart, int duree) {
        super(centreX, centreY, tDepart, duree);
    }

    @Override
    public Skin draw(Skin s) {
        int tailleCercle = t - tDepart;
        s.getG().setColor(Color.cyan);
        s.getG().drawOval(centreX - tailleCercle/2, centreY - tailleCercle/2, tailleCercle, tailleCercle);
        return s;
    }

}
