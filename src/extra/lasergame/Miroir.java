package extra.lasergame;

import entites.Skin;
import entites.obstacle.Obstacle;
import java.awt.Color;
import modele.Courbe;

/**
 *  Un obstacle reflettant le laser
 */
public class Miroir extends Obstacle {

    public Miroir(int x, int y, int widht, int hight, Courbe crb) {
        super(x, y, widht, hight, crb);
    }

    @Override
    public void impact() {
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(Color.blue);
        s.getG().fillRect(x, y, widht, hight);
        return s;
    }
}
