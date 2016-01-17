package entites.bird;

import java.awt.Color;
import entites.bird.module.BecTriangulaire;
import entites.bird.module.Oeil;
import entites.bird.power.SpeedPower;
import modele.Courbe;

/**
 * Class permettante de dessiner un oiseau tout rouge
 */
public class RougeGorge extends Bird {

    private BecTriangulaire bec = new BecTriangulaire(2, Math.PI / 4, 1, this, Color.orange);
    private Oeil oeil = new Oeil(8, this, true, 3, Color.BLACK);

    /**
     * Constructeur de la class creeant automatiquement l'oiseau
     */
    public RougeGorge(Courbe c) {
        super(0, 0, 20, 50, c, Color.red);
        addModule(bec);
        addModule(oeil);
        power.add(new SpeedPower());
    }
}
