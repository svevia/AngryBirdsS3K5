package modele;

import java.awt.Image;
import java.awt.Toolkit;


/**
 *
 * @author Wissam
 */
public class ImageCustomz {

    int posX;

    int posY;

    String src;

    public ImageCustomz(int posX, int posY, String src) {
        this.posX = posX;
        this.posY = posY;
        this.src = src;
    }

    private ImageCustomz() {
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
    
    public Image getImage() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource(src));
    }

    @Override
    public String toString() {
        return "Image source : " + src + " ; Position en X : " + posX + " ; Position en Y : " + posY + " ; ";
    }
}
