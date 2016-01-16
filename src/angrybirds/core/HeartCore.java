package angrybirds.core;

import static angrybirds.Constante.*;

/**
 * Cette class a pour but de gerer l'avancement du projet grace aux threads
 * comme coeur qui bat. Un grand coeur <3.
 */
public class HeartCore extends Thread implements java.awt.event.ActionListener {

    /**
     * Timer de fin de jeu
     */
    javax.swing.Timer t1 = new javax.swing.Timer(2000, this);

    /**
     * "L'horloge" du jeu, le coeur en a besoin pour fait boom, boom, boom...
     */
    public static int t = 1;

    /**
     * Gere les mouvements des oiseaux
     */
    HeartMoveBird livingBird = new HeartMoveBird();

    /**
     * Gere les mouvements des obstacles
     */
    HeartMoveObstacle livingWall = new HeartMoveObstacle();

    /**
     * Gere les crashs entre les entites
     */
    CrashCore crashCore = new CrashCore();

    /**
     * Constructeur
     */
    public HeartCore() {
        t1.setRepeats(false);

        this.setName("Bob");
        livingBird.setName("John");
        livingWall.setName("Michael");
        crashCore.setName("Dick");
    }

    /**
     * Envoie la sauce
     */
    @Override
    public void run() {
        boom();
        t1.start();
    }

    /**
     * Une action du jeu, qui se repete
     */
    private void boom() {
        livingBird.run();
        livingWall.run();
        crashCore.run();
        try {
            sleep(10); // 100 calculs par seconde, son coeur bat la chamade
        } catch (InterruptedException ex) {
            System.out.println("Oh, my heart is broken ! I need more love programer :3" + ex.getMessage());
        }
        // Si ce n'est pas le dernier bâtement, il recommence
        if (!last) {
            t++;
            boom();
        }
    }

    /**
     * Action qui permet d'utiliser le Timer
     *
     * @param e
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == t1) {
            gf.dispose();
            order66();
        }
    }
}
