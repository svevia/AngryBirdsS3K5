package angrybirds.jeu.core;

import static angrybirds.Constante.*;
import static angrybirds.jeu.core.HeartMoveObstacle.*;

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
    HeartMoveBird livingBird;

    /**
     * Gere les mouvements des obstacles
     */
    HeartMoveObstacle livingWall;

    /**
     * Gere les crashs entre les entites
     */
    CrashCore crashCore = new CrashCore();

    /**
     * Boolean qui autorise aux murs de bouger
     */
    public static boolean permiseWall = true;

    /**
     * Boolean qui autorise le pigeon a bouger
     */
    public static boolean permiseBird = true;

    /**
     * Constructeur
     */
    public HeartCore() {
        t1.setRepeats(false);

    }

    /**
     * Envoie la sauce
     */
    @Override
    public void run() {
        t = 0;
        livingBird = new HeartMoveBird();
        livingWall = new HeartMoveObstacle();
        this.setName("Big Brother");
        crashCore.setName("My name is . . . Slim Shady !");
        livingBird.setName("Big jack, by Young");
        livingWall.setName("Le Beav");
        // Ces potes gérent un peu le jeu, et leur grand frère gére la ou ils marchent, rien que ça.
        boom(); // Premier batement
        t1.start();
    }

    /**
     * Une action du jeu, qui se repete, c'est ici que grand frère dit aux
     * petits qui fait quoi
     */
    private void boom() {
        crashCore.run();
        if (permiseWall) {
            livingWall.run();
        }
        if (permiseBird) {
            livingBird.run();
        }
        try {
            sleep(10); // 100 calculs par seconde, son coeur bat la chamade !
            // Il est plus rapide que le visu à 60 FPS, mais si le visu monte à 500,
            // c'est pas grave, car notre oeil ne peut capter que 60 ips.
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
     * Action qui permet d'utiliser le Timer, elle se lance apres le dernier
     * batement
     *
     * @param e
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == t1) {
            if (essai == nombreEssai) {
                gf.dispose();
                order66(); // On stop tout
            } else {
                stop();
                screen.restart(); // Ou on redémare
            }
        }
    }
}
