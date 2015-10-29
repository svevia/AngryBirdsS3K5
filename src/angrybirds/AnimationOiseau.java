package angrybirds;

import java.awt.Graphics;
import static angrybirds.Constante.*;
import entites.Collision;
import javax.swing.JPanel;

/**
 * La class principale du programme la ou se consentre aussi le visualisateur du
 * jeu, le moteur de collision, le thread principal du jeu et la courbe engage
 * par l'oiseau
 */
public class AnimationOiseau extends JPanel {

    /**
     * Le visualisateur
     */
    private Visualisateur visu;

    /**
     * Gestionnaire de collision
     */
    private Collision stun;

    /**
     * Thread de l'animation
     */
    private Thread core;

    /**
     * Courbe qu'aura le pigeon, qui prendra ses parametres dans le constructeur
     */
    private Courbe courbe;

    /**
     * Securite
     */
    private AnimationOiseau() {
    }

    /**
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe en trois points
     *
     * @param x point de depart en x
     * @param a ax²
     * @param b + bx
     * @param c + c
     */
    public AnimationOiseau(double a, double b, double c) {
        courbe = new Courbe(a, b, c);
    }

    /**
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe
     *
     * @param c Courbe
     */
    public AnimationOiseau(Courbe c) {
        courbe = c;
    }

    /**
     * Initializer, initialisant la classe
     */
    {
        setDoubleBuffered(true);
        visu = new Visualisateur(); // Gestionnaire d'affichage
        stun = new Collision(this); // Gestionnaire de collision
        core = new Thread(new HeartCore(5, this)); // Gestionnaire d'evenement
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        core.start();
    }

    /**
     * Arrete le thread du jeu et relance un nouveau jeu
     */
    public void arret() {
        core.stop();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Probleme de sommeil\n" + ex.getMessage());
        }
        gf.dispose();
        LivOne.p.run();
    }

    /**
     * Le painteur du jeu
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        addFootstepCoord();
        g = visu.drawAllNeed(g);
        stun.verif();
    }

    /**
     * Fonction qui ajoute les coordonnes actuel a une liste
     */
    private void addFootstepCoord() {
        footstepX.add(bird.getPosX());
        footstepY.add(bird.getPosY() + bird.getR());
        footstepA.add(courbe.angleNextD(bird.getPosX()));
    }

    public Courbe getCourbe() {
        return courbe;
    }

    public Thread getCore() {
        return core;
    }
}
