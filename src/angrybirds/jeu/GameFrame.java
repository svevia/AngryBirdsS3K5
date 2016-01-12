package angrybirds.jeu;

import angrybirds.Constante;
import static angrybirds.Constante.iniz;
import static angrybirds.Constante.screen;
import javax.swing.JFrame;

/**
 * La fenetre du jeu
 */
public class GameFrame extends JFrame implements Runnable {

    /**
     * Constructeur remettant tout a 0 et affichant une nouvelle fenetre avec le
     * jeu en pannel
     */
    public GameFrame() {
        iniz();
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

    /**
     * Remet tout a 0 et reaffiche le pannel dans la même fenetre (contrairement
     * au constructeur qui change de fenetre)
     */
    @Override
    public void run() {
        screen.start();
    }
}
