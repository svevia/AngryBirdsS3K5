package angrybirds;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Wissam
 */
public class GamePanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.fillOval(20, 20, 20, 20);
    }
    
}
