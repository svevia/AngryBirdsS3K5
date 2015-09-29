package skin;

import java.awt.Color;
import java.awt.Graphics;

public class Papillon extends Oiseau {

    public Papillon() {
        super(50, 20, 2, 4, Math.PI/4, 0.7, Color.LIGHT_GRAY, Color.BLACK, Color.PINK);
    }

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
        return getGraphic(posX, posY, angle, g);
    }

    @Override
    protected Graphics getGraphic(int posX, int posY, double angle, Graphics g) {
        g.setColor(corps); // La couleur du pigeon
        g.fillArc(posX, posY, fatX, fatY, 0, 360);
        g.setColor(bec);  // La couleur du bec
       // g.fillPolygon(polyX, polyY, polyX.length); // Le bec
        g.setColor(oeil); // La couleur de son oeil droit
      //  g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil)), (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil)), tailleOeil, tailleOeil); // Son oeil droit
        return g;
    }

}
