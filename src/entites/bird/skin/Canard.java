package entites.bird.skin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import entites.bird.Bird;

/**
 * Class permettante de dessiner un canard
 */
public class Canard extends Bird {

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public Canard() {
        super(0, 0, 35, 35, 3, 4, Math.PI / 4, 0.7, Color.white, Color.orange, Color.blue);
        super.hb.setD(new Dimension((int) (35 * 1.5), (int) (35 * 1.5)));
    }

    /**
     * Dessine le canard sur une position x et y en un certain getA sur le
 Graphic g, et renvoie ce dernier
     *
     * @param getPosX()
     * @param posY
     * @param angle
     * @param g
     * @return
     */
    @Override
    public Graphics draw(Graphics g) {
        super.birdCenterX = getPosX() + getWidht() / 2;
        super.birdCenterY = getPosY() + getHight() / 2;
        
        // Le bec du canard
        super.polyX[0] = (int) (birdCenterX + r * Math.cos(getA() - tailleBec));
        super.polyX[1] = (int) (birdCenterX + 2 * r * Math.cos(getA()));
        super.polyX[2] = (int) (birdCenterX + 1.5 * r * Math.cos(getA() + tailleBec));
        super.polyX[3] = (int) (birdCenterX + r * Math.cos(getA() + tailleBec));
        super.polyY[0] = (int) (birdCenterY + r * Math.sin(getA() - tailleBec));
        super.polyY[1] = (int) (birdCenterY + 2 * r * Math.sin(getA()));
        super.polyY[2] = (int) (birdCenterY + 1.5 * r * Math.sin(getA() + tailleBec));
        super.polyY[3] = (int) (birdCenterY + r * Math.sin(getA() + tailleBec));
        super.hb.setPosition(getPosX(), getPosY());
        return super.getGraphic(g);
    }
}
