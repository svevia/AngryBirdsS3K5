package skin;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Wissam
 */
public class RougeGorge extends Oiseau {

    public RougeGorge() {
        super(20, 20, 2, 3, Math.PI / 4, 0.7, Color.red, Color.yellow, Color.black);
    }

    /**
     * Dessine le rouge gorge sur une position x et y en un certain angle sur le
     * Graphic g, et renvoie ce dernier
     *
     * @param posX
     * @param posY
     * @param angle
     * @param g
     * @return
     */
    @Override
    public Graphics draw(int posX, int posY, double angle, Graphics g) {
        super.birdCenterX = posX + fatX / 2;
        super.birdCenterY = posY + fatY / 2;

        // Le bec du rouge gorge
        super.polyX[0] = (int) (birdCenterX + r * Math.cos(angle - tailleBec));
        super.polyX[1] = (int) (birdCenterX + 1.5 * r * Math.cos(angle));
        super.polyX[2] = (int) (birdCenterX + r * Math.cos(angle + tailleBec));
        super.polyY[0] = (int) (birdCenterY + r * Math.sin(angle - tailleBec));
        super.polyY[1] = (int) (birdCenterY + 1.5 * r * Math.sin(angle));
        super.polyY[2] = (int) (birdCenterY + r * Math.sin(angle + tailleBec));
        return super.getGraphic(posX, posY, angle, g);
    }

}
