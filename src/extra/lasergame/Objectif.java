package extra.lasergame;

import entites.Skin;
import entites.obstacle.Obstacle;
import java.awt.Color;
import modele.Courbe;

/**
 * Finalite du jeu
 *
 * @author Wissam
 */
public class Objectif extends Obstacle {

    public Objectif(int x, int y, int widht, int hight, Courbe crb) {
        super(x, y, widht, hight, crb);
    }

    @Override
    public void impact() {
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setColor(Color.green);
        s.getG().fillRect(x, y, widht, hight);
        return s;
    }

}
