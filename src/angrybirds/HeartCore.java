package angrybirds;

import static angrybirds.Constante.*;
import entites.obstacle.Obstacle;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux thread comme
 * coeur qui bat.
 */
public class HeartCore extends Thread implements java.awt.event.ActionListener {

    /**
     * Timer de fin de jeu
     */
    javax.swing.Timer t1 = new javax.swing.Timer(2000, this);

    /**
     * Point de depart qui permet de calculer la vitesse du pigeon
     */
    private int xDepart, yDepart;

    /**
     * L'animation qui utilise le core
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
        t1.setRepeats(false);
        Constante.vitesse = vitesse;
    }

    /**
     * Le run avance le x par "step", repaint et attends un peu
     */
    @Override
    public void run() {
        xDepart = (int) bird.getCourbe().getXenT(1);
        yDepart = (int) bird.getCourbe().getYenT(1);
        action();
        anim.repaint();
        t1.start();
    }

    private void action() {
        for (Obstacle o : obstacle) {
            if (o.isMove()) {
                o.move(t);
            }
        }
        bird.move(t);
        if (bird.getCourbe().calculDistance(xDepart, yDepart, bird.getX(), bird.getY()) > vitesse) {
            anim.repaint();
            xDepart = (int) bird.getCourbe().getXenT(t);
            yDepart = (int) bird.getCourbe().getYenT(t);
            try {
                sleep(16); // 16ms pour transformer le jeu en un 60 fps
            } catch (InterruptedException ex) {
                System.out.println("Oh, my heart is broken !" + ex.getMessage());
            }
        }
        if (!last) {
            t++;
            action();
        }
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == t1) {
            gf.dispose();
            System.exit(0);
        }
    }
}
