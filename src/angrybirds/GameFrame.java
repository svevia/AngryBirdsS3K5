package angrybirds;

import static angrybirds.Constante.gReader;
import static angrybirds.Constante.indexPFAGUtilise;
import static angrybirds.Constante.iniz;
import entites.obstacle.Obstacle;
import java.io.IOException;
import javax.swing.JFrame;
import ressource.PFAGReader;

/**
 * La fenetre du jeu
 */
public class GameFrame extends JFrame implements Runnable {

    /**
     * Le jeu sous panel
     */
    private AnimationJeu jeu;

    public GameFrame() {
        try {
            iniz();
            Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
            jeu = new AnimationJeu();
            setDefaultCloseOperation(3);
            setResizable(false);
            setContentPane(jeu);
            setSize(Constante.fenetre.getSize());
            setLocationRelativeTo(null);
            setVisible(true);
         //   setIconImage(Toolkit.getDefaultToolkit().getImage("ressource/icon.png"));
            setTitle("Angry Birds");
        } catch (IOException ex) {
            System.out.println("Bug GameFrame Iniz" + ex.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            iniz();
            Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
            jeu.start();
        } catch (IOException ex) {
            System.out.println("Bug GameFrame Iniz");
        }
    }
}
