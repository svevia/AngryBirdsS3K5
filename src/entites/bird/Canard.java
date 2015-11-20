package entites.bird;

import java.awt.Color;
import entites.bird.Bird;
import entites.bird.module.BecCanard;
import entites.bird.module.Oeil;

/**
 * Class permettante de dessiner un canard
 */
public class Canard extends Bird {

    private BecCanard bec = new BecCanard(Math.PI / 4, 1, this, Color.yellow);
    private Oeil oeil = new Oeil(15, this, true, 5, Color.blue);

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public Canard() {
        super(0, 0, 40, 40, Color.white);
        addModule(bec);
        addModule(oeil);
    }
}
