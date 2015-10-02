package skin.oiseau;

import java.awt.Color;
import java.awt.Graphics;
import skin.Bird;

public class Soucoupe extends Bird {

    public Soucoupe() {
        super(60, 35, 5, 4, Math.PI / 4, 0, Color.LIGHT_GRAY, Color.YELLOW, Color.WHITE);
    }

    @Override
    public Graphics draw(int posX, int posY, double angle, Graphics g) {
        super.birdCenterX = posX + fatX / 2;
        super.birdCenterY = posY + fatY / 2;

        // Le bec du canard
        super.polyX[0] = (int) (birdCenterX - 15);
        super.polyX[1] = (int) (birdCenterX + 15);
        super.polyX[2] = (int) (birdCenterX + 30);
        super.polyX[3] = (int) (birdCenterX - 30);
        super.polyY[0] = (int) (birdCenterY);
        super.polyY[1] = (int) (birdCenterY);
        super.polyY[2] = (int) (birdCenterY + 30);
        super.polyY[3] = (int) (birdCenterY +30);
        return getGraphic(posX, posY, angle, g);
    }

    @Override
    protected Graphics getGraphic(int posX, int posY, double angle, Graphics g) {
        g.setColor(corps); // La couleur du pigeon
        g.fillArc(posX, posY, fatX, fatY, 0, 180);
        g.setColor(bec);  // La couleur du bec
        g.fillPolygon(polyX, polyY, polyX.length); // Le bec
        g.setColor(oeil); // La couleur de son oeil droit
        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil))+10, (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil))-8, tailleOeil, tailleOeil); // Son oeil droit
        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil))-12, (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil))-8, tailleOeil, tailleOeil); // Son oeil droit
        return g;
    }

}
