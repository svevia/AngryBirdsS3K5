package angrybirds;

import static angrybirds.Constante.*;
import static angrybirds.menu.FenetrePrincipale.p;
import entites.obstacle.Obstacle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux thread comme
 * coeur qui bat.
 */
public class HeartCore extends Thread implements ActionListener {

    javax.swing.Timer t1 = new javax.swing.Timer(2000, this);
    java.util.Timer t2 = new java.util.Timer();

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
        xDepart = (int) bird.getCourbe().getXenT(1);
        yDepart = (int) bird.getCourbe().getYenT(1);
        while (!last) {
            t++;
            moveAll();
        }
        refresh();
        t1.setRepeats(false);
        t1.start();
    }

    private void moveAll() {
        bird.setPosX((int) bird.getCourbe().getXenT(t));
        bird.setPosY((int) bird.getCourbe().getYenT(t));
        bird.setA(bird.getCourbe().angleAenT(t));
        if (bird.getCourbe().calculDistance(xDepart, yDepart, bird.getX(), bird.getY()) > vitesse) {
            refresh();
        }
        for (Obstacle o : obstacle) {
            if (o.isMove()) {
                o.setX((int) o.getCourbe().getXenT(t));
                o.setY((int) o.getCourbe().getYenT(t));
            }
        }
    }

    /**
     * Refresh l'animation du jeu
     */
    public void refresh() {
        refreshAll();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Fred a un soucis de sommeil:(\n" + e.getMessage());
        }
    }

    private void refreshAll() {
        anim.repaint();
        xDepart = (int) bird.getCourbe().getXenT(t);
        yDepart = (int) bird.getCourbe().getYenT(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t1) {
            gf.dispose();
            p.run();
        }
    }
}
