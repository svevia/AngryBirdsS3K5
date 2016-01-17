package entites.obstacle;

import entites.Skin;
import static entites.obstacle.ImpactOrder.destroy;
import static entites.obstacle.ImpactOrder.stopCore;
import java.awt.Color;
import modele.Courbe;

/**
 *
 * @author Wissam
 */
public class PoutreVerre extends Obstacle {

    public PoutreVerre(int x, int y, int hight, Courbe crb, boolean vertical) {
        super(x, y, hight * 20 / 100, hight, crb);
        if (!vertical) {
            int tmp = super.hight;
            super.hight = super.widht;
            super.widht = tmp;
            super.hb.h = super.hight;
            super.hb.w = super.widht;
        }
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(Color.CYAN);
        s.getG().fill3DRect(x, y, widht, hight, true);
        return s;
    }

    @Override
    public void impact() {
        if (!destroy(this, 25)) {
            stopCore();
        }
    }
}
