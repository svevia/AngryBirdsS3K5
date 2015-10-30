package entites.bird.skin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import entites.bird.Bird;
import entites.bird.module.BecTriangulaire;
import entites.bird.module.Oeil;

/**
 * Class permettante de dessiner un oiseau tout rouge
 */
public class RougeGorge extends Bird {

    private BecTriangulaire bec = new BecTriangulaire(2, Math.PI / 4, 1, this, Color.orange);
    private Oeil oeil = new Oeil(8, this, true, 3, Color.BLACK);

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public RougeGorge() {
        super(0, 0, 20, 20, Color.red);
        addModule(bec);
        addModule(oeil);
        hb.setD(new Dimension((int) (20 + bec.getSize()), 20));
    }

    @Override
    public Graphics draw(Graphics g) {
        super.birdCenterX = getX() + getWidht() / 2;
        super.birdCenterY = getY() + getHight() / 2;

        super.hb.setPosition(getX(), getY());
        g = drawAllModule(g, false);
        g = MinimalBirdFactory(g);
        g = drawAllModule(g, true);
        return g;
    }
}
