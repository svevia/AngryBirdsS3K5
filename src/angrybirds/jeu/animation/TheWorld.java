package angrybirds.jeu.animation;

import static angrybirds.jeu.core.HeartCore.t;
import entites.Skin;
import java.awt.Color;
import java.awt.Font;

/**
 * ザワールド !!!
 */
public class TheWorld extends Animation {

    public TheWorld(int centreX, int centreY, int tDepart) {
        super(centreX, centreY, tDepart, 900);
    }

    @Override
    public Skin draw(Skin s) {
        int tmp = t - tDepart;
        if (tmp < 800) {
            s.getG().setColor(Color.YELLOW);
        } else {
            s.getG().setColor(Color.RED);
        }
        s.getG().setFont(new Font(null, Font.BOLD, 40));
        s.getG().drawString("ザワールド", centreX - 20, centreY - 35);
        s.getG().setFont(new Font(null, Font.BOLD, 15));
        s.getG().drawString("" + tmp, centreX + 50, centreY - 15);
        return s;
    }

}
