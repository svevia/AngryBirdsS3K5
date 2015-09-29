package skin;

//
//  DLC comming soon !!!
//
//package angrybirds;
//
//import java.awt.Color;
//import java.awt.Graphics;
//
//public class Shuriken extends Oiseau {
//
//    public Shuriken() {
//        super(60, 35, 5, 8, Math.PI / 4, 0, Color.LIGHT_GRAY, Color.YELLOW, Color.WHITE);
//    }
//
//    @Override
//    Graphics draw(int posX, int posY, double angle, Graphics g) {
//        super.birdCenterX = posX + fatX / 2;
//        super.birdCenterY = posY + fatY / 2;
//
//        // Le bec du canard
//        super.polyX[0] = (int) (birdCenterX + (30 * Math.cos(posX * Math.PI / 12) - Math.PI / 2));
//        super.polyX[1] = (int) (birdCenterX + (10 * Math.cos(posX * Math.PI / 12) - Math.PI / 4));
//        super.polyX[2] = (int) (birdCenterX + (30 * Math.cos(posX * Math.PI / 12)));
//        super.polyX[3] = (int) (birdCenterX + (10 * Math.cos(posX * Math.PI / 12) + Math.PI / 4));
//        super.polyX[4] = (int) (birdCenterX + (30 * Math.cos(posX * Math.PI / 12) + Math.PI / 2));
//        super.polyX[5] = (int) (birdCenterX + (10 * Math.cos(posX * Math.PI / 12) + 3 * Math.PI / 4));
//        super.polyX[6] = (int) (birdCenterX + (30 * Math.cos(posX * Math.PI / 12) + Math.PI));
//        
//        super.polyY[7] = (int) (birdCenterY + (10 * Math.sin(posX * Math.PI / 12) - Math.PI / 3));
//        super.polyY[0] = (int) (birdCenterY + (30 * Math.sin(posX * Math.PI / 12) - Math.PI / 2));
//        super.polyY[1] = (int) (birdCenterY + (10 * Math.sin(posX * Math.PI / 12) - Math.PI / 4));
//        super.polyY[2] = (int) (birdCenterY + (30 * Math.sin(posX * Math.PI / 12)));
//        super.polyY[3] = (int) (birdCenterY + (10 * Math.sin(posX * Math.PI / 12) + Math.PI / 4));
//        super.polyY[4] = (int) (birdCenterY + (30 * Math.sin(posX * Math.PI / 12) + Math.PI / 2));
//        super.polyY[5] = (int) (birdCenterY + (10 * Math.sin(posX * Math.PI / 12) + 3 * Math.PI / 4));
//        super.polyY[6] = (int) (birdCenterY + (30 * Math.sin(posX * Math.PI / 12) + Math.PI));
//        super.polyY[7] = (int) (birdCenterY + (10 * Math.sin(posX * Math.PI / 12) - Math.PI / 3));
//        return getGraphic(posX, posY, angle, g);
//    }
//
//    @Override
//    protected Graphics getGraphic(int posX, int posY, double angle, Graphics g) {
//        g.setColor(corps); // La couleur du pigeon
//        g.fillPolygon(polyX, polyY, nbPointBec);
//        return g;
//    }
//
//}
