package angrybirds;

import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux thread comme
 * coeur qui bat.
 */
public class HeartCore extends Thread implements ActionListener {

    Timer t1 = new Timer(2000, this);

    /**
     * Point de depart qui permet de calculer la vitesse du pigeon
     */
    private int xDepart, yDepart;

    /**
     * L'animation utilise
     */
    public AnimationJeu anim;

    /**
     * "L'horloge" du jeu
     */
    public static int t = 1;

    /**
     *
     * @param vitesse
     * @param animationOiseau
     */
    public HeartCore(int vitesse, AnimationJeu animationOiseau) {
        anim = animationOiseau;
        Constante.vitesse = vitesse;
    }

    /**
     * Le run avance le x par "step", repaint et attends un peu
     */
    @Override
    public void run() {
        t1.setRepeats(false);
        xDepart = (int) bird.getCourbe().getXenT(1);
        yDepart = (int) bird.getCourbe().getYenT(1);
        moveAll();
        anim.repaint();
        t1.start();
    }

    private void moveAll() {
        for (Obstacle o : obstacle) {
            if (o.isMove()) {
                o.setX((int) o.getCourbe().getXenT(t));
                o.setY((int) o.getCourbe().getYenT(t));
            }
        }
        bird.setX((int) bird.getCourbe().getXenT(t));
        bird.setY((int) bird.getCourbe().getYenT(t));
        bird.setA(bird.getCourbe().angleAenT(t));

        if (bird.getCourbe().calculDistance(xDepart, yDepart, bird.getX(), bird.getY()) > vitesse) {
            anim.repaint();
            xDepart = (int) bird.getCourbe().getXenT(t);
            yDepart = (int) bird.getCourbe().getYenT(t);
            try {
                sleep(30);
            } catch (InterruptedException ex) {
                System.out.println("Il a fait un arret cardiac !" + ex.getMessage());
            }
        }
        if (!last) {
            t++;
            moveAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t1) {
            gf.dispose();
        }
    }
}
