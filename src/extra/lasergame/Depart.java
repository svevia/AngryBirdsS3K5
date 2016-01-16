package extra.lasergame;

import entites.Skin;
import entites.bird.Bird;
import java.awt.Color;
import modele.Courbe;

/**
 * Point de depart du laser
 *
 */
public class Depart extends Bird {

    public Depart(Courbe c) {
        super(0, 0, 20, 0, c, Color.red);
    }

    @Override
    public Skin draw(Skin s) {
        return super.draw(s);
    }
}
