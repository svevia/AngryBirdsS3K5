package skin;

import java.awt.Color;
import java.awt.Graphics;

public class Canard extends Oiseau {

    public Canard() {
        super(35, 35, 3, 4, Math.PI/4, 0.7, Color.white, Color.orange, Color.blue);
    }

    /**
     * Dessine le canard sur une position x et y en un certain angle sur 
     * le Graphic g, et renvoie ce dernier
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

        // Le bec du canard
        super.polyX[0] = (int) (birdCenterX + r * Math.cos(angle - tailleBec));
        super.polyX[1] = (int) (birdCenterX + 2 * r * Math.cos(angle));
        super.polyX[2] = (int) (birdCenterX + 1.5 * r * Math.cos(angle + tailleBec));
        super.polyX[3] = (int) (birdCenterX + r * Math.cos(angle + tailleBec));
        super.polyY[0] = (int) (birdCenterY + r * Math.sin(angle - tailleBec));
        super.polyY[1] = (int) (birdCenterY + 2 * r * Math.sin(angle));
        super.polyY[2] = (int) (birdCenterY + 1.5 * r * Math.sin(angle + tailleBec));
        super.polyY[3] = (int) (birdCenterY + r * Math.sin(angle + tailleBec));
        return super.getGraphic(posX, posY, angle, g);
    }

}
