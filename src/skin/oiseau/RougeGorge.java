package skin.oiseau;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import skin.Bird;

/**
 * Class permettante de dessiner un oiseau tout rouge
 */
public class RougeGorge extends Bird {

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public RougeGorge() {
        super(0, 0, 20, 20, 2, 3, Math.PI / 4, 0.7, Color.red, Color.yellow, Color.black);
        super.hb.setD(new Dimension(30, 30));
    }

    @Override
    public Graphics draw(Graphics g) {
        super.birdCenterX = getX() + getWidht() / 2;
        super.birdCenterY = getY() + getHight() / 2;

        // Le bec du rouge gorge
        super.polyX[0] = (int) (birdCenterX + r * Math.cos(getA() - tailleBec));
        super.polyX[1] = (int) (birdCenterX + 1.5 * r * Math.cos(getA()));
        super.polyX[2] = (int) (birdCenterX + r * Math.cos(getA() + tailleBec));
        super.polyY[0] = (int) (birdCenterY + r * Math.sin(getA() - tailleBec));
        super.polyY[1] = (int) (birdCenterY + 1.5 * r * Math.sin(getA()));
        super.polyY[2] = (int) (birdCenterY + r * Math.sin(getA() + tailleBec));
        super.hb.setPosition(getX(), getY());
        return super.getGraphic(g);
    }
}
