package angrybirds;

import static angrybirds.Constante.screen;
import static angrybirds.Constante.gReader;
import static angrybirds.Constante.indexPFAGUtilise;
import static angrybirds.Constante.iniz;
import angrybirds.jeu.Screen;
import entites.obstacle.Obstacle;
import javax.swing.JFrame;
import modele.PFAGReader;

/**
 * La fenetre du jeu
 */
public class GameFrame extends JFrame implements Runnable {

    public GameFrame() {
        iniz();
        Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
        screen = new Screen();
        setDefaultCloseOperation(3);
        setResizable(false);
        setContentPane(screen);
        setSize(Constante.fenetre.getSize());
        setLocationRelativeTo(null);
        setVisible(true);
        //   setIconImage(Toolkit.getDefaultToolkit().getImage("ressource/icon.png"));
        setTitle("Angry Birds");
    }

    @Override
    public void run() {
        iniz();
        Obstacle.addListObstacle(gReader.listeObstacle(PFAGReader.listePFAG().get(indexPFAGUtilise)));
        screen.start();
    }
}
