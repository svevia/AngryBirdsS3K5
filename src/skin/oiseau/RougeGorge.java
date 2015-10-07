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
                super.birdCenterX = super.x + super.widht / 2;
        super.birdCenterY = super.y + super.hight / 2;

        // Le bec du rouge gorge
        super.polyX[0] = (int) (birdCenterX + r * Math.cos(super.a - tailleBec));
        super.polyX[1] = (int) (birdCenterX + 1.5 * r * Math.cos(super.a));
        super.polyX[2] = (int) (birdCenterX + r * Math.cos(super.a + tailleBec));
        super.polyY[0] = (int) (birdCenterY + r * Math.sin(super.a - tailleBec));
        super.polyY[1] = (int) (birdCenterY + 1.5 * r * Math.sin(super.a));
        super.polyY[2] = (int) (birdCenterY + r * Math.sin(super.a + tailleBec));
        super.hb.setPosition(super.x, super.y);
        return super.getGraphic(super.x, super.y, super.a, g);
    }
}
