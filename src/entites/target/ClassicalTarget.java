package entites.target;

import entites.Skin;
import static entites.target.TargetListener.forceActuel;
import java.awt.Color;
import static modele.Calcul.angle;
import static modele.Calcul.force;

/**
 *
 */
public class ClassicalTarget extends Target {

    public ClassicalTarget() {
        rayonDeLaForce = 300;
        rayonCentral = 300 * 20 / 100;
    }

    @Override
    public Skin draw(Skin s, int centreX, int centreY, int mouseX, int mouseY) {
        s.getG().setColor(new Color(50, 50, 200, 50));
        s.getG().fillOval(centreX - rayonCentral / 2, centreY - rayonCentral / 2, rayonCentral, rayonCentral);
        s.getG().drawOval(centreX - rayonDeLaForce / 2, centreY - rayonDeLaForce / 2, rayonDeLaForce, rayonDeLaForce);
        s.getG().drawLine(centreX, centreY, mouseX, mouseY);
        s.getG().setColor(Color.black);
        s.getG().drawString(angle(centreX, centreY, mouseX, mouseY) + " r", centreX + 10, centreY - 10);
        s.getG().setColor(Color.red);
        forceActuel = force(centreX, centreY, mouseX, mouseY, rayonDeLaForce);
        s.getG().drawString(forceActuel + "%", centreX + 20, centreY + 10);
        return s;
    }

}
