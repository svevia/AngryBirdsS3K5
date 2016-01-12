package entites.obstacle;

import entites.Skin;
import static entites.obstacle.ImpactOrder.destroy;
import static entites.obstacle.ImpactOrder.stopCore;
import java.awt.Color;
import modele.Courbe;

/**
 * Une poutre en bois qui se detruit relativement facilement
 */
public class PoutreBois extends Obstacle {

    public PoutreBois(int x, int y, int hight, Courbe crb, boolean vertical) {
        super(x, y, hight * 20 / 100, hight, crb);
        if (!vertical) {
            int tmp = super.hight;
            super.hight = super.widht;
            super.widht = tmp;
        }    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(new Color(136, 66, 29));
        s.getG().fill3DRect(x, y, widht, hight, true);
        return s;
    }

    @Override
    public void impact() {
        if (!destroy(this, 75)) {
            stopCore();
        }
    }
}
