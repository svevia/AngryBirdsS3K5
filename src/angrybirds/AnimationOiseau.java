package angrybirds;

import java.awt.Graphics;
import static angrybirds.Constante.*;
import entites.Collision;
import javax.swing.JPanel;

/**
 * La classe principale du programme la ou se consentre aussi le visualisateur
 * du jeu, le moteur de collision, le thread principal du jeu et la courbe
 * engage par l'oiseau
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
     * Le constructeur est en prive pour ne pas pouvoir l'appeler
     */
    private AnimationOiseau() {
    }

    /**
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe en trois points
     *
     * @param a ax au carre
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

    {
        setDoubleBuffered(true);
        visu = new Visualisateur(); // Gestionnaire d'affichage
        stun = new Collision(this); // Gestionnaire de collision
        core = new Thread(new HeartCore(4, this)); // Gestionnaire d'evenement
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        core.start();
    }

    /**
     * Le painteur du jeu
     *
     * @param g Le graphics sur le quelle dessiner
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        addFootstepCoord();
        g = visu.drawAllNeed(g);
        //g = visu.drawAllHitBox(g);
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

    /**
     * Retourne le courbe de l'animation
     *
     * @return La courbe
     */
    public Courbe getCourbe() {
        return courbe;
    }

    /**
     * Retourne le thread du jeu
     *
     * @return Le thread du jeu
     */
    public Thread getCore() {
        return core;
    }
}
