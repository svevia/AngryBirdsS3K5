package entites.bird.skin;

//package skin.oiseau;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import skin.Bird;
//
///**
// *  Cree une soucoupe avec deux fenetre et une lumiere
// */
//public class Soucoupe extends Bird {
//
//    /**
//     *
//     */
//    public Soucoupe() {
//        super(0, 0, 60, 35, 5, 4, Math.PI / 4, 0, Color.LIGHT_GRAY, Color.YELLOW, Color.WHITE);
//    }
//
//    @Override
//    public Graphics draw(int posX, int posY, double angle, Graphics g) {
//        super.birdCenterX = posX + fatX / 2;
//        super.birdCenterY = posY + fatY / 2;
//
//        // La lumiere de la soucoupe
//        super.polyX[0] = (int) (birdCenterX - 15);
//        super.polyX[1] = (int) (birdCenterX + 15);
//        super.polyX[2] = (int) (birdCenterX + 30);
//        super.polyX[3] = (int) (birdCenterX - 30);
//        super.polyY[0] = (int) (birdCenterY);
//        super.polyY[1] = (int) (birdCenterY);
//        super.polyY[2] = (int) (birdCenterY + 30);
//        super.polyY[3] = (int) (birdCenterY +30);
//        return getGraphic(posX, posY, angle, g);
//    }
//
//    /**
//     * Vue que la soucope a deux fenetre, considere comme des oeils, il a fallut
//     * override la fonction
//     * @param posX
//     * @param posY
//     * @param angle
//     * @param g
//     * @return 
//     */
//    @Override
//    protected Graphics getGraphic(int posX, int posY, double angle, Graphics g) {
//        g.setColor(corps); // La couleur du pigeon
//        g.fillArc(posX, posY, fatX, fatY, 0, 180);
//        g.setColor(bec);  // La couleur du bec
//        g.fillPolygon(polyX, polyY, polyX.length); // Le bec
//        g.setColor(oeil); // La couleur de son oeil droit
//        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil))+10, (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil))-8, tailleOeil, tailleOeil); // Son oeil droit
//        g.fillOval((int) (birdCenterX + (positionOeil * r) * Math.cos(angle - positionOeil))-12, (int) (birdCenterY + (positionOeil * r) * Math.sin(angle - positionOeil))-8, tailleOeil, tailleOeil); // Son oeil droit
//        return g;
//    }
//
//}
