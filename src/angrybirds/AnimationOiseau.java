package angrybirds;

import java.awt.Graphics;
import javax.swing.JFrame;
import static angrybirds.Constante.*;
import entites.Collision;

/**
 * La class principale du programme
 */
public class AnimationOiseau extends JFrame {

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
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe
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
     * Initializer, initialisant la class
     */
    {
        setTitle("Angry Fly Test : " + angrybirds.AngryBirds.p.i);
        setResizable(false);
        setSize(fenetre);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        visu = new Visualisateur(); // Gestionnaire d'affichage
        stun = new Collision(this); // Gestionnaire de collision
        core = new Thread(new HeartCore(40, 7, this)); // Gestionnaire d'evenement
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
        dispose();
        AngryBirds.p.run();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        addFootstepCoord();
        g = visu.drawFond(g);
        g = visu.drawFootstep(false, 5, g);
        g = visu.drawOiseau(g);
        g = visu.drawObstacle(g);
        stun.verif();
    }

    /**
     * Fonction qui ajoute les coordonnes actuel a une liste
     */
    private void addFootstepCoord() {
        footstepX.add(bird.getPosX());
        footstepY.add(bird.getPosY() + bird.getR());
        footstepA.add(courbe.getCoefficientDirecteur(bird.getPosX()));
    }
    
    public Courbe getCourbe() {
        return courbe;
    }
}
