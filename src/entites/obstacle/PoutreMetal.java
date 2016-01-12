package entites.obstacle;

import static entites.obstacle.ImpactOrder.*;
import entites.Skin;
import java.awt.Color;
import modele.Courbe;

/**
 * Une poutre en metal ultra resistante
 */
public class PoutreMetal extends Obstacle {

    public PoutreMetal(int x, int y, int hight, Courbe crb, boolean vertical) {
        super(x, y, hight * 20 / 100, hight, crb);
        if (!vertical) {
            int tmp = super.hight;
            super.hight = super.widht;
            super.widht = tmp;
        }
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(Color.gray);
        s.getG().fill3DRect(x, y, widht, hight, true);
        return s;
    }

    @Override
    public void impact() {
        if (!destroy(this, 1500)) {
            stopCore();
        }    }
}
