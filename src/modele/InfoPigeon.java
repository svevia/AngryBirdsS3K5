package modele;

import entites.bird.Bird;

/**
 * Listeur de pigeon, permet le listage simple des pigeons
 */
public class InfoPigeon {

    public int x;
    public int y;
    public Bird type;

    public InfoPigeon(int x, int y, Bird type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public InfoPigeon clone() throws CloneNotSupportedException {
        return this;
    }

    
}
