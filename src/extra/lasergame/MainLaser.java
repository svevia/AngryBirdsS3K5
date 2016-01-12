package extra.lasergame;

import static angrybirds.Constante.obstacle;
import static angrybirds.Constante.screen;
import javax.swing.JFrame;

/**
 * Le jeu du laser, petit extra fait a partir des heritages du petit angry birds
 * Le principe est de reutiliser les classes et methodes du moteur d'angry birds 
 * pour en faire un autre mini jeu.
 * @author Wissam
 */
public class MainLaser extends JFrame implements Runnable {
    
    /**
     * Constructeur...
     */
    public MainLaser() {
        screen = new ScreenLaser();
        setDefaultCloseOperation(3); // Close
        setResizable(false); // No-resize
        setContentPane(screen);
        setSize(1920, 1080);
        setLocationRelativeTo(null); // Center
        setVisible(true);
        setTitle("Jeu du laser");
    }

    /**
     * Demarre le jeu
     */
    @Override
    public void run() {
        obstacle.add(new Objectif(500, 500, 100, 100, null));
        screen.start();
    }
}
