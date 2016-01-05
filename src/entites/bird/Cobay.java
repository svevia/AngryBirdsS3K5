package entites.bird;

import static angrybirds.Constante.vitesse;
import entites.Skin;
import entites.bird.power.DoubleMasse;
import entites.bird.power.OndeChocPower;
import entites.bird.power.SpeedPower;
import entites.bird.power.StandTheWorld;
import entites.bird.power.Teleportation;
import java.awt.Color;
import java.awt.Font;
import modele.Courbe;

/**
 * Petit pigeon hors serie reserve aux grands, sa puissance est tel qu'il sera
 * interdit au public
 */
public class Cobay extends Bird {

    public Cobay(Courbe c) {
        super(0, 0, 20, 1000, c, Color.black);
        power.add(new Teleportation());
        power.add(new SpeedPower());
        power.add(new DoubleMasse());
        power.add(new OndeChocPower());
        power.add(new StandTheWorld());
    }

    @Override
    public Skin draw(Skin s) {
        s.getG().setFont(new Font(null, Font.BOLD, 10));
        s.getG().setColor(Color.red);
        s.getG().drawString("Vitesse : " + vitesse, x + 10, y-20);
        s.getG().drawString("Masse : " + masse, x + 10, y-10);
        return super.draw(s);
    }
    
    

}
